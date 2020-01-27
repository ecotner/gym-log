package com.example.gymlog.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workout_group")
public class WorkoutGroupEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    public Integer id;

    @ColumnInfo
    public String name;

    @ColumnInfo
    public Integer is_cardio;

    public WorkoutGroupEntity() {

    }
}
