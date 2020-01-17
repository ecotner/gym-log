package com.example.gymlog.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gymlog.db.entities.WorkoutActivityEntity;

@Dao
public interface AccessDao {
    @Insert
    public void insertActivity(WorkoutActivityEntity activity);

    @Query("SELECT * FROM workout_activity")
    public WorkoutActivityEntity[] getAllActivities();
}
