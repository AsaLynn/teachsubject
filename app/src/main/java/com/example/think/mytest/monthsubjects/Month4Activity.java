package com.example.think.mytest.monthsubjects;

import android.content.Intent;

import com.example.think.mytest.R;
import com.example.think.mytest.customview.CustomViewActivity;
import com.example.think.mytest.myaidl.AidlDemoActivity;

/*
第四个月课程大纲内容.
 */
public class Month4Activity extends MonthBaseActivity {

    @Override
    protected int getUnitsId() {
        return R.array.test_m4_units;
    }

    @Override
    protected void showUnit3() {
        startActivity(new Intent(this,CustomViewActivity.class));
    }

    @Override
    protected void showUnit4() {
        startActivity(new Intent(this,AidlDemoActivity.class));
    }
}
