package com.example.gymlog.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gymlog.db.entities.WorkoutActivityEntity;

@Database(
        entities = {
                WorkoutActivityEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccessDao accessDao();
}
