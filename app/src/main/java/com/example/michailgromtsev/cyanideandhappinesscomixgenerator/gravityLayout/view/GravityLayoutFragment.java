package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.presenter.GravityLayoutPresenter;
import com.jawnnypoo.physicslayout.PhysicsFrameLayout;


public class GravityLayoutFragment extends MvpAppCompatFragment implements GravityLayoutView {

    private final int layout = R.layout.fragment_gravity;

    private PhysicsFrameLayout physicsLayout;

    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private CardView cardView5;
    private CardView cardView6;
    private CardView cardView7;

    private ImageView card1ImageView;
    private ImageView card2ImageView;
    private ImageView card3ImageView;
    private ImageView card4ImageView;
    private ImageView card5ImageView;
    private ImageView card6ImageView;
    private ImageView card7ImageView;


    private FloatingActionButton floatingActionButton;

    FrameLayout.LayoutParams paramsCard1;
    FrameLayout.LayoutParams paramsCard2;
    FrameLayout.LayoutParams paramsCard3;
    FrameLayout.LayoutParams paramsCard4;
    FrameLayout.LayoutParams paramsCard5;
    FrameLayout.LayoutParams paramsCard6;
    FrameLayout.LayoutParams paramsCard7;

    float card1X;
    float card1Y;
    float card2X;
    float card2Y;
    float card3X;
    float card3Y;
    float card4X;
    float card4Y;
    float card5X;
    float card5Y;
    float card6X;
    float card6Y;
    float card7X;
    float card7Y;
    float card1TransitionX;
    float card2TransitionX;
    float card3TransitionX;
    float card4TransitionX;
    float card5TransitionX;
    float card6TransitionX;
    float card7TransitionX;

    float card1TransitionY;
    float card2TransitionY;
    float card3TransitionY;
    float card4TransitionY;
    float card5TransitionY;
    float card6TransitionY;
    float card7TransitionY;

    @InjectPresenter(tag="gravityLayoutPresentr" )
    GravityLayoutPresenter gravityLayoutPresenter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        initUi(view);
        saveCardsposition();

        physicsLayout.getPhysics().enableFling();

        floatingActionButton.setOnClickListener(v -> {
            physicsLayout.getPhysics().giveRandomImpulse();
            putCarsOnDefoultPositions();

            gravityLayoutPresenter.onRefreshFloatingButtonPressed();

            Drawable imageLockDrawable = floatingActionButton.getDrawable();
            ((Animatable) imageLockDrawable).stop();
            ((Animatable) imageLockDrawable).start();
        });

