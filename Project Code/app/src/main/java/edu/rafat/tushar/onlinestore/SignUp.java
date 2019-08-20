package edu.rafat.tushar.onlinestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private EditText FullNameEditText, UserNameEditText, EmailEditText,
            ConfirmEmailEditText, PasswordEditText,ConfirmPasswordEditText;
    private Button Register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FullNameEditText = findViewById(R.id.FullNameEditText);
        UserNameEditText = findViewById(R.id.UserNameEditText);
        EmailEditText = findViewById(R.id.EmailEditText);
        ConfirmEmailEditText = findViewById(R.id.ConfirmEmailEditText);
        PasswordEditText = findViewById(R.id.PasswordEditText);
        ConfirmPasswordEditText = findViewById(R.id.ConfirmPasswordEditText);

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
        String CEmail = ConfirmEmailEditText.getText().toString().trim();
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

        if(CEmail.isEmpty())
        {
            ConfirmPasswordEditText.setError("Enter an email address");
            ConfirmPasswordEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches())
        {
            ConfirmPasswordEditText.setError("Enter a valid email address");
            ConfirmPasswordEditText.requestFocus();
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







    }
}
