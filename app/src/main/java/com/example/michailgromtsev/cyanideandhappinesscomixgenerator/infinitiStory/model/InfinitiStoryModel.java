package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.model;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class InfinitiStoryModel {
    private Cards cards;
    private ArrayList<Integer> allCards;
    private ArrayList<Integer> cardsOnRecycleView;
    private int firstVisibleItemRecycleViewPosition;
    public static volatile InfinitiStoryModel instance;

    public static InfinitiStoryModel getInstance(){
        InfinitiStoryModel localinstace = instance;
        if (instance == null){
            synchronized (InfinitiStoryModel.class){
                localinstace = instance;
                if (localinstace == null) {
                    instance = localinstace = new InfinitiStoryModel();
                }
            }
        }
        return localinstace;
    }

    private InfinitiStoryModel() {
        cards = Cards.getInstance();
        allCards = cards.getCardsSimpleList();
        cardsOnRecycleView = new ArrayList<>();
        generateRandomCardsForRecycleView(250);
    }

    public void generateRandomCardsForRecycleView(int length){
        cardsOnRecycleView.clear();

        Random rand = new Random();
        while(cardsOnRecycleView.size() < length) {
            int randomElement = allCards.get(rand.nextInt(allCards.size()));
            if (!cardsOnRecycleView.contains(randomElement)){
                cardsOnRecycleView.add(randomElement);
            }
        }
    }

    public  ArrayList<Integer> getCardsForRecycleView(){
        return cardsOnRecycleView;
    }

    public void onCardMoveUpOrLeft(int i){
        Collections.swap(cardsOnRecycleView, i, i+1);
    }

    public void onCardMoveDownOrRight(int i){
        Collections.swap(cardsOnRecycleView, i, i-1);
    }

    public void onCardDismiss(int position){
        cardsOnRecycleView.remove(position);
    }

    public int getFirstVisibleItemRecycleViewPosition() {
        return firstVisibleItemRecycleViewPosition;
    }

    public void setFirstVisibleItemRecycleViewPosition(int firstVisibleItemRecycleViewPosition) {
        this.firstVisibleItemRecycleViewPosition = firstVisibleItemRecycleViewPosition;
    }
}
