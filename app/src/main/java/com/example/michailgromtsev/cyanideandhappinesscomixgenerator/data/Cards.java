package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data;

import android.content.Context;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.GlobalApplication;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

public final class Cards {

    private static volatile Cards instance;
    private static volatile  ArrayList<Integer> cardsSimpleList;
    private static volatile  ArrayList<Integer> cardsFinaleList;

    public static Cards getInstance() {
        Cards localInstance = instance;
        if (localInstance == null) {
            synchronized (Cards.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Cards();
                    cardsSimpleList = instance.getFields("ch_card_");
                    //cardsFinaleList = instance.getFields("ch_card_final");

                }
            }
        }
        return localInstance;
    }

    public static ArrayList<Integer> getCardsSimpleList() {
        return cardsSimpleList;
    }

    public static ArrayList<Integer> getCardsFinaleList() {
        return cardsFinaleList;
    }

    private  ArrayList<Integer> getFields(String cardsName){

        ArrayList<Integer> imageListId = new ArrayList<Integer>();
        Context context = GlobalApplication.getAppContext();

        Field[] drawables = R.drawable.class.getFields();
        for (Field f : drawables) {
            //if the drawable name contains "ic_card_" in the filename...
            if (f.getName().contains(cardsName))
                imageListId.add( context.getResources().getIdentifier(f.getName(), "drawable", context.getPackageName()));
        }
        return imageListId;
    }
}
