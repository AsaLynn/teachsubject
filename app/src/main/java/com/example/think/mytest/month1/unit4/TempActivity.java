package com.example.think.mytest.month1.unit4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TempActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView view = new TextView(this);
        view.setText("666...");
        setContentView(view);
    }
}
