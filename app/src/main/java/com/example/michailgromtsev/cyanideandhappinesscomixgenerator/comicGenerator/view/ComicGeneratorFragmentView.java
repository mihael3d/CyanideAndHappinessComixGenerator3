package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view;


import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public interface ComicGeneratorFragmentView {

//    void showCardLockBorder(RelativeLayout relativeLayout);
//
//    void hideCardLockBorder(RelativeLayout relativeLayout);
//
//    void showCloseLock(ImageView imageLock);
//
//    void showOpenLock(ImageView imageLock);

    void showCard1Lock();

    void showCard1UnLock();

    void showCard2Lock();

    void showCard2UnLock();

    void showCard3Lock();

    void showCard3UnLock();

    void setCardImage1 (int imageVectorDravable);

    void setCardImage2 (int imageVectorDravable);

    void setCardImage3 (int imageVectorDravable);

    void setCardYoYoAnimation (Techniques techniques);

    void showNewCard1();

    void showNewCard2();

    void showNewCard3();

}
