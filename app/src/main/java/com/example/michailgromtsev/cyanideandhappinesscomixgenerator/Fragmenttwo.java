package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jawnnypoo.physicslayout.PhysicsFrameLayout;


public class Fragmenttwo extends Fragment implements RotationGestureDetector.OnRotationGestureListener {

    private PhysicsFrameLayout physicsLayout;
    private final int layout = R.layout.fragment_two;
    private CardView cardView1;
    private CardView selectedForRotationCardView1;

    private  float oldEngle;
    private RotationGestureDetector rotationDetector;


    public Fragmenttwo() {}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);

        physicsLayout = view.findViewById(R.id.physics_layout);
        cardView1 = view.findViewById(R.id.cv1);

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) cardView1.getLayoutParams();
        params.setMarginStart(200);
       // cardView1.setLayoutParams(params);

        physicsLayout.getPhysics().enableFling();
       physicsLayout.getPhysics().enablePhysics();
        //physicsLayout.getPhysics().disablePhysics();

     //  physicsLayout.getPhysics().disableFling();

        rotationDetector = new RotationGestureDetector(this);
//        cardView1.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//               int i = 10;
//                return true;
//            }
//        });
//        cardView1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent motionEvent) {
//                selectedForRotationCardView1 = cardView1;
//                oldEngle = selectedForRotationCardView1.getRotation();
//                rotationDetector.onTouchEvent(motionEvent);
//                return false;
//            }
//
////            view.set
//        });

//        PhysicsConfig config = PhysicsConfig.create();
//        config.shapeType = PhysicsConfig.SHAPE_TYPE_CIRCLE;
//        config.radius = dpToPx(30);
//        config.fixtureDef = fixtureDef;
//        config.bodyDef = bodyDef;
//        Physics.setPhysicsConfig(circleView, config);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                return true;
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
