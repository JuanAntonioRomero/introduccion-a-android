package com.example.everis.android.introduccionaandroid;

import java.util.Random;

public class GuessGameActivity extends CalculatorActivity {

    private int mNumberToGuess;
    private int mGuessesCount;
    private boolean mSolved;

    @Override
    protected void initialize() {
        mPromptTextView.setText(R.string.guessNumber_prompt);

        mNumberToGuess = Math.abs(new Random().nextInt() % 100);
        mGuessesCount = 0;
        mSolved = false;
    }

    @Override
    protected boolean canProcessInput() {
        return !mSolved;
    }

    @Override
    protected void updatePrompt() {
        try {
            mGuessesCount++;
            int number = Integer.parseInt(getInput());
            if (mNumberToGuess < number) {
                mPromptTextView.setText(R.string.guessNumber_lower);
            } else if (mNumberToGuess > number) {
                mPromptTextView.setText(R.string.guessNumber_greater);
            } else {
                mPromptTextView.setText(String.format(getString(R.string.guessNumber_correct), "" + mGuessesCount));
                mSolved = true;
            }
        } catch (Exception ignored) {
        }
    }
}
