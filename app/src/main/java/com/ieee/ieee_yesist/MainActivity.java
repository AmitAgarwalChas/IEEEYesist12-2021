package com.ieee.ieee_yesist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ieee.ieee_yesist.databinding.ActivityMainBinding;
import com.ieee.ieee_yesist.view.AboutTeam.AboutTeamFragment;
import com.ieee.ieee_yesist.view.HomeFragment;
import com.ieee.ieee_yesist.view.Timeline.TimelineFragment;
import com.ieee.ieee_yesist.view.Tracks.TracksFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    BottomNavigationView bottomNavigationView;
    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.tracksFragment, R.id.aboutTeamFragment, R.id.trendingFragment,
                R.id.trackDetails, R.id.professionalInfoFragment, R.id.sterringCommitteeFragment, R.id.subCommitteeFragment)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.fragNavHost);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selFragment = null;
                switch (item.getItemId()){
                    case R.id.more_options:
                        drawer.openDrawer(GravityCompat.START);
                        return true;
                    case R.id.trendingFragment:
                        Toast.makeText(MainActivity.this,"Timeline start",Toast.LENGTH_SHORT).show();
                        selFragment= new TimelineFragment();
                        loadFragment(selFragment);
                        return true;
                    case R.id.homeFragment:
                        Toast.makeText(MainActivity.this,"Home start",Toast.LENGTH_SHORT).show();
                        selFragment= new HomeFragment();
                        loadFragment(selFragment);
                        return true;
                    case R.id.tracksFragment:
                        Toast.makeText(MainActivity.this,"Tracks start",Toast.LENGTH_SHORT).show();
                        selFragment= new TracksFragment();
                        loadFragment(selFragment);
                        return true;
                    case R.id.aboutTeamFragment:
                        Toast.makeText(MainActivity.this,"About team start",Toast.LENGTH_SHORT).show();
                        selFragment= new AboutTeamFragment();
                        loadFragment(selFragment);
                        return true;
                    default:
                        drawer.closeDrawer(GravityCompat.END);
                        return true;
                }
            }
        });

    }

    private void loadFragment(Fragment selFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragNavHost, selFragment,null);
        transaction.commit();
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragNavHost);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}