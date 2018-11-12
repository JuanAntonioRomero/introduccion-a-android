package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnapGameActivity extends Activity {

    private static final int NUMBER_DELAY = 500;

    private TextView mPromptTextView;
    private TextView mNumberTextView;
    private LinearLayout mButtonsLayout;
    private List<Button> mButtons;

    private Random mRandom = new Random();
    private String mTargetNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);

        mPromptTextView = findViewById(R.id.prompt);
        mPromptTextView.setText(R.string.snap_prompt);

        mNumberTextView = findViewById(R.id.number);
        mButtonsLayout = findViewById(R.id.layout_buttons);

        initializeButtons();

        findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewGame();
            }
        });
    }

    private void initializeButtons() {
        mButtons = new ArrayList<>();
        mButtons.add((Button) findViewById(R.id.button_option1));
        mButtons.add((Button) findViewById(R.id.button_option2));
        mButtons.add((Button) findViewById(R.id.button_option3));
        mButtons.add((Button) findViewById(R.id.button_option4));
        mButtons.add((Button) findViewById(R.id.button_option5));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mButtonsLayout.setVisibility(View.INVISIBLE);
                mNumberTextView.setVisibility(View.VISIBLE);
                if (TextUtils.equals(((Button) view).getText(), mTargetNumber)) {
                    mPromptTextView.setText(R.string.snap_win);
                } else {
                    mPromptTextView.setText(R.string.snap_lose);
                }
            }
        };

        for (Button button : mButtons) {
            button.setOnClickListener(listener);
        }
    }

    private void startNewGame() {
        mTargetNumber = generateFourDigitNumber();
        mNumberTextView.setText(mTargetNumber);

        int correctAnswerIndex = Math.abs(mRandom.nextInt() % mButtons.size());
        for (int i = 0; i < mButtons.size(); i++) {
            mButtons.get(i).setText(i == correctAnswerIndex ? mTargetNumber : generateFourDigitNumber());
        }

        mNumberTextView.setVisibility(View.VISIBLE);
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mNumberTextView.setVisibility(View.INVISIBLE);
                mButtonsLayout.setVisibility(View.VISIBLE);
            }
        }, NUMBER_DELAY);
    }

    private String generateFourDigitNumber() {
        return String.format("%04d", Math.abs(mRandom.nextInt() % 9999));
    }
}
