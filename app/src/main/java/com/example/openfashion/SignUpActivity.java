package com.example.openfashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    AppCompatEditText phoneInputEditText, passwordEditText, retypePasswordEditText;
    AppCompatButton submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        phoneInputEditText = findViewById(R.id.phone_no_edit_text);
        submit_button = findViewById(R.id.submit_button);
        passwordEditText = findViewById(R.id.password_edit_text);
        retypePasswordEditText = findViewById(R.id.retype_password_edit_text);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phoneInputEditText.getText().toString();
                if(phone.length() >= 11){

                    String password = passwordEditText.getText().toString();
                    String retypePassword = retypePasswordEditText.getText().toString();

                    if (password.equals(retypePassword) && password.length() >= 6){
                        Intent intent = new Intent(SignUpActivity.this, SignUpInfoActivity.class);
                        intent.putExtra("phone_number",phone);
                        startActivity(intent);

                        Toast.makeText(SignUpActivity.this, "Input: "+phone, Toast.LENGTH_SHORT).show();
                    }
                    else if(!password.equals(retypePassword)){
                        passwordEditText.setError("Password do not match");
                        retypePasswordEditText.setError("Password do not match");
                    }
                    else{
                        passwordEditText.setError("Password must be at least 6 characters");
                    }
                }
                else {
                    phoneInputEditText.setError("Phone Number Must Be 11 Digits");
                }
            }
        });
    }
}