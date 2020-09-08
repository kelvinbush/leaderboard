package com.kelvinwachiye.leaderboard.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.kelvinwachiye.leaderboard.R;
import com.kelvinwachiye.leaderboard.apiutils.RetroClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {
    private static final String TAG = "SubmissionActivity";
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText linkEditText;
    private Dialog mDialog;
    private ImageView mImageView;
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        emailEditText = findViewById(R.id.email);
        linkEditText = findViewById(R.id.link);
    }

    public void submitProject(View view) {
        if (isValid(firstNameEditText) && isValid(lastNameEditText)
                && isValid(emailEditText) && isValid(linkEditText)) {
            confirmDialog();
        }
    }

    private boolean isValid(EditText editText) {
        String string = editText.getText().toString();
        if (string.length() == 0 || string.trim().equals("")) {
            editText.setError(getString(R.string.error), ContextCompat.getDrawable(this,
                    R.drawable.ic_baseline_error_outline_24));
            Toast.makeText(this, R.string.fill_all, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void backToMain(View view) {
        finish();
    }

    private void confirmDialog() {
        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.confirmdialog);
        mDialog.setTitle(" ");

        mCardView = mDialog.findViewById(R.id.yes);
        mImageView = mDialog.findViewById(R.id.cancel);

        mCardView.setEnabled(true);
        mImageView.setEnabled(true);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubmissionActivity.this, R.string.submitting_dialog, Toast.LENGTH_SHORT).show();
                submitToForms();
                mDialog.dismiss();
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SubmissionActivity.this, R.string.cancelling_dialog, Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        });
        mDialog.show();
    }

    private void submitToForms() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String link = linkEditText.getText().toString();
        Call<Void> call = RetroClass.getGoogleApiService().createPost(email,
                firstName, lastName, link);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    submissionSuccess();
                    Log.d(TAG, "onResponse: " + response.code());
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                submissionFailed();
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void submissionSuccess() {
        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.successdialog);
        mDialog.setTitle("");
        mDialog.show();
    }

    private void submissionFailed() {
        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.faildialog);
        mDialog.setTitle("");
        mDialog.show();
    }

}