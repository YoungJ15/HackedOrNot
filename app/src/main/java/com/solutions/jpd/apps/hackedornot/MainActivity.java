package com.solutions.jpd.apps.hackedornot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.solutions.jpd.apps.hackedornot.fragment.HackedFragment;
import com.solutions.jpd.apps.hackedornot.util.CheckNetwork;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(!CheckNetwork.isInternetAvailable(this)) {
            Toast.makeText(this, "Failed to load. Internet connection is required", Toast.LENGTH_SHORT).show();
        }
        else{
            getFragmentManager().beginTransaction().add(R.id.container, new HackedFragment()).commit();
        }
    }
}
