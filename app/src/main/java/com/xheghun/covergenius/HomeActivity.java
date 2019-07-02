package com.xheghun.covergenius;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xheghun.covergenius.fragment.HomePageFragment;
import com.xheghun.covergenius.fragment.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.main_bottom_nav)
    BottomNavigationView main_bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, new HomePageFragment())
                .commit();

        main_bottom_nav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container, new HomePageFragment())
                            .commit();
                    break;
                case R.id.notification:
                    break;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_container, new ProfileFragment())
                            .commit();
                    break;
            }
            return true;
        });
    }
}
