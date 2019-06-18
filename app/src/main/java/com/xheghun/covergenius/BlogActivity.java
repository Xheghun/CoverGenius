package com.xheghun.covergenius;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xheghun.covergenius._interface.NavigationHost;
import com.xheghun.covergenius.fragment.BlogPostContentFragment;
import com.xheghun.covergenius.fragment.MainBlogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogActivity extends AppCompatActivity implements NavigationHost {

    @BindView(R.id.blog_bottom_nav)
    BottomNavigationView bottom_nav;
    private int blog_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        ButterKnife.bind(this);

        blog_container = R.id.blog_container;
        if (savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(blog_container, new MainBlogFragment())
                    .commit();
        }

        bottom_nav.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.blog_nav_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(blog_container, new MainBlogFragment())
                            .commit();
                    break;
                case R.id.blog_nav_notification:
                    getSupportFragmentManager().beginTransaction()
                            .replace(blog_container, new BlogPostContentFragment())
                            .commit();
                    break;
                case R.id.blog_nav_profile:
                    break;
            }
            return true;
        });
    }


    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}