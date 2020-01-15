package edu.tomerbu.lec7viewmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.tomerbu.lec7viewmodels.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //only if it's the first time the activity is created:
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
