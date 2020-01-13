package com.example.gymlog.logic;

public class Workout {
    private String name;
    private MuscleGroup muscleGroup;
    private int weight;
    private int reps;

    public void Workout(String name, int weight, int reps) {
        this.name = name;
        this.weight = weight;
        this.reps = reps;
    }

    public MuscleGroup getMuscleGroup() {
        return this.muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup mg) {
        this.muscleGroup = mg;
    }
}
