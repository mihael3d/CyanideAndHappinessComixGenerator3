package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.app.Application;
import android.content.Context;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.comicGenerator.model.CommixGeneratorModel;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.gravityLayout.model.GravityLayoutModel;
import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.infinitiStory.model.InfinitiStoryModel;

public class GlobalApplication extends Application {
private Cards cards;
private GravityLayoutModel gravityLayoutModel;
private CommixGeneratorModel comixGeneratorModel;
private InfinitiStoryModel infinitiStoryModel;
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
        cards = Cards.getInstance();
        gravityLayoutModel = GravityLayoutModel.getInstance();
        comixGeneratorModel = CommixGeneratorModel.getInstance();
        infinitiStoryModel = InfinitiStoryModel.getInstance();

    }

    public static Context getAppContext() {
        return appContext;
    }
}
