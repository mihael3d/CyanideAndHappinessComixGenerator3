package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.model;

import com.daimajia.androidanimations.library.Techniques;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComixGeneratorModel {
    private boolean card1Locked;
    private boolean card2Locked;
    private boolean card3Locked;

    private List<Techniques> techniquesyList = Arrays.asList(Techniques.DropOut,
            Techniques.Landing, Techniques.Pulse, Techniques.RubberBand, Techniques.Shake
            ,Techniques.Swing,Techniques.Wobble, Techniques.Bounce, Techniques.Tada
            ,Techniques.StandUp,Techniques.Wave, Techniques.BounceIn, Techniques.BounceInDown
            ,Techniques.BounceInLeft, Techniques.BounceInRight, Techniques.BounceInUp
            ,Techniques.FadeIn, Techniques.FlipInX, Techniques.FlipInY
           );

    private ArrayList<Integer> cardsOnTheTable;
    private ArrayList<Integer> alreadyShownСards;

    private Cards cards;
    private ArrayList<Integer> simpleCards;
    private ArrayList<Integer> finaleCards;


    public ComixGeneratorModel(){
        cardsOnTheTable =  new ArrayList();
        alreadyShownСards =  new ArrayList();
        cards = Cards.getInstance();
        simpleCards = cards.getCardsSimpleList();
        finaleCards = cards.getCardsFinaleList();
    }

    //Animation for card appearance
    public Techniques getTechniques(){
        Random rand = new Random();
        Techniques randomTechniques = techniquesyList.get(rand.nextInt(techniquesyList.size()));
        return randomTechniques;
    }


    public int getCard1Image(){
        return getRandomSimpleCardImage(0);
    }

    public int getCard2Image(){
        return getRandomSimpleCardImage(1);
    }

    public int getCard3Image(){
        return getRandomSimpleCardImage(2);
        //return getRandomFinaleCardImage();
    }

    private int getRandomSimpleCardImage(int cardIndex){
        Random rand = new Random();
        int randomElement = simpleCards.get(rand.nextInt(simpleCards.size()));
                while (cardsOnTheTable.contains(randomElement)){
                    randomElement = simpleCards.get(rand.nextInt(simpleCards.size()));
                }
        if (cardsOnTheTable.size()<3){
            cardsOnTheTable.add(cardIndex,randomElement);
        } else {
            cardsOnTheTable.set(cardIndex,randomElement);
        }
        alreadyShownСards.add(randomElement);
        return randomElement;
    }

    private int getRandomFinaleCardImage(){
        Random rand = new Random();
        int randomElement = finaleCards.get(rand.nextInt(finaleCards.size()));
        return randomElement;
    }
    public long getDelayForCard1Show(){
        return 0;
    }

    public long getDelayForCard2Show(){
        if (card1Locked) {
            return 0;
        } else {
            return 500;
        }
    }

    public long getDelayForCard3Show(){
        if (card1Locked&card2Locked){
            return 0;
        } else if (card1Locked||card2Locked){
            return 500;
        } else {
            return 700;
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
