package edu.rafat.tushar.onlinestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordRecovery extends AppCompatActivity {

    private EditText emailPREditText;
    private Button recoveryPRBtn;

    private ProgressBar passRecoveryPRProgressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);
        this.setTitle("Password Recovery");

        emailPREditText = (EditText) findViewById(R.id.emailPREditText);
        recoveryPRBtn = (Button) findViewById(R.id.recoveryPRBtn);

        passRecoveryPRProgressBar = (ProgressBar) findViewById(R.id.passRecoveryPRProgressBar);

        mAuth = FirebaseAuth.getInstance();

        recoveryPRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                passwordRecovery();
            }
        });


    }


    private void passwordRecovery()
    {
        String email;
        email = emailPREditText.getText().toString().trim();


        if(email.isEmpty())
        {
            emailPREditText.setError("Enter an email address");
            emailPREditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailPREditText.setError("Enter a valid email address");
            emailPREditText.requestFocus();
            return;
        }

        passRecoveryPRProgressBar.setVisibility(View.VISIBLE);

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                passRecoveryPRProgressBar.setVisibility(View.GONE);
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"An email is send to your email. Please check to reset the password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
