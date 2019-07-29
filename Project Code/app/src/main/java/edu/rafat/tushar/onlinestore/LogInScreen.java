package edu.rafat.tushar.onlinestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);
    }

    public void btn_forgotPassword(View view) {
        startActivity(new Intent(getApplicationContext(),PasswordRecovery.class));
    }

    public void btn_Signup(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }

    public void btn_login(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
