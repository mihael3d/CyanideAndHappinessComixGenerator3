package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.model.GravityLayoutModel;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.view.GravityLayoutView;

@InjectViewState
public class GravityLayoutPresenter extends MvpPresenter<GravityLayoutView> {

    private GravityLayoutModel gravityLayoutModel;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        gravityLayoutModel = new GravityLayoutModel();
        getViewState().setCard1Image(gravityLayoutModel.getCard1Image());
        getViewState().setCard2Image(gravityLayoutModel.getCard2Image());
        getViewState().setCard3Image(gravityLayoutModel.getCard3Image());
        getViewState().setCard4Image(gravityLayoutModel.getCard4Image());
        getViewState().setCard5Image(gravityLayoutModel.getCard5Image());
        getViewState().setCard6Image(gravityLayoutModel.getCard6Image());
        getViewState().setCard7Image(gravityLayoutModel.getCard7Image());
    }

    public void onRefreshFloatingButtonPressed() {
        getViewState().setCard1Image(gravityLayoutModel.getCard1Image());
        getViewState().setCard2Image(gravityLayoutModel.getCard2Image());
    getViewState().setCard3Image(gravityLayoutModel.getCard3Image());
    getViewState().setCard4Image(gravityLayoutModel.getCard4Image());
    getViewState().setCard5Image(gravityLayoutModel.getCard5Image());
    getViewState().setCard6Image(gravityLayoutModel.getCard6Image());
    getViewState().setCard7Image(gravityLayoutModel.getCard7Image());
}
}
