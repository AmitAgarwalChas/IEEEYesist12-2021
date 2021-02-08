package com.ieeeyesist12_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.ui.NavigationUI;
import com.ieeeyesist12_2021.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        navHostFragment = (NavHostFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragNavHost);
        NavigationUI.setupWithNavController(binding.bottomNavigationView,
                navHostFragment.getNavController());

    }
}