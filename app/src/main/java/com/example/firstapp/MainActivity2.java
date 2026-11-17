package com.example.firstapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.firstapp.fragments.AddMealFragment;
import com.example.firstapp.fragments.HomeFragment;
import com.example.firstapp.fragments.ProfileFragment;
import com.example.firstapp.fragments.RecordsFragment;
import com.example.firstapp.fragments.StatisticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main2);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        if(savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int id = item.getItemId();

            if(id == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            }
            else if(id == R.id.nav_records) {
                selectedFragment = new RecordsFragment();
            }

            else if(id == R.id.nav_add) {
                selectedFragment = new AddMealFragment();
            } else if (id == R.id.nav_statics) {
                selectedFragment = new StatisticsFragment();

            } else if (id == R.id.nav_profile) {

                selectedFragment = new ProfileFragment();
            }

            if(selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }

            return false;
        });




    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}