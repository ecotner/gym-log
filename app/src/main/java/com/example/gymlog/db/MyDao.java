package com.example.gymlog.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void insertTest(Test test);

    @Query("SELECT * FROM test_table")
    public Test[] getAllTests();
}
