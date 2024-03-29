package com.example.vadik.news.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.vadik.news.R;
import com.example.vadik.news.view.fragment.SourcesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments_container, SourcesFragment.newInstance())
                .commitAllowingStateLoss();
    }
}
