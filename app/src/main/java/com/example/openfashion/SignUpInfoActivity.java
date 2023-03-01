package com.example.openfashion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SignUpInfoActivity extends AppCompatActivity {

    AppCompatEditText dateOfBirth;
    DatePickerDialog picker;

    String[] genders = {"Male", "Female", "Others"};
    AutoCompleteTextView genderAutoCompleteText ;

    ArrayAdapter<String> genderAdapterItems;

    String phone_number;

    AppCompatEditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_info);

        dateOfBirth = findViewById(R.id.dob_edit_text);
        genderAutoCompleteText = findViewById(R.id.auto_complete_text);
        phoneNumberEditText = findViewById(R.id.phone_no_edit_text);

        Intent intent = getIntent();
        phone_number = intent.getStringExtra("phone_number");
        phoneNumberEditText.setText(phone_number);

        // Setting Up Date Picker on EditText
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                // Date Picker Dialog
                picker = new DatePickerDialog(SignUpInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateOfBirth.setText(dayOfMonth + "/"+ (month+1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        // Setting Gender Text Area

        genderAdapterItems = new ArrayAdapter<String>(this, R.layout.gender_list_item, genders);
        genderAutoCompleteText.setAdapter(genderAdapterItems);

        genderAutoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gender = parent.getItemAtPosition(position).toString();
                Toast.makeText(SignUpInfoActivity.this, "Gender: "+gender, Toast.LENGTH_SHORT).show();
            }
        });
    }
}