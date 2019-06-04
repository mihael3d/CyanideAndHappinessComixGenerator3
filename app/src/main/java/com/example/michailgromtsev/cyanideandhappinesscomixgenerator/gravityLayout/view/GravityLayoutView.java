package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface GravityLayoutView  extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard1Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard2Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard3Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard4Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard5Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard6Image(int imaje);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCard7Image(int imaje);


}
