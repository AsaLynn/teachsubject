package com.example.think.mytest.month2.m2u11.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.think.mytest.R;

import org.greenrobot.eventbus.EventBus;

public class EventBus2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        Button btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);
        btn_FirstEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(
                        new FirstEvent("FirstEvent btn clicked"));
            }
        });
    }
}