        return view;
    }

    public static GravityLayoutFragment newInstance() {
        return new GravityLayoutFragment();
    }

    private void initUi(View view) {
    physicsLayout = view.findViewById(R.id.physics_layout);
    cardView1 = view.findViewById(R.id.cv1);
    cardView2 = view.findViewById(R.id.cv2);
    cardView3 = view.findViewById(R.id.cv3);
    cardView4 = view.findViewById(R.id.cv4);
    cardView5 = view.findViewById(R.id.cv5);
    cardView6 = view.findViewById(R.id.cv6);
    cardView7 = view.findViewById(R.id.cv7);

    card1ImageView = view.findViewById(R.id.card1_image_view);
    card2ImageView = view.findViewById(R.id.card2_image_view);
    card3ImageView = view.findViewById(R.id.card3_image_view);
    card4ImageView = view.findViewById(R.id.card4_image_view);
    card5ImageView = view.findViewById(R.id.card5_image_view);
    card6ImageView = view.findViewById(R.id.card6_image_view);
    card7ImageView = view.findViewById(R.id.card7_image_view);

    floatingActionButton = view.findViewById(R.id.floatingActionButton);
}

    private void saveCardsposition(){

        paramsCard1 =  (FrameLayout.LayoutParams)cardView1.getLayoutParams();
        paramsCard2 =  (FrameLayout.LayoutParams)cardView2.getLayoutParams();
        paramsCard3 = (FrameLayout.LayoutParams) cardView3.getLayoutParams();
        paramsCard4 = (FrameLayout.LayoutParams) cardView4.getLayoutParams();
        paramsCard5 = (FrameLayout.LayoutParams) cardView5.getLayoutParams();
        paramsCard6 = (FrameLayout.LayoutParams) cardView6.getLayoutParams();
        paramsCard7 = (FrameLayout.LayoutParams) cardView7.getLayoutParams();

        card1X = cardView1.getX();
        card1Y = cardView1.getY();
        card2X = cardView2.getX();
        card3Y = cardView2.getY();
        card3X = cardView3.getX();
        card3Y = cardView3.getY();
        card4X = cardView4.getX();
        card4Y = cardView4.getY();
        card5X = cardView5.getX();
        card5Y = cardView5.getY();
        card6X = cardView6.getX();
        card6Y = cardView6.getY();
        card7X = cardView7.getX();
        card7Y = cardView7.getY();

        card1TransitionX = cardView1.getTranslationX();
        card2TransitionX = cardView2.getTranslationX();
        card3TransitionX = cardView3.getTranslationX();
        card4TransitionX = cardView4.getTranslationX();
        card5TransitionX = cardView5.getTranslationX();
        card6TransitionX = cardView6.getTranslationX();
        card7TransitionX = cardView7.getTranslationX();

        card1TransitionY = cardView1.getTranslationY();
        card2TransitionY = cardView2.getTranslationY();
        card3TransitionY = cardView3.getTranslationY();
        card4TransitionY = cardView4.getTranslationY();
        card5TransitionY = cardView5.getTranslationY();
        card6TransitionY = cardView6.getTranslationY();
        card7TransitionY = cardView7.getTranslationY();
    }

    private void putCarsOnDefoultPositions(){

        cardView1.setLayoutParams(paramsCard1);
        cardView2.setLayoutParams(paramsCard2);
        cardView3.setLayoutParams(paramsCard3);
        cardView4.setLayoutParams(paramsCard4);
        cardView5.setLayoutParams(paramsCard5);
        cardView6.setLayoutParams(paramsCard6);
        cardView7.setLayoutParams(paramsCard7);

        cardView1.setX(card1X);
        cardView1.setY(card1Y);
        cardView2.setX(card2X);
        cardView2.setY(card2Y);
        cardView3.setX(card3X);
        cardView3.setY(card3Y);
        cardView4.setX(card4X);
        cardView4.setY(card4Y);
        cardView5.setX(card5X);
        cardView5.setY(card5Y);
        cardView6.setX(card6X);
        cardView6.setY(card6Y);
        cardView7.setX(card7X);
        cardView7.setY(card7Y);

        cardView1.setTranslationX(card1TransitionX);
        cardView2.setTranslationX(card2TransitionX);
        cardView3.setTranslationX(card3TransitionX);
        cardView4.setTranslationX(card4TransitionX);
        cardView5.setTranslationX(card5TransitionX);
        cardView6.setTranslationX(card6TransitionX);
        cardView7.setTranslationX(card7TransitionX);

        cardView1.setTranslationY(card1TransitionY);
        cardView2.setTranslationY(card2TransitionY);
        cardView3.setTranslationY(card3TransitionY);
        cardView4.setTranslationY(card4TransitionY);
        cardView5.setTranslationY(card5TransitionY);
        cardView6.setTranslationY(card6TransitionY);
        cardView7.setTranslationY(card7TransitionY);
    }


    @Override
    public void setCard1Image(int imaje) {
        card1ImageView.setImageResource(imaje);
    }

    @Override
    public void setCard2Image(int imaje) {
        card2ImageView.setImageResource(imaje);
    }

    @Override
    public void setCard3Image(int imaje) {
        card3ImageView.setImageResource(imaje);
    }

    @Override
    public void setCard4Image(int imaje) {
        card4ImageView.setImageResource(imaje);
    }

    @Override
    public void setCard5Image(int imaje) {
        card5ImageView.setImageResource(imaje);
    }

    @Override
    public void setCard6Image(int imaje) {
        card6ImageView.setImageResource(imaje);
    }

    @Override
    public void setCard7Image(int imaje) {
        card7ImageView.setImageResource(imaje);
    }
}
