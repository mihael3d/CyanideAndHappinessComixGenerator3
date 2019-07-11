package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view.GravityLayoutFragment;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.InfinitiStoryFragment;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view.ComicGeneratorFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_ONE = "fragment_commix_generator";
    private static final String TAG_FRAGMENT_TWO = "fragment_gravity";
    private static final String TAG_FRAGMENT_THREE = "fragment_infiniti_story";

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private String currentFragmentTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView =  findViewById(R.id.navigation);
        frameLayout = findViewById(R.id.fl_content);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            addFragment(ComicGeneratorFragment.newInstance(),TAG_FRAGMENT_ONE);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (bottomNavigationView.getSelectedItemId() != item.getItemId()) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        ft.replace(R.id.fl_content,ComicGeneratorFragment.newInstance(),TAG_FRAGMENT_ONE);
                        ft.commit();
                        return true;
                    case R.id.navigation_dashboard:
                        ft.replace(R.id.fl_content,GravityLayoutFragment.newInstance(),TAG_FRAGMENT_TWO);
                        ft.commit();

                        return true;
                    case R.id.navigation_notifications:
                        ft.replace(R.id.fl_content,InfinitiStoryFragment.newInstance(),TAG_FRAGMENT_THREE);
                        ft.commit();
                        return true;
                }
            }
            return false;
        }
    };


    private void addFragment(@NonNull Fragment fragment, @NonNull String tag){
        if (currentFragmentTag!=tag){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fl_content, fragment, tag);
            ft.commit();
            currentFragmentTag = tag;
        }
    }



}
