package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
@StateStrategyType(AddToEndSingleStrategy.class)
public interface GravityLayoutView  extends MvpView {


    void setCard1Image(int image);

    void setCard2Image(int image);

    void setCard3Image(int image);

    void setCard4Image(int image);

    void setCard5Image(int image);

    void setCardsToPositions(float[] cardsCoordinats, int orientatation);

    void showCard1BorderLocked(boolean locked);

    void showCard2BorderLocked(boolean locked);

    void showCard3BorderLocked(boolean locked);

    void showCard4BorderLocked(boolean locked);

    void showCard5BorderLocked(boolean locked);


    void setCard1Jump(boolean needJump);

    void setCard2Jump(boolean needJump);

    void setCard3Jump(boolean needJump);

    void setCard4Jump(boolean needJump);

    void setCard5Jump(boolean needJump);


}
