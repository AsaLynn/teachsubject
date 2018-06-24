package com.example.think.mytest.month2.m2u6.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.think.mytest.R;
import com.example.think.mytest.base.BaseActivity;

public class SPActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        SharedPreferences sharedPreferences = getSharedPreferences("", MODE_PRIVATE);


    }
}
