package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private TextView mLeftTextView;
    private TextView mCenterTextView;
    private TextView mRightTextView;
    private ImageView mImageView;
    private Button mButton;
    private Button mNextScreenButton;

    /*
    Este método se llama una sola vez por instancia, cada vez que se crea la pantalla.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");

        mLeftTextView =findViewById(R.id.text_left);
        mCenterTextView =findViewById(R.id.text_center);
        mRightTextView =findViewById(R.id.text_right);
        mImageView =findViewById(R.id.imageView);
        mButton = findViewById(R.id.button);
        mNextScreenButton= findViewById(R.id.button_nextScreen);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCenterTextView.setText(R.string.text_center_alt);
                mImageView.setImageResource(R.drawable.if_food_c240_2427880);
            }
        });

        mNextScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, AnotherActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    Este método se llama cada vez que la pantalla se va a mostrar al usuario.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart");
    }

    /*
    Este método se llama cada vez que la pantalla va a empezar a recibir interacción por parte del usuario.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume");
    }

    /*
    Este método se llama cada vez que la pantalla deja de estar visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause");
    }

    /*
    Este método se llama cada vez que la instancia vuelve a iniciarse tras haberse llamado a onPause.
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart");
    }

    /*
    Este método se llama una sola vez por instancia, cuando el sistema destruye la Activity. Puede no llamarse.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }
}
