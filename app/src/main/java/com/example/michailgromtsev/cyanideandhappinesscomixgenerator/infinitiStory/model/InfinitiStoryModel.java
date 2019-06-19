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

    private ArrayList<Integer> integers  = new ArrayList<Integer>(
            Arrays.asList(
                    R.drawable.ic_card_1,R.drawable.ic_card_2,R.drawable.ic_card_3,R.drawable.ic_card_4,
                    R.drawable.ic_card_5,R.drawable.ic_card_6,R.drawable.ic_card_1,R.drawable.ic_card_2));

    public InfinitiStoryModel() {
        cards = Cards.getInstance();
        allCards = cards.getCardsSimpleList();
        cardsOnRecycleView = new ArrayList<>();
    }
    public ArrayList<Integer> getNewRandomCardsForRecycleView(int length){
        cardsOnRecycleView.clear();
        integers.clear();
        Random rand = new Random();
        while(cardsOnRecycleView.size() < length) {
            int randomElement = allCards.get(rand.nextInt(allCards.size()));
//            if (!cardsOnRecycleView.contains(randomElement)){
//                cardsOnRecycleView.add(randomElement);
//            }
            cardsOnRecycleView.add(randomElement);
        }
        return cardsOnRecycleView;
    }

    public ArrayList<Integer> getCardsOnRecycleView() {
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

    private ArrayList<Integer> geRandomCards(int length){

        ArrayList<Integer> cardList = new ArrayList<>();
        Random rand = new Random();
        while(cardList.size() < length) {
            int randomElement = allCards.get(rand.nextInt(allCards.size()));
            if (!cardList.contains(randomElement)){
                cardList.add(randomElement);
            }
        }
        return cardList;
    }

}
