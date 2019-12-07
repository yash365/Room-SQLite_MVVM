package com.example.roomandsqlite.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomandsqlite.dao.NoteDao;
import com.example.roomandsqlite.entity.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
