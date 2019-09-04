package com.codepath.bledstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";

    private EditText etUserNameS;
    private EditText etEmailS;
    private EditText etPasswordS;
    private EditText etPasswordConfirmS;
    private Button btnSignUp;
    private TextView tvLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUserNameS = findViewById(R.id.etUserNameS);
        etPasswordS = findViewById(R.id.etPasswordS);
        btnSignUp = findViewById(R.id.btnSignUp);
        etEmailS = findViewById(R.id.etEmailS);
        etPasswordConfirmS = findViewById(R.id.etPasswordConfirmS);
        tvLoginBack = findViewById(R.id.tvLoginback);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUserNameS.getText().toString().isEmpty() || etEmailS.getText().toString().isEmpty() || etPasswordS.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "field required", Toast.LENGTH_SHORT).show();
                    if (etPasswordS.getText().toString() != etPasswordConfirmS.getText().toString()) {
                        Toast.makeText(SignUpActivity.this, "Confirmation failed", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                String username = etUserNameS.getText().toString();
                String email = etEmailS.getText().toString();
                String password = etPasswordS.getText().toString();
                //String passwordConfirm = etPasswordConfirmS.getText().toString();

                //Create user
                ParseUser user = new ParseUser();

                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "cannot signing up");
                            e.printStackTrace();
                            return;
                        }
                        etUserNameS.setText("");
                        etEmailS.setText("");
                        etPasswordS.setText("");
                        etPasswordConfirmS.setText("");
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
            }

        });

        tvLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

   /* private void goMainActivity() {
        Log.d(TAG, "navigating to main activity");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }*/
}
