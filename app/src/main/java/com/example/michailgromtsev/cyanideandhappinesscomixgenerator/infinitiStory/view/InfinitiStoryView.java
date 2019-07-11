package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface InfinitiStoryView extends MvpView {

    void setCardsListForRecycleView(List<Integer> cards);

    void showRefreshFloatingActionButton();

    void hideRefreshFloatingActionButton();

    void scrollRecyclerViewToPosition (int position);

}
