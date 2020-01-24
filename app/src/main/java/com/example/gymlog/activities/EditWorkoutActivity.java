package com.example.gymlog.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gymlog.R;

import org.w3c.dom.Text;

public class EditWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
        Bundle extras = getIntent().getExtras();
        TextView text = (TextView) findViewById(R.id.stupidTextBox);
        text.setText(extras.getString("wtype"));
    }

    private void setUi() {
        setContentView(R.layout.activity_edit_workout);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
