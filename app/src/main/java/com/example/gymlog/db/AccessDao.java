package com.example.gymlog.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.gymlog.db.entities.WorkoutActivityEntity;
import com.example.gymlog.logic.Workout;


@Dao
public interface AccessDao {
    @Transaction
    @Query("INSERT INTO workout_activity (timestamp) VALUES (:t)")
    public void insertActivity(int t);

    @Query("SELECT wa.*, wt.name AS wtype, wg.name AS wgroup, wg.is_cardio " +
            "FROM workout_activity wa " +
            "LEFT JOIN workout_type wt " +
            "ON wt.id = wa.wtype_id " +
            "LEFT JOIN workout_group wg " +
            "ON wg.id = wt.group_id ")
    public Workout[] getAllActivities();
//
//    @Query(
//        "SELECT * FROM workout_activity " +
//        "ORDER BY timestamp DESC " +
//        "LIMIT :N"
//    )
//    public WorkoutActivityEntity[] getRecentActivities(int N);
//
//    @Query(
//        "SELECT wa.* " +
//        "FROM workout_activity AS wa " +
//        "INNER JOIN ( " +
//        "   SELECT wtype, MAX(timestamp) AS max_time " +
//        "   FROM workout_activity " +
//        "   GROUP BY wtype " +
//        ") AS x " +
//        "   ON x.wtype = wa.wtype " +
//        "   AND x.max_time = wa.timestamp " +
//        "ORDER BY x.max_time DESC " +
//        "LIMIT :N"
//    )
//    public WorkoutActivityEntity[] getRecentActivitiesByType(int N);
//
//    // TODO: weight frequency by recency?
//    @Query(
//        "SELECT wa.* " +
//        "FROM workout_activity AS wa " +
//        "INNER JOIN ( " +
//        "   SELECT" +
//        "       wtype, " +
//        "       COUNT(*) AS wcount, " +
//        "       MAX(timestamp) AS max_time " +
//        "   FROM workout_activity " +
//        "   GROUP BY wtype " +
//        "   ORDER BY wcount DESC " +
//        "   LIMIT :N " +
//        ") AS x " +
//        "   ON x.wtype = wa.wtype " +
//        "   AND x.max_time = wa.timestamp " +
//        "ORDER BY x.wcount DESC "
//    )
//    public WorkoutActivityEntity[] getFrequentActivitiesByType(int N);
//
//    @Query("SELECT DISTINCT wtype FROM workout_activity ORDER BY wtype ASC")
//    public String[] getDistinctWtypes();
}
