package com.gahlot.indeetv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gahlot.indeetv.fragments.ListFragment;

public class MainActivity extends AppCompatActivity {

    private ListFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new ListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, homeFragment).commit();
    }
}
