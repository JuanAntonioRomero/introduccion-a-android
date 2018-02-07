package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    /*
    Este método se llama una sola vez por instancia, cada vez que se crea la pantalla.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
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
