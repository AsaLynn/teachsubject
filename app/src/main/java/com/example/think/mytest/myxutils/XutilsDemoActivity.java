package com.example.think.mytest.myxutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.think.mytest.R;

import org.xutils.x;

public class XutilsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xutils_demo);

        x.view().inject(this);
        //x.http().get();
    }
}
