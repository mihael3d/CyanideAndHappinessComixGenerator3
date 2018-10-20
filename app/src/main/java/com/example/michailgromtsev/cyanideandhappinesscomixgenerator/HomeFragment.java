package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class HomeFragment extends Fragment {

    public HomeFragment () {}

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageDrawable(getDrawableFromAssets("aD.png"));


        imageView.setImageResource(R.drawable.a001_2);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Drawable getDrawableFromAssets(String path) {
        Drawable img = null;
        try {
            img = Drawable.createFromStream(getActivity().getAssets().open(path), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
