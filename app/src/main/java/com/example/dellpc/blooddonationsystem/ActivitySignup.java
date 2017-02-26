package com.example.dellpc.blooddonationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ActivitySignup extends AppCompatActivity {
    EditText EditFirstName;
    EditText EditLastName;
    EditText EditEmail;
    Spinner SelectSpinner;
    EditText EditPass;
    Button BtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    }
}
