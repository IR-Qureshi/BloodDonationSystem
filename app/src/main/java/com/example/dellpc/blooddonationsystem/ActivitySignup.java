package com.example.dellpc.blooddonationsystem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ActivitySignup extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText EditFirstName;
    EditText EditLastName;
    EditText EditEmail;
    Spinner SelectSpinner;
    EditText EditPass;
    Button BtnSignUp;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = mFirebaseDatabase.getInstance();

        EditFirstName  = (EditText) findViewById(R.id.EditFirstName);
        EditLastName  = (EditText) findViewById(R.id.EditLastName);
        EditEmail  = (EditText) findViewById(R.id.EditEmail);
        EditPass  = (EditText) findViewById(R.id.EditPass);
        SelectSpinner = (Spinner) findViewById(R.id.SpinnerAdd);
        BtnSignUp = (Button) findViewById(R.id.BtnSignUp);

    }
    public void SignUp2(View view){
        mFirebaseAuth.createUserWithEmailAndPassword(EditEmail.getText().toString(),EditPass.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(ActivitySignup.this, "failed to sign up",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}
