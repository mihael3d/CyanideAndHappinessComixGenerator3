package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.model;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;

import java.util.ArrayList;
import java.util.Random;

public class GravityLayoutModel {


    private Cards cards;
    private ArrayList<Integer> allCards;

    private ArrayList<Integer> cardsOnTheTable;
    private ArrayList<Integer> alreadyShownСards;
    private final int cardsOnTheTableCount = 7;

    public GravityLayoutModel(){
        cardsOnTheTable =  new ArrayList();
        alreadyShownСards =  new ArrayList();
        cards = Cards.getInstance();
        allCards = cards.getCardsList();
    }
    public int getCard1Image(){
        return getRandomImage(0);
    }

    public int getCard2Image(){
        return getRandomImage(1);
    }

    public int getCard3Image(){
        return getRandomImage(2);
    }

    public int getCard4Image(){
        return getRandomImage(3);
    }

    public int getCard5Image(){
        return getRandomImage(4);
    }

    public int getCard6Image(){
        return getRandomImage(5);
    }

    public int getCard7Image(){
        return getRandomImage(6);
    }

    private int getRandomImage(int cardIndex){
        Random rand = new Random();
        int randomElement = allCards.get(rand.nextInt(allCards.size()));
        while (cardsOnTheTable.contains(randomElement)){
            randomElement = allCards.get(rand.nextInt(allCards.size()));
        }
        if (cardsOnTheTable.size()<cardsOnTheTableCount){
            cardsOnTheTable.add(cardIndex,randomElement);
        } else {
            cardsOnTheTable.set(cardIndex,randomElement);
        }
        alreadyShownСards.add(randomElement);
        return randomElement;
    }
}
