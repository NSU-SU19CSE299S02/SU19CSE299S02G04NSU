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

        Button logInBtn = (Button) findViewById(R.id.logInBtn);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Activity
            }
        });
        getSupportActionBar().setTitle("Login Form");
    }

    public void btn_LogIn(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    public void btn_signUp(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }
}
