package com.example.gymlog.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gymlog.db.entities.WorkoutActivityEntity;
import com.example.gymlog.db.entities.WorkoutTypeEntity;
import com.example.gymlog.db.entities.WorkoutGroupEntity;

@Database(
        entities = {
                WorkoutActivityEntity.class,
                WorkoutTypeEntity.class,
                WorkoutGroupEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AccessDao accessDao();
}
