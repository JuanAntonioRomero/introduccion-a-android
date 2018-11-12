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

        Button adventureGameButton = findViewById(R.id.button_game_adventure);
        adventureGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdventureGameActivity.class);
                startActivity(intent);
            }
        });

        Button memoryGameButton = findViewById(R.id.button_game_memory);
        memoryGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MemoryGameActivity.class);
                startActivity(intent);
            }
        });

        Button snapGameButton = findViewById(R.id.button_game_snap);
        snapGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SnapGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
