package com.example.gymlog.logic;

public class MuscleGroup {
    private String name;
    private static String[] GROUPS = {"Back", "Shoulders", "Chest", "Arms", "Legs", "Core"};
    public static int BACK = 0;
    public static int SHOULDERS = 1;
    public static int CHEST = 2;

    public void MuscleGroup(String name) {
        this.name = name;
    }
}
