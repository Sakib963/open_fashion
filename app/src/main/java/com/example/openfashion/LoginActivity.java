package com.example.openfashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    AppCompatEditText phoneNoEditText, passwordEditText;
    AppCompatCheckBox rememberMeCheckBox;

    AppCompatButton submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneNoEditText = findViewById(R.id.phone_no_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        rememberMeCheckBox = findViewById(R.id.remember_me_checkbox);

        submitButton = findViewById(R.id.submit_button);

        String phoneNumber = phoneNoEditText.getText().toString();
        String password = passwordEditText.getText().toString();

//        if(phoneNumber.length() == 0 || ){
//            phoneNoEditText.setError("Please Input your phone number");
//        }
//        else if(password.length() < 6){
//            passwordEditText.setError("Password have to at least 6 characters");
//        }
//        else

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }

}