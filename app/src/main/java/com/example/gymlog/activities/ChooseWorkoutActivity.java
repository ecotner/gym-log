package com.example.gymlog.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.gymlog.R;
import com.example.gymlog.db.Repository;
import com.example.gymlog.db.entities.WorkoutActivityEntity;

import java.util.List;

public class ChooseWorkoutActivity extends AppCompatActivity {
    private Repository db;
    public List<WorkoutActivityEntity> recentActivities;
    public List<WorkoutActivityEntity> favoriteActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
    }

    private void setUi() {
        setContentView(R.layout.activity_choose_workout);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        populateRecentCards(5);
    }

    private void populateRecentCards(int N) {
        LinearLayout parent = (LinearLayout) findViewById(R.id.recents_layout);
        db = new Repository(getApplicationContext());
        List<WorkoutActivityEntity> activities = db.getRecentActivitiesByType(5);
        recentActivities = activities;
        CardView card;
        for (int i=0; i<activities.size(); i++) {
            WorkoutActivityEntity a = activities.get(i);
            card = makeCard(a);
            parent.addView(card);
        }
    }

    private CardView makeCard(WorkoutActivityEntity a) {
        final String wtype = a.wtype;
        int weight = a.weight;
        int reps = a.reps;
        String msg = wtype + "\nWeight: " + weight + "\nReps: " + reps;
        // Make card view
        TextView text = new TextView(this);
        text.setText(msg);
        CardView card = new CardView(this);
        card.addView(text);
        card.setTag(a); // attach the activity to the card

        // Format card
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                getResources().getDimensionPixelSize(R.dimen.default_card_width),
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        int p = getResources().getDimensionPixelSize(R.dimen.default_card_padding);
        params.setMargins(p, p, p, p);
        card.setLayoutParams(params);

        // Define what to do when clicked
        final WorkoutActivityEntity aa = a;
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CLICK", "I got clicked: " + wtype);
                // Start EditWorkoutActivity
                displayEditWorkoutActivity(aa);
            }
        });

        return card;
    }

    public void displayEditWorkoutActivity(WorkoutActivityEntity a) {
        Intent intent = new Intent(this, EditWorkoutActivity.class);
        intent.putExtra("wtype", a.wtype);
        intent.putExtra("weight", a.weight);
        intent.putExtra("reps", a.reps);
        startActivity(intent);
    }

}
