package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import com.jawnnypoo.physicslayout.PhysicsFrameLayout;


public class Fragmenttwo extends Fragment implements RotationGestureDetector.OnRotationGestureListener {

    private PhysicsFrameLayout physicsLayout;
    private final int layout = R.layout.fragment_two;
    private CardView cardView1;
    private CardView selectedForRotationCardView1;

    private  float oldEngle;
    private RotationGestureDetector rotationDetector;

    private FloatingActionButton floatingActionButton;


    public Fragmenttwo() {}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);

        physicsLayout = view.findViewById(R.id.physics_layout);
        cardView1 = view.findViewById(R.id.cv1);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) cardView1.getLayoutParams();
        params.setMarginStart(200);

        physicsLayout.getPhysics().enableFling();
       //physicsLayout.getPhysics().enablePhysics();
        rotationDetector = new RotationGestureDetector(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                physicsLayout.getPhysics().giveRandomImpulse();

                Drawable imageLockDrawable = floatingActionButton.getDrawable();
                ((Animatable) imageLockDrawable).start();
            }
        });
        return view;
    }

    public static Fragmenttwo newInstance() {
        return new Fragmenttwo();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void OnRotation(RotationGestureDetector rotationDetector) {
        float angle = rotationDetector.getAngle();
        selectedForRotationCardView1.setRotation(oldEngle - angle);
    }




}
