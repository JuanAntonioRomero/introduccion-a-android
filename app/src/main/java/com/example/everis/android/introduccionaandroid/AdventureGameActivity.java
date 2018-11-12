package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdventureGameActivity extends Activity {

    private static final int[][] mRoomDescriptions = {
        {R.string.adventure_location_0_0,
            R.string.adventure_location_0_1,
            R.string.adventure_location_0_2},
        {R.string.adventure_location_1_0,
            R.string.adventure_location_1_1,
            R.string.adventure_location_1_2},
        {R.string.adventure_location_2_0,
            R.string.adventure_location_2_1,
            R.string.adventure_location_2_2}};

    private int mLocationX;
    private int mLocationY;

    private TextView mPrompt;
    private Button mNorthButton;
    private Button mSouthButton;
    private Button mEastButton;
    private Button mWestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure);

        mPrompt = findViewById(R.id.prompt);

        initializeButtons();

        mLocationX = 1;
        mLocationY = 1;
        updatePrompt();
    }

    private void initializeButtons() {
        mNorthButton = findViewById(R.id.button_north);
        mNorthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationY--;
                updateState();
            }
        });

        mSouthButton = findViewById(R.id.button_south);
        mSouthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationY++;
                updateState();
            }
        });

        mEastButton = findViewById(R.id.button_east);
        mEastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationX++;
                updateState();
            }
        });

        mWestButton = findViewById(R.id.button_west);
        mWestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLocationX--;
                updateState();
            }
        });
    }

    private void updateState() {
        updateButtons();
        updatePrompt();
    }

    private void updateButtons() {
        mNorthButton.setEnabled(mLocationY > 0);
        mSouthButton.setEnabled(mLocationY < mRoomDescriptions[mLocationX].length - 1);
        mWestButton.setEnabled(mLocationX > 0);
        mEastButton.setEnabled(mLocationX < mRoomDescriptions.length - 1);
    }

    private void updatePrompt() {
        mPrompt.setText(mRoomDescriptions[mLocationX][mLocationY]);
    }
}
