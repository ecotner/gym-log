package com.example.gymlog.db;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.gymlog.db.entities.WorkoutActivityEntity;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static final String DB_NAME = "gymlog_db";
    public AppDatabase db;

    public Repository(Context context) {
        this.db = Room.databaseBuilder(
            context,
            AppDatabase.class,
            this.DB_NAME).build();
    }

    public void insertActivity(final WorkoutActivityEntity activity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.accessDao().insertActivity(activity);
            }
        }).start();
    }

    public void insertActivity(String type, double weight, int reps) {
        WorkoutActivityEntity activity = new WorkoutActivityEntity(type, weight, reps);
        insertActivity(activity);
    }

    public List<WorkoutActivityEntity> getAllActivities() {
        final List<WorkoutActivityEntity> activities = new ArrayList<>();
        Thread t = new Thread() {
            @Override
            public void run() {
                WorkoutActivityEntity[] acts = db.accessDao().getAllActivities();
                for (WorkoutActivityEntity e: acts)
                    activities.add(e);
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Log.w("DATABASE", "getAllActivities interrupted");
        }
        return activities;
    }

    public List<WorkoutActivityEntity> getRecentActivities(final int N) {
        final List<WorkoutActivityEntity> activities = new ArrayList<>();
        Thread t = new Thread() {
            @Override
            public void run() {
                WorkoutActivityEntity[] acts = db.accessDao().getRecentActivities(N);
                for (WorkoutActivityEntity e: acts)
                    activities.add(e);
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Log.w("DATABASE", "getRecentActivities interrupted");
        }
        return activities;
    }

    public List<WorkoutActivityEntity> getRecentActivitiesByType(final int N) {
        final List<WorkoutActivityEntity> activities = new ArrayList<>();
        Thread t = new Thread() {
            @Override
            public void run() {
                WorkoutActivityEntity[] acts = db.accessDao().getRecentActivitiesByType(N);
                for (WorkoutActivityEntity e: acts)
                    activities.add(e);
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Log.w("DATABASE", "getRecentActivitiesByType interrupted");
        }
        return activities;
    }

    public List<String> getDistinctWtypes() {
        final List<String> wtypes = new ArrayList<>();
        Thread t = new Thread() {
            @Override
            public void run() {
                String[] wtypes_str = db.accessDao().getDistinctWtypes();
                for (String wt: wtypes_str)
                    wtypes.add(wt);
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Log.w("DATABASE", "getDistinctWtypes interrupted");
        }
        return wtypes;
    }

    public List<WorkoutActivityEntity> getFrequentActivitiesByType(final int N) {
        final List<WorkoutActivityEntity> activities = new ArrayList<>();
        Thread t = new Thread() {
            @Override
            public void run() {
                WorkoutActivityEntity[] acts = db.accessDao().getFrequentActivitiesByType(N);
                for (WorkoutActivityEntity e: acts)
                    activities.add(e);
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            Log.w("DATABASE", "getRecentActivitiesByType interrupted");
        }
        return activities;
    }
}
