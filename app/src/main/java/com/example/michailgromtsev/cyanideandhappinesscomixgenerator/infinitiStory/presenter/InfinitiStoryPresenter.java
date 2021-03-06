package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.presenter;

import android.content.Context;
import android.content.res.Configuration;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.GlobalApplication;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.model.InfinitiStoryModel;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.view.InfinitiStoryView;

@InjectViewState
public class InfinitiStoryPresenter extends MvpPresenter<InfinitiStoryView> {
    private InfinitiStoryModel infinitiStoryModel;

    @Override
    protected void onFirstViewAttach() {
        infinitiStoryModel = InfinitiStoryModel.getInstance();
        super.onFirstViewAttach();

        getViewState().setCardsListForRecycleView(infinitiStoryModel.getCardsForRecycleView());
    }

    @Override
    public void attachView(InfinitiStoryView view) {
        super.attachView(view);
//        getViewState().setCardsListForRecycleView(infinitiStoryModel.getCardsForRecycleView());
        getViewState().scrollRecyclerViewToPosition(infinitiStoryModel.getFirstVisibleItemRecycleViewPosition());
    }

    public void onCardMoveUpOrLeft(int i){
        infinitiStoryModel.onCardMoveUpOrLeft(i);
    }

    public void onCardMoveDownOrRight(int i){
        infinitiStoryModel.onCardMoveDownOrRight(i);
    }
    public void onCardDismiss(int position) {
        infinitiStoryModel.onCardDismiss(position);
    }

     public void onRecyclerViewScroll(int currentOrientation, int dx, int dy ){
         if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
             // Landscape
             if (dx > 0)
                 getViewState().hideRefreshFloatingActionButton();
             else
                 getViewState().showRefreshFloatingActionButton();
         }
         else {
             // Portrait
             if (dy > 0)
                 getViewState().hideRefreshFloatingActionButton();
             else
                 getViewState().showRefreshFloatingActionButton();
         }

     }

     public void onRefreshFloatingButtonPressed(){
        infinitiStoryModel.generateRandomCardsForRecycleView(250);
         getViewState().setCardsListForRecycleView(infinitiStoryModel.getCardsForRecycleView());
         infinitiStoryModel.setFirstVisibleItemRecycleViewPosition(0);
         getViewState().scrollRecyclerViewToPosition(infinitiStoryModel.getFirstVisibleItemRecycleViewPosition());
     }

     public void onInfinitiStoryFragmentPoused(int firstVisibleItemRecycleViewPosition){
        infinitiStoryModel.setFirstVisibleItemRecycleViewPosition(firstVisibleItemRecycleViewPosition);
     }
}
