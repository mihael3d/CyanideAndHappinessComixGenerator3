package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.FragmentThree;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view.ComicGeneratorFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_ONE = "fragment_one";
    private static final String TAG_FRAGMENT_TWO = "fragment_two";
    private static final String TAG_FRAGMENT_THREE = "fragment_three";

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
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                            hideFragment(TAG_FRAGMENT_TWO);
                            hideFragment(TAG_FRAGMENT_THREE);
                        if(getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_ONE)==null){
                            addFragment(ComicGeneratorFragment.newInstance(),TAG_FRAGMENT_ONE);
                        }
                        showFragment(TAG_FRAGMENT_ONE);
                                return true;
                    case R.id.navigation_dashboard:
                            hideFragment(TAG_FRAGMENT_ONE);
                            hideFragment(TAG_FRAGMENT_THREE);
                        if(getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_TWO)==null){
                            addFragment(Fragmenttwo.newInstance(),TAG_FRAGMENT_TWO);
                        }
                        showFragment(TAG_FRAGMENT_TWO);
                        return true;
                    case R.id.navigation_notifications:
                            hideFragment(TAG_FRAGMENT_ONE);
                            hideFragment(TAG_FRAGMENT_TWO);
                        if(getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_THREE)==null){
                            addFragment(FragmentThree.newInstance(),TAG_FRAGMENT_THREE);
                        }
                        showFragment(TAG_FRAGMENT_THREE);
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


    private void hideFragment(@NonNull String tag){
        if (getSupportFragmentManager().findFragmentByTag(tag)!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.hide(getSupportFragmentManager().findFragmentByTag(tag));
            ft.commit();
        }
    }

    private void showFragment(@NonNull String tag){
        if (getSupportFragmentManager().findFragmentByTag(tag)!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.show(getSupportFragmentManager().findFragmentByTag(tag));
            ft.commit();
        }
    }


}
