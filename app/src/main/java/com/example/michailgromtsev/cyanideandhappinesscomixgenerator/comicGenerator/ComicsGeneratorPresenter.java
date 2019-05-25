package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.daimajia.androidanimations.library.Techniques;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.model.ComixGeneratorModel;


@InjectViewState
public class ComicsGeneratorPresenter extends MvpPresenter<ComicGeneratorView> {


    private ComixGeneratorModel  comixGeneratorModel;

    @Override
    protected void onFirstViewAttach() {
            super.onFirstViewAttach();
        comixGeneratorModel = new ComixGeneratorModel();
        }
        @Override
        public void attachView(ComicGeneratorView view) {
            super.attachView(view);
        }
        @Override
        public void detachView(ComicGeneratorView view) {
            super.detachView(view);
    }

    public  void onLock1Press(){
        boolean card1Locked = comixGeneratorModel.isCard1Locked();
        card1Locked=!card1Locked;
        comixGeneratorModel.setCard1Locked(card1Locked);
        getViewState().setLoc1kLocked(card1Locked);
        getViewState().showCard1BorderLocked(card1Locked);
    }

    public  void onLock2Press(){
        boolean card2Locked = comixGeneratorModel.isCard2Locked();
        card2Locked=!card2Locked;
        comixGeneratorModel.setCard2Locked(card2Locked);
        getViewState().setLock2Locked(card2Locked);
        getViewState().showCard2BorderLocked(card2Locked);
    }

    public  void onLock3Press(){
        boolean card3Locked = comixGeneratorModel.isCard3Locked();
        card3Locked=!card3Locked;
        comixGeneratorModel.setCard3Locked(card3Locked);
        getViewState().setLock3Locked(card3Locked);
        getViewState().showCard3BorderLocked(card3Locked);
    }

    public void onCard1pres () {
        boolean card1Locked = comixGeneratorModel.isCard1Locked();
        card1Locked=!card1Locked;
        comixGeneratorModel.setCard1Locked(card1Locked);
        getViewState().setLoc1kLocked(card1Locked);
        getViewState().showCard1BorderLocked(card1Locked);
    }

    public void onCard2pres () {
        boolean card2Locked = comixGeneratorModel.isCard2Locked();
        card2Locked=!card2Locked;
        comixGeneratorModel.setCard2Locked(card2Locked);
        getViewState().setLock2Locked(card2Locked);
        getViewState().showCard2BorderLocked(card2Locked);
    }

    public void onCard3pres () {
        boolean card3Locked = comixGeneratorModel.isCard3Locked();
        card3Locked=!card3Locked;
        comixGeneratorModel.setCard3Locked(card3Locked);
        getViewState().setLock3Locked(card3Locked);
        getViewState().showCard3BorderLocked(card3Locked);
    }

    public void onButtonGeneratePressed(){

        Techniques  techniques =  comixGeneratorModel.getTechniques();

        if(!comixGeneratorModel.isCard1Locked()) {
            getViewState().setCard1Appearance( techniques,comixGeneratorModel.getDelayForCard1Show());
            getViewState().setCard1Image(R.drawable.a001_2);
        }
       if (!comixGeneratorModel.isCard2Locked()){
           getViewState().setCard2Appearance( techniques,comixGeneratorModel.getDelayForCard2Show());
           getViewState().setCard2Image(R.drawable.a001_2);
       }
       if (!comixGeneratorModel.isCard3Locked()){
           getViewState().setCard3Appearance( techniques,comixGeneratorModel.getDelayForCard3Show());
           getViewState().setCard3Image(R.drawable.a001_2);
       }
    }
}
