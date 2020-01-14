package com.example.gymlog.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "test_table")
public class Test {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "some_text")
    public String some_text;

    public Test(String some_text) {
        this.some_text = some_text;
    }
}
