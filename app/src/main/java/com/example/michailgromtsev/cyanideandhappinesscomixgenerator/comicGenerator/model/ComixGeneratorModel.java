package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.model;

import com.daimajia.androidanimations.library.Techniques;

public class ComixGeneratorModel {
    private boolean card1Locked = false;
    private boolean card2Locked = false;
    private boolean card3Locked = false;


    public Techniques getTechniques(){
        return Techniques.DropOut;
    }

    public long getDelayForCard1Show(){
        return 0;
    }

    public long getDelayForCard2Show(){
        if (card1Locked) {
            return 0;
        } else {
            return 300;
        }
    }

    public long getDelayForCard3Show(){
        if (card1Locked&card2Locked){
            return 0;
        } else if (card1Locked||card2Locked){
            return 300;
        } else {
            return 600;
        }
    }

    public boolean isCard1Locked() {
        return card1Locked;
    }

    public void setCard1Locked(boolean card1Locked) {
        this.card1Locked = card1Locked;
    }

    public boolean isCard2Locked() {
        return card2Locked;
    }

    public void setCard2Locked(boolean card2Locked) {
        this.card2Locked = card2Locked;
    }

    public boolean isCard3Locked() {
        return card3Locked;
    }

    public void setCard3Locked(boolean card3Locked) {
        this.card3Locked = card3Locked;
    }
}
