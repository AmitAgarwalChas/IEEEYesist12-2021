package com.ieee.ieee_yesist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.ieee.ieee_yesist.databinding.ActivityMainBinding;
import com.ieee.ieee_yesist.util.ConnectionUtil;
import com.ieee.ieee_yesist.view.AboutUsFragment;
import com.ieee.ieee_yesist.view.SponsorsFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavHostFragment navHostFragment;
    private NavController navController;
    BottomNavigationView bottomNavigationView;
    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    private boolean firstTimeOpen;

    @Override
    protected void onResume() {
        super.onResume();
        firstTimeOpen = true;
    }

    private void checkConnection(Context context) {
        ConnectionUtil connectionUtil = new ConnectionUtil(context);
        connectionUtil.observe(this, isNetworkAvailable -> {
            if (isNetworkAvailable) {
                if(!firstTimeOpen) {
                    Snackbar snackbar = Snackbar.make(binding.snackContainer.parentLayout, "You are ONLINE",
                            Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(getResources().getColor(R.color.green_version));
                    snackbar.setAnchorView(binding.snackContainer.bottomNavigationView);
                    snackbar.show();
                }
                firstTimeOpen = false;
            }else {
                Snackbar snackbar = Snackbar.make(binding.snackContainer.parentLayout, "Please connect to the Internet!",
                        Snackbar.LENGTH_INDEFINITE);
                snackbar.setBackgroundTint(getResources().getColor(R.color.red));
                snackbar.setAnchorView(binding.snackContainer.bottomNavigationView);
                snackbar.show();
                firstTimeOpen = false;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Checking Network Connectivity during Runtime
        checkConnection(this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        ImageButton closeNav = (ImageButton) headerView.findViewById(R.id.nav_closeBtn);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.tracksFragment, R.id.aboutTeamFragment, R.id.trendingFragment,
                R.id.trackDetailsFragment, R.id.professionalInfoFragment, R.id.sterringCommitteeFragment, R.id.subCommitteeFragment,
                R.id.sponsorsFragment, R.id.faqFragment, R.id.faqDetailFragment, R.id.aboutUsFragment)
                .setDrawerLayout(drawer)
                .build();

        navController = Navigation.findNavController(this, R.id.fragNavHost);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.sponsorsFragment) {
                bottomNavigationView.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragNavHost, new SponsorsFragment()).commit();
            }
            if(item.getItemId() == R.id.aboutUsFragment) {
                bottomNavigationView.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragNavHost, new AboutUsFragment()).commit();
            }
            if(item.getItemId() == R.id.shareApp) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "IEEE Yesist12");
                String shareMessage= "Checkout IEEE YESIST12 2021 app over here: https://play.google.com/store/apps/details?id=com.ieee.ieee_yesist&hl=en";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Share Via"));
            }
            if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            return NavigationUI.onNavDestinationSelected(item, navController);
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId() == R.id.more_options) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
            if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
            return NavigationUI.onNavDestinationSelected(item, navController);
        });

        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        closeNav.setOnClickListener(v -> binding.drawerLayout.closeDrawer(GravityCompat.START));

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, mAppBarConfiguration);
    }

    @Override
    public void onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            if(bottomNavigationView.getVisibility() == View.GONE)
                bottomNavigationView.setVisibility(View.VISIBLE);
            super.onBackPressed();
        }
    }
}