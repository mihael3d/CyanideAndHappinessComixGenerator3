package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.presenter.ComicsGeneratorPresenter;

public class ComicGeneratorFragment extends MvpAppCompatFragment implements ComicGeneratorView {

    private final int layout = R.layout.fragment_comix_genertor; // fragment_home   exemple_layout  fragment_comix_genertor
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private ImageView imageViewCard1;
    private ImageView imageViewCard2;
    private ImageView imageViewCard3;
    private Button buttonGenerateComix;

    private RelativeLayout card1BorderLayout;
    private RelativeLayout card2BorderLayout;
    private RelativeLayout card3BorderLayout;

    private  ImageView imageLock1;
    private  ImageView imageLock2;
    private  ImageView imageLock3;

    private  Handler handler;

    //public ComicGeneratorFragment() {}

    @InjectPresenter(tag="comicsGenerator")
    ComicsGeneratorPresenter comicsGeneratorPresenter;

    public static ComicGeneratorFragment newInstance() {
        return new ComicGeneratorFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        setupUi(view);
        setupUx();
        return view;
    }

private void setupUi (View view){
    imageViewCard1 = view.findViewById(R.id.image_view_card_1);
    imageViewCard2 = view.findViewById(R.id.image_view_card_2);
    imageViewCard3 = view.findViewById(R.id.image_view_card_3);
    buttonGenerateComix = view.findViewById(R.id.button_generate_comix);

    cardView1 = view.findViewById(R.id.cv1 );
    cardView2 = view.findViewById(R.id.cv2 );
    cardView3 = view.findViewById(R.id.cv3 );
    imageViewCard1.setImageResource(R.drawable.a001_2);
    card1BorderLayout = view.findViewById(R.id.card_1_border_layout);
    card2BorderLayout = view.findViewById(R.id.card_2_border_layout);
    card3BorderLayout = view.findViewById(R.id.card_3_border_layout);
    imageLock1 = view.findViewById(R.id.image_lock);
    imageLock2 = view.findViewById(R.id.image_lock_2);
    imageLock3 = view.findViewById(R.id.image_lock_3);



}

private void setupUx(){
     handler = new Handler();
    // Change lock images on click
    imageLock1.setOnClickListener(v -> comicsGeneratorPresenter.onLock1Press());
    imageLock2.setOnClickListener(v -> comicsGeneratorPresenter.onLock2Press());
    imageLock3.setOnClickListener(v -> comicsGeneratorPresenter.onLock3Press());

    // Change card's border color on click
    cardView1.setOnClickListener(v -> comicsGeneratorPresenter.onCard1pres());
    cardView2.setOnClickListener(v -> comicsGeneratorPresenter.onCard2pres());
    cardView3.setOnClickListener(v -> comicsGeneratorPresenter.onCard3pres());

    // Generate button
    buttonGenerateComix.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            comicsGeneratorPresenter.onButtonGeneratePressed();
        }
    });
}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    // UI Lock
    @Override
    public void setLoc1LockedByAnimation(boolean locked) {
        if (!comicsGeneratorPresenter.isInRestoreState(this)){
            setStateForImageOfLockWhitAnimation(imageLock1,locked);
        }
    }

    @Override
    public void setLock2LockedByAnimation(boolean locked) {
        if (!comicsGeneratorPresenter.isInRestoreState(this)) {
            setStateForImageOfLockWhitAnimation(imageLock2, locked);
        }
    }

    @Override
    public void setLock3LockedByAnimation(boolean locked) {
        if (!comicsGeneratorPresenter.isInRestoreState(this)) {
            setStateForImageOfLockWhitAnimation(imageLock3, locked);
        }
    }

    @Override
    public void setLock1LockedWithNoAnimation(boolean locked) {
        setStateForImageOfLockByStatickImage(imageLock1 , locked);
        if (!comicsGeneratorPresenter.isInRestoreState(this)){

        }
    }

    @Override
    public void setLock2LockedWithNoAnimation(boolean locked) {
        setStateForImageOfLockByStatickImage(imageLock2 , locked);
        if (!comicsGeneratorPresenter.isInRestoreState(this)){

        }
    }

    @Override
    public void setLock3LockedWithNoAnimation(boolean locked) {
        setStateForImageOfLockByStatickImage(imageLock3 , locked);
        if (!comicsGeneratorPresenter.isInRestoreState(this)){

        }
    }

    // UI CardBorder
    @Override
    public void showCard1BorderLocked(boolean locked) {
        cardBorderLock(card1BorderLayout, locked);
    }

    @Override
    public void showCard2BorderLocked(boolean locked) {
        cardBorderLock(card2BorderLayout, locked);
    }

    @Override
    public void showCard3BorderLocked(boolean locked) {
        cardBorderLock(card3BorderLayout, locked);
    }
    @Override

    //Ui image
    public void setCard1Image(int imaje) {
        imageViewCard1.setImageResource(imaje);
    }

    @Override
    public void setCard2Image(int imaje) {
        imageViewCard2.setImageResource(imaje);
    }

    @Override
    public void setCard3Image(int imaje) {
        imageViewCard3.setImageResource(imaje);
    }

    @Override
    public void setCard1Appearance(Techniques techniquesEffect, long delayMillis) {
        if (!comicsGeneratorPresenter.isInRestoreState(this)) {
            cardView1.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    YoYo.with(techniquesEffect)
                            .duration(700)
                            .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)

                            .playOn(cardView1);
                    cardView1.setVisibility(View.VISIBLE);
                }
            }, delayMillis);
        }
    }

    @Override
    public void setCard2Appearance(Techniques techniquesEffect, long delayMillis) {
        if (!comicsGeneratorPresenter.isInRestoreState(this)) {
            cardView2.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    YoYo.with(techniquesEffect)
                            .duration(700)
                            .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                            .playOn(cardView2);
                    cardView2.setVisibility(View.VISIBLE);
                }
            }, delayMillis);
        }
    }

    @Override
    public void setCard3Appearance(Techniques techniquesEffect, long delayMillis) {
        if (!comicsGeneratorPresenter.isInRestoreState(this)) {
            cardView3.setVisibility(View.INVISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    YoYo.with(techniquesEffect)
                            .duration(700)
                            .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                            .playOn(cardView3);
                    cardView3.setVisibility(View.VISIBLE);
                }
            }, delayMillis);
        }
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

    private void setStateForImageOfLockWhitAnimation(@NonNull ImageView lockImajeView, @NonNull boolean locked){
        int lockAnimDrawable;
        if (locked) {
            lockAnimDrawable = R.drawable.lock_whith_angle_lock_300;
        } else {
            lockAnimDrawable = R.drawable.lock_whith_angle_un_lock_300;
        }
        lockImajeView.setImageResource(lockAnimDrawable);
        Drawable imageLockDrawable = lockImajeView.getDrawable();
        ((Animatable) imageLockDrawable).start();
    }

    private void setStateForImageOfLockByStatickImage(@NonNull ImageView lockImajeView, @NonNull boolean locked){
        int lockAnimDrawable;
        if (locked) {
            lockAnimDrawable = R.drawable.lock_whith_angle_un_lock_300;
        } else {
            lockAnimDrawable = R.drawable.lock_whith_angle_lock_300;
        }
        lockImajeView.setImageResource(lockAnimDrawable);
    }


}
