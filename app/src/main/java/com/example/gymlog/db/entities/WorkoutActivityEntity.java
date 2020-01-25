package com.example.gymlog.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
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
    public int id;

    @ColumnInfo
    public String wtype;

    @ColumnInfo
    public long timestamp;

    @ColumnInfo
    public double weight;

    @ColumnInfo
    public int reps;

    public WorkoutActivityEntity(String wtype, double weight, int reps) {
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

    // TODO
    public String[] getDateTime() {
        String[] dt_str = new String[2];
        Instant instant = Instant.ofEpochMilli(1000L * this.timestamp);
        LocalDateTime dt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter f = DateTimeFormatter.ofPattern("u-M-d");
        dt_str[0] = dt.format(f);
        f = DateTimeFormatter.ofPattern("HH:mm:ss");
        dt_str[1] = dt.format(f);
        return dt_str;
    }
}
