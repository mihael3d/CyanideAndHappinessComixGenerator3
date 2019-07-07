package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.daimajia.androidanimations.library.Techniques;
@StateStrategyType(AddToEndSingleStrategy.class)
public interface ComicGeneratorView  extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setLoc1LockedByAnimation(boolean locked);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setLock2LockedByAnimation(boolean locked);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setLock3LockedByAnimation(boolean locked);



    void setLock1LockedWithNoAnimation(boolean locked);


    void setLock2LockedWithNoAnimation(boolean locked);


    void setLock3LockedWithNoAnimation(boolean locked);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showCard1BorderLocked(boolean locked);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showCard2BorderLocked(boolean locked);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showCard3BorderLocked(boolean locked);


    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard1Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard2Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard3Image(int imaje);


    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard1Appearance(Techniques techniquesEffect, long delayMillis);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard2Appearance(Techniques techniquesEffect, long delayMillis);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard3Appearance(Techniques techniquesEffect, long delayMillis);

}
