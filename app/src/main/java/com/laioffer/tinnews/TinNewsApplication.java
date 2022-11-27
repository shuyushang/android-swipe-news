package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.laioffer.tinnews.database.TinNewsDatabase;

//singleton只会存在一个，同一个instance
public class TinNewsApplication extends Application {

    private static TinNewsDatabase database;

    @Override
    public void onCreate() {
        //application class life cycle
        super.onCreate();
        database = Room.databaseBuilder(this, TinNewsDatabase.class, "tinnews_db").build();

    }
    public static TinNewsDatabase getDatabase() {
        return database;
    }
}
