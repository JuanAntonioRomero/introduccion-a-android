package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryGameActivity extends Activity {

    private static final int MAX_ERRORS = 5;

    private TextView mPromptTextView;
    private Button[][] mButtons = new Button[4][4];
    private int[][] mAnswers = new int[4][4];
    private Button mSelectedButton = null;
    private int mErrorCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        mPromptTextView = findViewById(R.id.prompt);
        mPromptTextView.setText(R.string.memory_prompt);

        initializeAnswers();
        initializeButtons();
    }

    private void initializeAnswers() {
        List<Integer> answers = new ArrayList<>();
        answers.add(R.string.memory_option1);
        answers.add(R.string.memory_option1);
        answers.add(R.string.memory_option2);
        answers.add(R.string.memory_option2);
        answers.add(R.string.memory_option3);
        answers.add(R.string.memory_option3);
        answers.add(R.string.memory_option4);
        answers.add(R.string.memory_option4);
        answers.add(R.string.memory_option5);
        answers.add(R.string.memory_option5);
        answers.add(R.string.memory_option6);
        answers.add(R.string.memory_option6);
        answers.add(R.string.memory_option7);
        answers.add(R.string.memory_option7);
        answers.add(R.string.memory_option8);
        answers.add(R.string.memory_option8);

        Random random = new Random();
        int answersIndex;
        int counter = 0;
        while (answers.size() > 0) {
            answersIndex = Math.abs(random.nextInt() % answers.size());
            mAnswers[counter / 4][counter % 4] = answers.get(answersIndex);
            answers.remove(answersIndex);
            counter++;
        }
    }

    private void initializeButtons() {
        mButtons[0][0] = findViewById(R.id.button_0_0);
        mButtons[0][1] = findViewById(R.id.button_0_1);
        mButtons[0][2] = findViewById(R.id.button_0_2);
        mButtons[0][3] = findViewById(R.id.button_0_3);
        mButtons[1][0] = findViewById(R.id.button_1_0);
        mButtons[1][1] = findViewById(R.id.button_1_1);
        mButtons[1][2] = findViewById(R.id.button_1_2);
        mButtons[1][3] = findViewById(R.id.button_1_3);
        mButtons[2][0] = findViewById(R.id.button_2_0);
        mButtons[2][1] = findViewById(R.id.button_2_1);
        mButtons[2][2] = findViewById(R.id.button_2_2);
        mButtons[2][3] = findViewById(R.id.button_2_3);
        mButtons[3][0] = findViewById(R.id.button_3_0);
        mButtons[3][1] = findViewById(R.id.button_3_1);
        mButtons[3][2] = findViewById(R.id.button_3_2);
        mButtons[3][3] = findViewById(R.id.button_3_3);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(((Button) view).getText())) {

                    int x = -1;
                    int y = -1;

                    for (int i = 0; i < mButtons.length; i++) {
                        for (int j = 0; j < mButtons[0].length; j++) {
                            if (mButtons[i][j] == view) {
                                x = i;
                                y = j;
                                break;
                            }
                        }
                        if (x != -1) {
                            break;
                        }
                    }

                    final int finalX = x;
                    final int finalY = y;

                    mButtons[x][y].setText(mAnswers[x][y]);
                    if (mSelectedButton == null) {
                        mSelectedButton = mButtons[x][y];
                    } else {
                        if (TextUtils.equals(mSelectedButton.getText().toString(), getString(mAnswers[x][y]))) {
                            mSelectedButton = null;
                            if (hasWon()) {
                                mPromptTextView.setText(R.string.memory_win);
                            }
                        } else {
                            setAllButtonsEnabled(false);
                            mErrorCount++;
                            if (mErrorCount > MAX_ERRORS) {
                                mPromptTextView.setText(R.string.memory_lose);
                            } else {
                                Utils.runOnUIThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mSelectedButton.setText("");
                                        mButtons[finalX][finalY].setText("");
                                        setAllButtonsEnabled(true);
                                        mSelectedButton = null;
                                    }
                                }, 1000);
                            }
                        }
                    }
                }
            }
        };

        for (int i = 0; i < mButtons.length; i++) {
            for (int j = 0; j < mButtons[0].length; j++) {
                mButtons[i][j].setOnClickListener(buttonClickListener);
            }
        }
    }

    private void setAllButtonsEnabled(boolean enabled) {
        for (int i = 0; i < mButtons.length; i++) {
            for (int j = 0; j < mButtons[0].length; j++) {
                mButtons[i][j].setEnabled(enabled);
            }
        }
    }

    private boolean hasWon() {
        boolean res = true;

        for (int i = 0; i < mButtons.length; i++) {
            for (int j = 0; j < mButtons[0].length; j++) {
                if (TextUtils.isEmpty(mButtons[i][j].getText())) {
                    res = false;
                    break;
                }
            }

            if (!res) {
                break;
            }
        }

        return res;
    }
}
