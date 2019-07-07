package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view;

import android.graphics.Point;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.presenter.GravityLayoutPresenter;
import com.jawnnypoo.physicslayout.Physics;
import com.jawnnypoo.physicslayout.PhysicsFrameLayout;

import java.util.ArrayList;
import java.util.Arrays;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;


public class GravityLayoutFragment extends MvpAppCompatFragment implements GravityLayoutView {

    private final int layout = R.layout.fragment_gravity;

    private PhysicsFrameLayout physicsLayout;

    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private CardView cardView5;
    private ArrayList<CardView> cardsList;

    private ImageView card1ImageView;
    private ImageView card2ImageView;
    private ImageView card3ImageView;
    private ImageView card4ImageView;
    private ImageView card5ImageView;

    private RelativeLayout card1BorderLayout;
    private RelativeLayout card2BorderLayout;
    private RelativeLayout card3BorderLayout;
    private RelativeLayout card4BorderLayout;
    private RelativeLayout card5BorderLayout;

    private View cardLine;

    private FloatingActionButton floatingActionButton;

    private FrameLayout.LayoutParams paramsCard1;


    private float card1X;
    private float card1Y;
    private float card2X;
    private float card2Y;
    private float card3X;
    private float card3Y;
    private float card4X;
    private float card4Y;
    private float card5X;
    private float card5Y;

    private float cardLineY;

    private  boolean [] cardsNeedToJumpOnRefresh;

    private int screenWidth;
    private int screenHeight;
    private  int orientation;

