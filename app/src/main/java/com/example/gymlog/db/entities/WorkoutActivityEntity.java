package com.example.gymlog.db.entities;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

@Entity(tableName = "workout_activity")
public class WorkoutActivityEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    public Integer id;

    @ColumnInfo
    public Long timestamp;

    @ColumnInfo
    public Double weight;

    @ColumnInfo
    public Integer reps;

    @ColumnInfo
    public Integer wtype_id;

    @ColumnInfo
    public Integer duration_sec;

    @ColumnInfo
    public Double distance_mi;


//    public WorkoutActivityEntity(double weight, int reps) {
////        this.wtype = wtype;
//        this.timestamp = System.currentTimeMillis() / 1000L;
//        this.weight = weight;
//        this.reps = reps;
//    }

//    public WorkoutActivityEntity(String wtype, int duration_sec, double distance_mi) {
//        this.wtype = wtype;
//        this.timestamp = System.currentTimeMillis() / 1000L;
//        this.duration_sec = duration_sec;
//        this.distance_mi = distance_mi;
//    }
}
