package com.example.gymlog.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.gymlog.R;
import com.example.gymlog.db.Repository;
import com.example.gymlog.db.entities.WorkoutActivityEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EditWorkoutActivity extends AppCompatActivity {

    public Repository db;
    static List<Double> weightList = new ArrayList<>();
    static {
        // Create list of valid weights
        for (double w=0; w<10; w+=0.5)
            weightList.add(w);
        for (double w=10; w<30; w+=1)
            weightList.add(w);
        for (double w=30; w<=300; w+=5)
            weightList.add(w);
    }

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

    public void populateWorkoutTypeSpinner(String wtype) {
        // Get the spinner
        Spinner sp = findViewById(R.id.wtypeSpinner);
        // Populate it with all the different types of workouts
        db = new Repository(getApplicationContext());
        List<String> wtypes = db.getDistinctWtypes();
        // Ensure "None" is there by default
        wtypes.add(0, "New");
        ArrayAdapter<String> spa = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                wtypes
        );
        sp.setAdapter(spa);
        // Set value to method argument
        sp.setSelection(spa.getPosition(wtype));
        // If
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String val = parent.getAdapter().getItem(position).toString();
                EditText txt = findViewById(R.id.wtypeInputEditText);
                if (val == "New") {
                    // Make text input visible
                    txt.setVisibility(View.VISIBLE);
                } else {
                    // Hide input field
                    txt.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void populateWeightPicker(double currentWeight) {
        NumberPicker np = findViewById(R.id.weightPicker);
        np.setMinValue(0);
        np.setMaxValue(weightList.size()-1);
        String[] vals = new String[weightList.size()];
        for (int i=0; i<weightList.size(); i++) {
            vals[i] = weightList.get(i).toString();
        }
        np.setDisplayedValues(vals);
        np.setValue(weightList.indexOf(currentWeight));
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

    public void confirmWorkoutFABClicked() {
        // Grab the workout information from pickers/spinners
        Spinner sp = findViewById(R.id.wtypeSpinner);
        String wtype = sp.getSelectedItem().toString();
        if (wtype.equals("New")) {
            EditText et = findViewById(R.id.wtypeInputEditText);
            wtype = et.getText().toString();
            if (wtype.equals("")) {
                Log.d("FAB", "gotta have something in the box");
                return;
            }
        }
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
        // Done here; go up to parent Activity
        finish();
    }

    /* TODO: make some kind of listener that determines if a "New" workout type has been selected
       and creates an input field to allow them to put in the name. */
    public void wtypeListener() {

    }
}
