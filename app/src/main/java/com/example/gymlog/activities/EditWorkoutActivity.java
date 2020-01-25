package com.example.gymlog.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.gymlog.R;
import com.example.gymlog.db.Repository;
import com.example.gymlog.db.entities.WorkoutActivityEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EditWorkoutActivity extends AppCompatActivity {

    public Repository db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
    }

    private void setUi() {
        setContentView(R.layout.activity_edit_workout);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        // Set up pickers
        Bundle extras = getIntent().getExtras();
        populateWorkoutTypeSpinner(extras.getString("wtype"));
        populateWeightPicker(extras.getDouble("weight"));
        populateRepsPicker(extras.getInt("reps"));
        // Set FAB onClickListener
        FloatingActionButton fab = findViewById(R.id.confirmWorkoutFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmWorkoutFABClicked();
            }
        });
    }

    // TODO
    public void populateWorkoutTypeSpinner(String wtype) {
        // Get the spinner
        Spinner sp = findViewById(R.id.wtypeSpinner);
        // Populate it with all the different types of workouts
        db = new Repository(getApplicationContext());
        List<String> wtypes = db.getDistinctWtypes();
        // Ensure "None" is there by default
        wtypes.add(0, "none");
        ArrayAdapter<String> spa = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                wtypes
        );
        sp.setAdapter(spa);
        // Set value to method argument
        sp.setSelection(spa.getPosition(wtype));
    }

    public void populateWeightPicker(double currentWeight) {
        NumberPicker np = findViewById(R.id.weightPicker);
        // Create list of valid weights
        List<Double> weights = new ArrayList<>();
        for (double w=0; w<10; w+=0.5)
            weights.add(w);
        for (double w=10; w<25; w+=2.5)
            weights.add(w);
        for (double w=25; w<=300; w+=5)
            weights.add(w);
        np.setMinValue(0);
        np.setMaxValue(weights.size()-1);
        String[] vals = new String[weights.size()];
        for (int i=0; i<weights.size(); i++) {
            vals[i] = weights.get(i).toString();
        }
        np.setDisplayedValues(vals);
        np.setValue(weights.indexOf(currentWeight));
        np.setWrapSelectorWheel(false);
//        return np;
    }

    public void populateRepsPicker(int currentReps) {
        NumberPicker np = findViewById(R.id.repsPicker);
        np.setMinValue(1);
        np.setMaxValue(100);
        np.setValue(currentReps);
        np.setWrapSelectorWheel(false);
//        return np;
    }

    // TODO
    public void confirmWorkoutFABClicked() {
        // Grab the workout information from pickers/spinners
        Spinner sp = findViewById(R.id.wtypeSpinner);
        String wtype = sp.getSelectedItem().toString();
        Log.d("FABCLICK", "wtype: " + wtype);
        NumberPicker np = findViewById(R.id.weightPicker);
        int i = np.getValue();
        double weight = Double.parseDouble(np.getDisplayedValues()[i]);
        Log.d("FABCLICK", "weight: " + weight);
        np = findViewById(R.id.repsPicker);
        int reps = np.getValue();
//        int reps = Integer.parseInt(np.getDisplayedValues()[i]);
        Log.d("FABCLICK", "reps: " + reps);
        // Put it into a WorkoutActivityEntity and submit the Entity to the database
        WorkoutActivityEntity activityEntity = new WorkoutActivityEntity(wtype, weight, reps);
        db = new Repository(getApplicationContext());
        db.insertActivity(activityEntity);
        // Go up to parent Activity
        finish();
    }
}
