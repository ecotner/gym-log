package com.example.gymlog.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.gymlog.R;

public class ChooseWorkoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUi();
        LinearLayout parent = (LinearLayout) findViewById(R.id.recents_layout);
        CardView card = null;
        for (int i=0; i<20; i++) {
            card = makeCard("haha derp this is card #" + i);
//            ((TextView) card.getChildAt(0)).setText("asdf");
            parent.addView(card);
        }
    }

    private void setUi() {
        setContentView(R.layout.activity_choose_workout);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private CardView makeCard(String str) {
        // Make card view
        TextView text = new TextView(this);
        text.setText(str);
        CardView card = new CardView(this);
        card.addView(text);

        // Format card
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                getResources().getDimensionPixelSize(R.dimen.default_card_width),
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        int p = getResources().getDimensionPixelSize(R.dimen.default_card_padding);
        params.setMargins(p, p, p, p);
        card.setLayoutParams(params);

        return card;
    }
}
