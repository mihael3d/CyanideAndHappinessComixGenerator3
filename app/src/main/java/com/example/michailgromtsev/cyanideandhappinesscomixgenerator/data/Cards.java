package com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data;

import android.content.Context;
import android.util.Log;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.GlobalApplication;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.xml.datatype.DatatypeConstants;

public final class Cards {

    private static volatile Cards instance;
    private static volatile  ArrayList<Integer> cardsList;

    public static Cards getInstance() {
        Cards localInstance = instance;
        if (localInstance == null) {
            synchronized (Cards.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Cards();
                    cardsList = instance.getFields();
                }
            }
        }
        return localInstance;
    }

    public static ArrayList<Integer> getCardsList() {
        return cardsList;
    }


    private  ArrayList<Integer> getFields(){
        //first we create an array list to hold all the resources ids
        ArrayList<Integer> imageListId = new ArrayList<Integer>();
        Context context = GlobalApplication.getAppContext();

//we iterate through all the items in the drawable folder
        Field[] drawables = R.drawable.class.getFields();
        for (Field f : drawables) {
            //if the drawable name contains "ic_card_" in the filename...
            if (f.getName().contains("card"))
                imageListId.add( context.getResources().getIdentifier(f.getName(), "drawable", context.getPackageName()));
        }
        return imageListId;
    }
}
