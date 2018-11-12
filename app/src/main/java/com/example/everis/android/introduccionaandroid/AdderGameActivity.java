package com.example.everis.android.introduccionaandroid;

public class AdderGameActivity extends CalculatorActivity {

    private static final int MAX_COUNT = 100;

    private int mTotal;

    protected void initialize() {
        mPromptTextView.setText(R.string.adder_prompt);
        mTotal = 0;
    }

    protected boolean canProcessInput() {
        return true;
    }

    protected void updatePrompt() {
        try {
            mTotal += Integer.parseInt(getInput());
            String text = String.format(getString(R.string.adder_result), "" + mTotal);
            if (mTotal > MAX_COUNT) {
                text += " " + getString(R.string.adder_excess);
            }
            mPromptTextView.setText(text);
        } catch (Exception ignored) {
        }
    }
}
