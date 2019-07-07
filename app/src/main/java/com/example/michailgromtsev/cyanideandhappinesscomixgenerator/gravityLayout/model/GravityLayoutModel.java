package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.model;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;

import java.util.ArrayList;
import java.util.Random;

public class GravityLayoutModel {
    private Cards cards;
    private ArrayList<Integer> allCards;
    private ArrayList<Integer> cardsOnTheTable;
    private ArrayList<Integer> wasShownCards;
    private final int cardsOnTheTableCount = 5;

    private float[] cardsPortraitOrientation;
    private float[] cardsLandscapeOrientation;
    private boolean [] cardsNeedToSave;

    private static volatile GravityLayoutModel instance;

    public static GravityLayoutModel getInstance() {
        GravityLayoutModel localInstance = instance;
        if (localInstance == null) {
            synchronized (GravityLayoutModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new GravityLayoutModel();
                }
            }
        }
        return localInstance;
    }

    private GravityLayoutModel(){
        cardsOnTheTable =  new ArrayList();
        wasShownCards   =  new ArrayList();
        cards = Cards.getInstance();
        allCards = cards.getCardsSimpleList();

      //  cardsNeedToSave = new boolean[5];
  

        randomCard1Image();
        randomCard2Image();
        randomCard3Image();
        randomCard4Image();
        randomCard5Image();

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

    public void randomCard4Image(){
        generateRandomImageforCardsOnTheTableList(3);
    }

    public void randomCard5Image(){
        generateRandomImageforCardsOnTheTableList(4);
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

    public int getCard4Image(){
        return cardsOnTheTable.get(3);
    }

    public int getCard5Image(){
        return cardsOnTheTable.get(4);
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

    public float[] getCardsPortraitOrientation() {
        return cardsPortraitOrientation;
    }

    public void setCardsPortraitOrientation(float[] cardsPortraitOrientation) {
        this.cardsPortraitOrientation = cardsPortraitOrientation;
    }

    public float[] getCardsLandscapeOrientation() {
        return cardsLandscapeOrientation;
    }

    public void setCardsLandscapeOrientation(float[] cardsLandscapeOrientation) {
        this.cardsLandscapeOrientation = cardsLandscapeOrientation;
    }

    public boolean[] getCardsNeedToSave() {
        return cardsNeedToSave;
    }

    public void setCardsNeedToSave(boolean[] cardsNeedToSave) {
        this.cardsNeedToSave = cardsNeedToSave;
    }
}