    @InjectPresenter(tag="gravityLayoutPresentr" )
    GravityLayoutPresenter gravityLayoutPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        initUi(view);
        orientation = getResources().getConfiguration().orientation;
        gravityLayoutPresenter.onCreateView(orientation);
        saveDefoultCardsParams();
        physicsLayout.getPhysics().enableFling();
        iniUX ();
        return view;
    }

    public void onPause() {
        super.onPause();
        saveCardsPositions();
        gravityLayoutPresenter.onPoused(card1X,card1Y,
                card2X,card2Y,card3X,card3Y,card4X,card4Y,card5X,card5Y);
    }

    public static GravityLayoutFragment newInstance() {
        return new GravityLayoutFragment();
    }

    private void initUi(View view) {
        physicsLayout = view.findViewById(R.id.physics_layout);
        cardView1 = view.findViewById(R.id.gravity_layout_cv1);
        cardView2 = view.findViewById(R.id.gravity_layout_cv2);
        cardView3 = view.findViewById(R.id.gravity_layout_cv3);
        cardView4 = view.findViewById(R.id.gravity_layout_cv4);
        cardView5 = view.findViewById(R.id.gravity_layout_cv5);
        card1BorderLayout = view.findViewById(R.id.card_1_border_layout);
        card2BorderLayout = view.findViewById(R.id.card_2_border_layout);
        card3BorderLayout = view.findViewById(R.id.card_3_border_layout);
        card4BorderLayout = view.findViewById(R.id.card_4_border_layout);
        card5BorderLayout = view.findViewById(R.id.card_5_border_layout);

        card1ImageView = view.findViewById(R.id.card1_image_view);
        card2ImageView = view.findViewById(R.id.card2_image_view);
        card3ImageView = view.findViewById(R.id.card3_image_view);
        card4ImageView = view.findViewById(R.id.card4_image_view);
        card5ImageView = view.findViewById(R.id.card5_image_view);
        cardLine = view.findViewById(R.id.card_line);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
        cardsList = new ArrayList<CardView>(Arrays.asList(cardView1,cardView2,cardView3,cardView4,cardView5));
    }

    private void iniUX () {
        cardsNeedToJumpOnRefresh = new boolean[5];
        //{true, true, true, true, true};

        floatingActionButton.setOnClickListener(v -> {
            cardLineY = cardLine.getY();
            int cardHeight = cardView1.getHeight();

            Drawable imageLockDrawable = floatingActionButton.getDrawable();
            ((Animatable) imageLockDrawable).stop();
            ((Animatable) imageLockDrawable).start();

            saveCardsPositions();
            fixingCardCoordinationsIfTheyAreOutOfScreen();

            gravityLayoutPresenter.onRefreshFloatingButtonPressed(card1Y,card2Y,card3Y,card4Y,card5Y,cardLineY,cardHeight );

            putCarsOnTheirPositions(cardsNeedToJumpOnRefresh[0],cardsNeedToJumpOnRefresh[1],
                    cardsNeedToJumpOnRefresh[2],cardsNeedToJumpOnRefresh[3],
                    cardsNeedToJumpOnRefresh[4]);
//            physicsLayout.getPhysics().giveRandomImpulse();
        });


        physicsLayout.getPhysics().setOnFlingListener(new Physics.OnFlingListener() {
            @Override
            public void onGrabbed(View grabbedView) {
                long millis = System.currentTimeMillis();
                long seconds = millis / 1000;

                try {
                    CardView cardView =(CardView)grabbedView;

                    switch (cardView.getId()) {
                        case  R.id.gravity_layout_cv1:
                            gravityLayoutPresenter.onCardPres(1,seconds);
                            break;
                        case  R.id.gravity_layout_cv2:
                            gravityLayoutPresenter.onCardPres(2,seconds);
                            break;
                        case  R.id.gravity_layout_cv3:
                            gravityLayoutPresenter.onCardPres(3,seconds);
                            break;
                        case  R.id.gravity_layout_cv4:
                            gravityLayoutPresenter.onCardPres(4,seconds);
                            break;
                        case  R.id.gravity_layout_cv5:
                            gravityLayoutPresenter.onCardPres(5,seconds);
                            break;
                        default:
                            break;
                    }
                } catch (ClassCastException e){
            // Nothing need to do.  We have to watch out for grabbering only CardsVew on this PhysicsFrameLayout.
                }
            }

            @Override
            public void onReleased(View releasedView) {
            }
        });
    }

    private void saveDefoultCardsParams(){
        paramsCard1 =  (FrameLayout.LayoutParams)cardView1.getLayoutParams();
    }


    private void saveCardsPositions(){
        card1X = cardView1.getX();
        card2X = cardView2.getX();
        card3X = cardView3.getX();
        card4X = cardView4.getX();
        card5X = cardView5.getX();

        card1Y = cardView1.getY();
        card2Y = cardView2.getY();
        card3Y = cardView3.getY();
        card4Y = cardView4.getY();
        card5Y = cardView5.getY();
        card5Y = cardView5.getY();
    }



    private void putCarsOnTheirPositions(boolean card1RefreshJumpY,
                                         boolean card2RefreshJumpY,
                                         boolean card3RefreshJumpY,
                                         boolean card4RefreshJumpY,
                                         boolean card5RefreshJumpY){
        paramsCard1.leftMargin=0;
        paramsCard1.topMargin=0;

        cardView1.setLayoutParams(paramsCard1);
        cardView2.setLayoutParams(paramsCard1);
        cardView3.setLayoutParams(paramsCard1);
        cardView4.setLayoutParams(paramsCard1);
        cardView5.setLayoutParams(paramsCard1);

        cardView1.setTranslationX(card1X);
        cardView2.setTranslationX(card2X);
        cardView3.setTranslationX(card3X);
        cardView4.setTranslationX(card4X);
        cardView5.setTranslationX(card5X);

        cardView1.setTranslationY(card1Y - (card1RefreshJumpY ? 30 : 0));
        cardView2.setTranslationY(card2Y - (card2RefreshJumpY ? 40 : 0));
        cardView3.setTranslationY(card3Y - (card3RefreshJumpY ? 50 : 0));
        cardView4.setTranslationY(card4Y - (card4RefreshJumpY ? 60 : 0));
        cardView5.setTranslationY(card5Y - (card5RefreshJumpY ? 70 : 0));
    }

    private void fixingCardCoordinationsIfTheyAreOutOfScreen(){
        int cardWhith = cardView1.getWidth();
        int cardHeight = cardView1.getHeight();

        float fixedCardY;
        if (orientation == ORIENTATION_PORTRAIT) { fixedCardY = screenHeight - cardHeight - 10; }
        else {
            fixedCardY = cardLine.getY() + 10  ;
        }

       if ( (card1X < - cardWhith)||(card1X > screenWidth)||(card1Y < - cardHeight)| (card1Y > screenHeight)){
           card1X = 10;
           card1Y = fixedCardY;
       }

       if ( (card2X < - cardWhith)||(card2X > screenWidth)||(card2Y < - cardHeight)| (card2Y > screenHeight)){
           card2X = 10;
           card2Y =fixedCardY;
       }

       if ( (card3X < - cardWhith)||(card3X > screenWidth)||(card3Y < - cardHeight)| (card3Y > screenHeight)){
           card3X = 10;
           card3Y = fixedCardY;
       }

       if ( (card4X < - cardWhith)||(card4X > screenWidth)||(card4Y < - cardHeight)| (card4Y > screenHeight)){
           card4X = 10;
           card4Y = fixedCardY;
       }

       if ( (card5X < - cardWhith)||(card5X > screenWidth)||(card5Y < - cardHeight)| (card5Y > screenHeight)){
           card5X = 10;
           card5Y = fixedCardY;
       }
    }

    @Override
    public void setCard1Image(int image) {
        card1ImageView.setImageResource(image);
    }

    @Override
    public void setCard2Image(int image) {
        card2ImageView.setImageResource(image);
    }

    @Override
    public void setCard3Image(int image) {
        card3ImageView.setImageResource(image);
    }

    @Override
    public void setCard4Image(int image) {
        card4ImageView.setImageResource(image);
    }

    @Override
    public void setCard5Image(int image) {
        card5ImageView.setImageResource(image);
    }

    @Override
    public void setCardsToPositions(float[] cardsCoordinats) {
        card1X = cardsCoordinats[0];
        card1Y = cardsCoordinats[1];
        card2X = cardsCoordinats[2];
        card2Y = cardsCoordinats[3];
        card3X = cardsCoordinats[4];
        card3Y = cardsCoordinats[5];
        card4X = cardsCoordinats[6];
        card4Y = cardsCoordinats[7];
        card5X = cardsCoordinats[8];
        card5Y = cardsCoordinats[9];
        putCarsOnTheirPositions(false,false,false,false,false);
    }

    @Override
    public void showCard1BorderLocked(boolean locked) {
        saveCardsPositions();
        cardBorderLock(card1BorderLayout, locked);
        putCarsOnTheirPositions(false,false,false, false,false);
    }

    @Override
    public void showCard2BorderLocked(boolean locked) {
        saveCardsPositions();
        cardBorderLock(card2BorderLayout, locked);
        putCarsOnTheirPositions(false,false,false, false,false);
    }

    @Override
    public void showCard3BorderLocked(boolean locked) {
        saveCardsPositions();
        cardBorderLock(card3BorderLayout, locked);
        putCarsOnTheirPositions(false,false,false, false,false);
        cardsNeedToJumpOnRefresh[2] = locked;
    }

    @Override
    public void showCard4BorderLocked(boolean locked) {
        saveCardsPositions();
        cardBorderLock(card4BorderLayout, locked);
        putCarsOnTheirPositions(false,false,false,false,false);
    }

    @Override
    public void showCard5BorderLocked(boolean locked) {
        saveCardsPositions();
        cardBorderLock(card5BorderLayout, locked);
        putCarsOnTheirPositions(false,false,false, false,false);
    }


    @Override
    public void setCard1Jump(boolean needJump) {
        cardsNeedToJumpOnRefresh[0] = needJump;
    }

    @Override
    public void setCard2Jump(boolean needJump) {
        cardsNeedToJumpOnRefresh[1] = needJump;
    }

    @Override
    public void setCard3Jump(boolean needJump) {
        cardsNeedToJumpOnRefresh[2] = needJump;
    }

    @Override
    public void setCard4Jump(boolean needJump) {
        cardsNeedToJumpOnRefresh[3] = needJump;
    }

    @Override
    public void setCard5Jump(boolean needJump) {
        cardsNeedToJumpOnRefresh[4] = needJump;
    }


    private void cardBorderLock(@NonNull RelativeLayout relativeLayout, @NonNull boolean locked){
        int cardBorder;
        if (locked) {
            cardBorder = R.drawable.cardborderlock;
        } else {
            cardBorder = 0;
        }
        relativeLayout.setBackgroundResource(cardBorder);
    }
}
