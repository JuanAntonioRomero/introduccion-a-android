package com.example.everis.android.introduccionaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.everis.android.introduccionaandroid.layouts.FrameLayoutActivity;
import com.example.everis.android.introduccionaandroid.layouts.GridLayoutActivity;
import com.example.everis.android.introduccionaandroid.layouts.LinearLayoutActivity;
import com.example.everis.android.introduccionaandroid.layouts.RelativeLayoutActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mFrameLayoutButton;
    private Button mLinearLayoutButton;
    private Button mGridLayoutButton;
    private Button mRelativeLayoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayoutButton = findViewById(R.id.button_frameLayout);
        mLinearLayoutButton = findViewById(R.id.button_linearLayout);
        mGridLayoutButton = findViewById(R.id.button_gridLayout);
        mRelativeLayoutButton = findViewById(R.id.button_relativeLayout);

        mFrameLayoutButton.setOnClickListener(this);
        mLinearLayoutButton.setOnClickListener(this);
        mGridLayoutButton.setOnClickListener(this);
        mRelativeLayoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Class targetClass = null;

        if (view == mFrameLayoutButton) {
            targetClass = FrameLayoutActivity.class;
        }
        else if (view == mLinearLayoutButton) {
            targetClass = LinearLayoutActivity.class;
        }
        else if (view == mGridLayoutButton) {
            targetClass = GridLayoutActivity.class;
        }
        else if (view == mRelativeLayoutButton) {
            targetClass = RelativeLayoutActivity.class;
        }

        Intent intent = new Intent(this, targetClass);
        startActivity(intent);

    }
}
