package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view.ComicGeneratorFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG_FRAGMENT_ONE = "fragment_one";
    private static final String TAG_FRAGMENT_TWO = "fragment_two";
    private static final String TAG_FRAGMENT_THREE = "fragment_three";
    BottomNavigationView bottomNavigationView;

    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private Fragment ferstFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView =  findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_content, ComicGeneratorFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            if (bottomNavigationView.getSelectedItemId() != item.getItemId()) {

                switch (item.getItemId()) {

                    case R.id.navigation_home:
                            replaceFragment(ComicGeneratorFragment.newInstance(), TAG_FRAGMENT_ONE);
                        return true;
                    case R.id.navigation_dashboard:
                            replaceFragment(Fragmenttwo.newInstance(), TAG_FRAGMENT_TWO);
                        return true;
                    case R.id.navigation_notifications:

                        return true;
                }
            }

            return false;
        }
    };

    private void replaceFragment(@NonNull Fragment fragment, @NonNull String tag){
        if (!fragment.equals(currentFragment)){
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fl_content, fragment, tag);
                ft.commit();
                currentFragment = fragment;
        }
    }



}
