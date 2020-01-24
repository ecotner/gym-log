package com.example.gymlog.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Formatter;

@Entity(tableName = "workout_activity")
public class WorkoutActivityEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    public int id;

    @ColumnInfo
    public String wtype;

    @ColumnInfo
    public long timestamp;

    @ColumnInfo
    public int weight;

    @ColumnInfo
    public int reps;

    public WorkoutActivityEntity(String wtype, int weight, int reps) {
//        assert weight >= 0;
//        assert reps >= 0;
        this.wtype = wtype;
        this.timestamp = System.currentTimeMillis() / 1000L;
        this.weight = weight;
        this.reps = reps;
    }

    public String toString() {
        return "WorkoutActivityEntity(type=" + wtype + ", weight=" + weight +
                ", reps=" + reps + ")";
    }

    public String getDateTime() {
        return String.valueOf(this.timestamp);
    }
}
