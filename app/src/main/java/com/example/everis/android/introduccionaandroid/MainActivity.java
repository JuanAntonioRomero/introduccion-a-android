package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button adderGameButton = findViewById(R.id.button_game_adder);
        adderGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdderGameActivity.class);
                startActivity(intent);
            }
        });

        Button guessGameButton = findViewById(R.id.button_game_guessNumber);
        guessGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GuessGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
