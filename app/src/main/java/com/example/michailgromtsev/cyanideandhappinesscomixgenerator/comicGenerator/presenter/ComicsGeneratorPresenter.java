package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.daimajia.androidanimations.library.Techniques;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.view.ComicGeneratorView;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.model.CommixGeneratorModel;


@InjectViewState
public class ComicsGeneratorPresenter extends MvpPresenter<ComicGeneratorView> {


    private CommixGeneratorModel comixGeneratorModel;

    @Override
    protected void onFirstViewAttach() {
            super.onFirstViewAttach();
        comixGeneratorModel = CommixGeneratorModel.getInstance();
        getViewState().setCard1Image(comixGeneratorModel.getCard1Image());
        getViewState().setCard2Image(comixGeneratorModel.getCard2Image());
        getViewState().setCard3Image(comixGeneratorModel.getCard3Image());

//        getViewState().setLoc1LockedByAnimation(comixGeneratorModel.isCard1Locked());
//        getViewState().setLock2LockedByAnimation(comixGeneratorModel.isCard2Locked());
//        getViewState().setLock3LockedByAnimation(comixGeneratorModel.isCard3Locked());
        getViewState().showCard1BorderLocked(comixGeneratorModel.isCard1Locked());
        getViewState().showCard2BorderLocked(comixGeneratorModel.isCard2Locked());
        getViewState().showCard3BorderLocked(comixGeneratorModel.isCard3Locked());


        }
        @Override
        public void attachView(ComicGeneratorView view) {
            super.attachView(view);
            getViewState().setLock1LockedWithNoAnimation(comixGeneratorModel.isCard1Locked());
            getViewState().setLock2LockedWithNoAnimation(comixGeneratorModel.isCard2Locked());
            getViewState().setLock3LockedWithNoAnimation(comixGeneratorModel.isCard3Locked());
        }
        @Override
        public void detachView(ComicGeneratorView view) {
            super.detachView(view);
    }

    public  void onLock1Press(){
        boolean card1Locked = comixGeneratorModel.isCard1Locked();
        card1Locked=!card1Locked;
        comixGeneratorModel.setCard1Locked(card1Locked);
        getViewState().setLoc1LockedByAnimation(card1Locked);
        getViewState().showCard1BorderLocked(card1Locked);
    }

    public  void onLock2Press(){
        boolean card2Locked = comixGeneratorModel.isCard2Locked();
        card2Locked=!card2Locked;
        comixGeneratorModel.setCard2Locked(card2Locked);
        getViewState().setLock2LockedByAnimation(card2Locked);
        getViewState().showCard2BorderLocked(card2Locked);
    }

    public  void onLock3Press(){
        boolean card3Locked = comixGeneratorModel.isCard3Locked();
        card3Locked=!card3Locked;
        comixGeneratorModel.setCard3Locked(card3Locked);
        getViewState().setLock3LockedByAnimation(card3Locked);
        getViewState().showCard3BorderLocked(card3Locked);
    }

    public void onCard1pres () {
        boolean card1Locked = comixGeneratorModel.isCard1Locked();
        card1Locked=!card1Locked;
        comixGeneratorModel.setCard1Locked(card1Locked);
        getViewState().setLoc1LockedByAnimation(card1Locked);
        getViewState().showCard1BorderLocked(card1Locked);
    }

    public void onCard2pres () {
        boolean card2Locked = comixGeneratorModel.isCard2Locked();
        card2Locked=!card2Locked;
        comixGeneratorModel.setCard2Locked(card2Locked);
        getViewState().setLock2LockedByAnimation(card2Locked);
        getViewState().showCard2BorderLocked(card2Locked);
    }

    public void onCard3pres () {
        boolean card3Locked = comixGeneratorModel.isCard3Locked();
        card3Locked=!card3Locked;
        comixGeneratorModel.setCard3Locked(card3Locked);
        getViewState().setLock3LockedByAnimation(card3Locked);
        getViewState().showCard3BorderLocked(card3Locked);
    }

    public void onButtonGeneratePressed(){

        Techniques  techniques =  comixGeneratorModel.getTechniques();

//        comixGeneratorModel.getFields();

        if(!comixGeneratorModel.isCard1Locked()) {
            getViewState().setCard1Appearance( techniques,comixGeneratorModel.getDelayForCard1Show());
            comixGeneratorModel.randomCard1Image();
            getViewState().setCard1Image(comixGeneratorModel.getCard1Image());
        }
       if (!comixGeneratorModel.isCard2Locked()){
           getViewState().setCard2Appearance( techniques,comixGeneratorModel.getDelayForCard2Show());
           comixGeneratorModel.randomCard2Image();
           getViewState().setCard2Image(comixGeneratorModel.getCard2Image());
       }
       if (!comixGeneratorModel.isCard3Locked()){
           getViewState().setCard3Appearance( techniques,comixGeneratorModel.getDelayForCard3Show());
           comixGeneratorModel.randomCard3Image();
           getViewState().setCard3Image(comixGeneratorModel.getCard3Image());
       }
    }
}
