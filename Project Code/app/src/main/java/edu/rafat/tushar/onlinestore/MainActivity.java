package edu.rafat.tushar.onlinestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button trackintBtn, bookingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trackintBtn = (Button) findViewById(R.id.trackingBtn);
        bookingBtn = (Button) findViewById(R.id.bookingBtn);

        trackintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });

    }

    public void btn_storeInfo(View view) {
        startActivity(new Intent(getApplicationContext(),StoreInfo.class));
    }

    public void btn_profile(View view) {
        startActivity(new Intent(getApplicationContext(),ProfileScreen.class));
    }
    public void setBookingBtn(View view) {
        startActivity(new Intent(getApplicationContext(),StoreList.class));
    }


}
