package edu.rafat.tushar.onlinestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StoreList extends AppCompatActivity {

    private ListView storeListView;
    private FirebaseAuth mAuth; // Create FireBase object for Authentication
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    private List<Store> storeList;
    private CustomAdapter customAdapter;

    /**
     * onCreate method for realtime activity handling for StoreList class
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        this.setTitle("Select Store");

        mAuth = FirebaseAuth.getInstance();// mAuth comment
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference("businessid");

        storeList = new ArrayList<>();
        customAdapter = new CustomAdapter(StoreList.this,storeList);

        storeListView = (ListView) findViewById(R.id.storeListView);

    }

    /**
     * This method is for starting and handling database activity
     * Gives error message if fails
     * Retrives data from database
     */
    @Override
    protected void onStart() {

        myRef.addValueEventListener(new ValueEventListener() {
            /**
             * Take a snapShot of a database
             * Search trhough the database for a result
             * @param dataSnapshot
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //storeLst.clear();

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Store store = ds.getValue(Store.class);
                    storeList.add(store);
                    Toast.makeText(getApplicationContext(),"Name: "+ds.getValue(Store.class).getNmae(),Toast.LENGTH_LONG).show();
                }

                storeListView.setAdapter(customAdapter);

            }

            /**
             * Called when canceling the database operation
             * @param databaseError
             */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
