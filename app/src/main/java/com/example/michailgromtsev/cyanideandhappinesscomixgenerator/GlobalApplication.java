package com.example.michailgromtsev.cyanideandhappinesscomixgenerator;

import android.app.Application;
import android.content.Context;

import com.example.michailgromtsev.cyanideandhappinesscomixgenerator.data.Cards;

public class GlobalApplication extends Application {
private Cards cards;
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
        cards = Cards.getInstance();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
