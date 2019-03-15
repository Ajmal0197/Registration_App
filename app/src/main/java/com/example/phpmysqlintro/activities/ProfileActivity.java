package com.example.phpmysqlintro.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.phpmysqlintro.R;
import com.example.phpmysqlintro.fragments.HomeFragment;
import com.example.phpmysqlintro.fragments.SettingsFragment;
import com.example.phpmysqlintro.fragments.UsersFragment;
import com.example.phpmysqlintro.model.User;
import com.example.phpmysqlintro.storage.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new HomeFragment());    //displaying home fragment at startup
    }

    //displaying the first fragment

    private void displayFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(!SharedPrefManager.getInstance(this).isLoggedIn())
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){
           case R.id.menu_home:
               fragment = new HomeFragment();
               break;
           case R.id.menu_users:
               fragment = new UsersFragment();
               break;
           case R.id.menu_settings:
               fragment = new SettingsFragment();
               break;
       }
       if(fragment!=null){
           displayFragment(fragment);
       }
        return false;
    }
}
