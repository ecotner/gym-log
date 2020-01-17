package com.example.gymlog.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(name = "type_idx", value = "type", unique = true)})
public class WorkoutTypeEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    int id;

    @ColumnInfo
    String type;
}
