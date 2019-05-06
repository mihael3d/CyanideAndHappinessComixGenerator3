package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;

public class ComicGeneratorFragment extends Fragment {

    private final int layout = R.layout.fragment_comix_genertor; // fragment_home   exemple_layout  fragment_comix_genertor
    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private Button buttonGenerate;
    private RelativeLayout relativeLayout1;
    private boolean chek;
    private  ImageView imageLock;
    public ComicGeneratorFragment() {}

    public static ComicGeneratorFragment newInstance() {
        return new ComicGeneratorFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layout, container, false);
        imageView1 = view.findViewById(R.id.imageView1);
        imageView2 = view.findViewById(R.id.imageView2);
        imageView3 = view.findViewById(R.id.imageView3);
        buttonGenerate = view.findViewById(R.id.button_generate_comix);
        cardView1 = view.findViewById(R.id.cv1 );
        cardView2 = view.findViewById(R.id.cv2 );
        cardView3 = view.findViewById(R.id.cv3 );
        imageView1.setImageResource(R.drawable.a001_2);
        relativeLayout1 = view.findViewById(R.id.relative_layout1);
        imageLock = view.findViewById(R.id.image_lock);

        // Color border change
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardLock();
            }
        });


            imageLock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardLock();
                }
            });


        // Generate button
        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final Techniques techniques = Techniques.StandUp;
            final Techniques techniques2 = Techniques.BounceInRight;

            int imageResurse = R.drawable.aaa;

                YoYo.with(techniques2)
                        .duration(700)
                        .playOn(cardView1);


                cardView2.setVisibility(View.INVISIBLE);
                imageView2.setImageResource(imageResurse);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                         YoYo.with(techniques2)
                                .duration(700)
                                .playOn(cardView2);
                        cardView2.setVisibility(View.VISIBLE);
                    }
                }, 300);

                cardView3.setVisibility(View.INVISIBLE);
                imageView3.setImageResource(imageResurse);
                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                         YoYo.with(techniques2)
                                                .duration(700)
                                                .playOn(cardView3);
                                        cardView3.setVisibility(View.VISIBLE);
                                    }
                                }, 600);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private void cardLock() {

        int cardBorder;
        int lockAnimDrawable;
        if (!chek) {
            cardBorder = R.drawable.cardborderlock;
            lockAnimDrawable = R.drawable.lock_whith_angle_lock_300;
        } else {
           cardBorder = 0;
            lockAnimDrawable = R.drawable.lock_whith_angle_un_lock_300;
        }
        relativeLayout1.setBackgroundResource(cardBorder);
            imageLock.setImageResource(lockAnimDrawable);
            Drawable imageLockDrawable = imageLock.getDrawable();
            ((Animatable) imageLockDrawable).start();
        chek = !chek;
    }

}
