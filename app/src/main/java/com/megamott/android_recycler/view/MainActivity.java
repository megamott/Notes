package com.megamott.android_recycler.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.megamott.android_recycler.R;
import com.megamott.android_recycler.view.fragments.NumbersListFragment;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentById(R.id.main_layout) == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_layout, new NumbersListFragment())
                    .commit();
        }
    }
}