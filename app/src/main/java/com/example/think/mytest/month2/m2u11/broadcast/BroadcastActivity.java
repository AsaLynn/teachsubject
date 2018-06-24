package com.example.think.mytest.month2.m2u11.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.think.mytest.R;

public class BroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_broadcast);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            Intent intent = new Intent("month2.m2u11.broadcast.MyBroadcastReceiver");
            sendBroadcast(intent);
        }
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(BroadcastActivity.this);
    }
}
