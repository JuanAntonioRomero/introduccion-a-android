package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class CalculatorActivity extends Activity {

    private static final String ZERO = "0";

    protected TextView mPromptTextView;
    private TextView mInputTextView;

    private List<Integer> mNumberButtonIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mPromptTextView = findViewById(R.id.prompt);
        mInputTextView = findViewById(R.id.input);
        mInputTextView.setText(ZERO);

        initializeButtons();
        initialize();
    }

    private void initializeButtons() {
        List<View> buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.button_number0));
        buttons.add(findViewById(R.id.button_number1));
        buttons.add(findViewById(R.id.button_number2));
        buttons.add(findViewById(R.id.button_number3));
        buttons.add(findViewById(R.id.button_number4));
        buttons.add(findViewById(R.id.button_number5));
        buttons.add(findViewById(R.id.button_number6));
        buttons.add(findViewById(R.id.button_number7));
        buttons.add(findViewById(R.id.button_number8));
        buttons.add(findViewById(R.id.button_number9));
        buttons.add(findViewById(R.id.button_backspace));
        buttons.add(findViewById(R.id.button_enter));

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (canProcessInput()) {
                    int id = view.getId();

                    if (view.getId() == R.id.button_enter) {
                        updatePrompt();
                        mInputTextView.setText(ZERO);
                    } else if (view.getId() == R.id.button_backspace) {
                        String currentInput = mInputTextView.getText().toString();
                        if (!TextUtils.isEmpty(currentInput)) {
                            currentInput = currentInput.substring(0, currentInput.length() - 1);
                        }
                        if (TextUtils.isEmpty(currentInput)) {
                            currentInput = ZERO;
                        }
                        mInputTextView.setText(currentInput);
                    } else if (view.getId() == R.id.button_number0) {
                        String currentInput = mInputTextView.getText().toString();
                        if (!TextUtils.equals(currentInput, ZERO)) {
                            mInputTextView.setText(currentInput + ZERO);
                        }
                    } else {
                        String currentInput = mInputTextView.getText().toString();
                        if (TextUtils.equals(currentInput, ZERO)) {
                            currentInput = "";
                        }
                        mInputTextView.setText(currentInput + getNumberButtonCharacter(id));
                    }
                }
            }
        };

        for (View button : buttons) {
            button.setOnClickListener(buttonClickListener);
        }
    }

    private String getNumberButtonCharacter(int id) {
        if (mNumberButtonIds == null) {
            mNumberButtonIds = new ArrayList<>();
            mNumberButtonIds.add(R.id.button_number0);
            mNumberButtonIds.add(R.id.button_number1);
            mNumberButtonIds.add(R.id.button_number2);
            mNumberButtonIds.add(R.id.button_number3);
            mNumberButtonIds.add(R.id.button_number4);
            mNumberButtonIds.add(R.id.button_number5);
            mNumberButtonIds.add(R.id.button_number6);
            mNumberButtonIds.add(R.id.button_number7);
            mNumberButtonIds.add(R.id.button_number8);
            mNumberButtonIds.add(R.id.button_number9);
        }
        return "" + mNumberButtonIds.indexOf(id);
    }

    protected String getInput() {
        return mInputTextView.getText().toString();
    }

    protected abstract void initialize();
    protected abstract boolean canProcessInput();
    protected abstract void updatePrompt();
}
