package edu.rafat.tushar.onlinestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private EditText FullNameEditText, UserNameEditText, EmailEditText,
            ConfirmEmailEditText, PasswordEditText,ConfirmPasswordEditText;
    private Button Register_button;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.setTitle("Sign Up");

        mAuth = FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressbarId);

       // FullNameEditText = findViewById(R.id.FullNameEditText);
        //UserNameEditText = findViewById(R.id.UserNameEditText);
        EmailEditText = findViewById(R.id.EmailEditText);
        //ConfirmEmailEditText = findViewById(R.id.ConfirmEmailEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        //ConfirmPasswordEditText = findViewById(R.id.ConfirmPasswordEditText);

        Register_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.Register_button:
                UserRegister();
                break;

        }

    }

    private void UserRegister() {
       // String FName = FullNameEditText.getText().toString().trim();
      //  String UName = UserNameEditText.getText().toString().trim();
        String Email = EmailEditText.getText().toString().trim();
        //String CEmail = ConfirmEmailEditText.getText().toString().trim();
        String Pass = PasswordEditText.getText().toString().trim();
      //  String CPass = ConfirmPasswordEditText.getText().toString().trim();


        if(Email.isEmpty())
        {
            EmailEditText.setError("Enter an email address");
            EmailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            EmailEditText.setError("Enter a valid email address");
            EmailEditText.requestFocus();
            return;
        }

        if(Pass.isEmpty())
        {
            PasswordEditText.setError("Enter a password");
            PasswordEditText.requestFocus();
            return;
        }

        if(Pass.length()<6)
        {
            PasswordEditText.setError("Minimum length of the password should be 6");
            PasswordEditText.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Register is successful", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Register is not successful", Toast.LENGTH_SHORT).show();

                }

            }
        })




    }
}
