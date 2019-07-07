package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.model;

import com.daimajia.androidanimations.library.Techniques;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommixGeneratorModel {
    private boolean card1Locked;
    private boolean card2Locked;
    private boolean card3Locked;

    private List<Techniques> techniquesyList;

    private ArrayList<Integer> cardsOnTheTable;
    private ArrayList<Integer> wasShownCards;
    private final int cardsOnTheTableCount = 3;

    private Cards cards;
    private ArrayList<Integer> allCards;


    private static volatile CommixGeneratorModel instance;

    public static CommixGeneratorModel getInstance() {
        CommixGeneratorModel localinstance = instance;
        if (localinstance == null) {
            synchronized (CommixGeneratorModel.class){
                localinstance = instance;
                if (localinstance == null) {
                    instance = localinstance = new CommixGeneratorModel();
                }
            }
        }
        return localinstance;
    }

    private CommixGeneratorModel(){
        cardsOnTheTable =  new ArrayList();
        wasShownCards   =  new ArrayList();
        cards = Cards.getInstance();
        allCards = cards.getCardsSimpleList();
        //finaleCards = cards.getCardsFinaleList();
        techniquesyList = Arrays.asList(Techniques.DropOut,
                Techniques.Landing, Techniques.Pulse, Techniques.RubberBand, Techniques.Shake
                ,Techniques.Swing,Techniques.Wobble, Techniques.Bounce, Techniques.Tada
                ,Techniques.StandUp,Techniques.Wave, Techniques.BounceIn, Techniques.BounceInDown
                ,Techniques.BounceInLeft, Techniques.BounceInRight, Techniques.BounceInUp
                ,Techniques.FadeIn, Techniques.FlipInX, Techniques.FlipInY
        );
        randomCard1Image();
        randomCard2Image();
        randomCard3Image();
    }

    //Animation for card appearance
    public Techniques getTechniques(){
        Random rand = new Random();
        Techniques randomTechniques = techniquesyList.get(rand.nextInt(techniquesyList.size()));
        return randomTechniques;
    }


    public int getCard1Image(){
        return cardsOnTheTable.get(0);
    }

    public int getCard2Image(){
        return cardsOnTheTable.get(1);
    }

    public int getCard3Image(){
        return cardsOnTheTable.get(2);
    }

    public void randomCard1Image(){
        generateRandomImageforCardsOnTheTableList(0);
    }

    public void randomCard2Image(){
        generateRandomImageforCardsOnTheTableList(1);
    }

    public void randomCard3Image(){
        generateRandomImageforCardsOnTheTableList(2);
    }

    private void generateRandomImageforCardsOnTheTableList(int cardIndex){
        Random rand = new Random();

        int randomElement = allCards.get(rand.nextInt(allCards.size()));

        while (wasShownCards.contains(randomElement)||cardsOnTheTable.contains(randomElement)){
            randomElement = allCards.get(rand.nextInt(allCards.size()));
        }

        if (cardsOnTheTable.size()<cardsOnTheTableCount){
            cardsOnTheTable.add(cardIndex,randomElement);
        } else {
            cardsOnTheTable.set(cardIndex,randomElement);
        }
        wasShownCards.add(randomElement);
        if (wasShownCards.size()>= (allCards.size()-70)){
            wasShownCards.clear();
        }

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
