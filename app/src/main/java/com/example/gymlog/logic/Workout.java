package com.example.gymlog.logic;

import androidx.room.Ignore;

import com.example.gymlog.db.entities.WorkoutActivityEntity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Workout extends WorkoutActivityEntity {

    public String wtype;
    public String wgroup;
    public Integer is_cardio;

    public Workout() {

    }

    public String toString() {
        if (is_cardio == null) {
            return "Workout(id=" + id + ", type=" + wtype + ")";
        } else if (is_cardio == 0) {
            return "Workout(id=" + id + ", type=" + wtype + ", weight="
                    + weight + ", reps=" + reps + ")";
        } else {
            return "Workout(id=" + id + ", type=" + wtype + ", time_sec="
                    + duration_sec + ", dist_mi=" + distance_mi + ")";
        }
    }

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
