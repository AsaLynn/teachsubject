package com.example.think.mytest.monthsubjects;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.think.mytest.R;
import com.example.think.mytest.base.BaseActivity;

/**
 * Created by think on 2017/10/31.
 */

public abstract class MonthBaseActivity extends BaseActivity {

    private void initButton(int id) {
        String[] units = getResources().getStringArray(id);
        for (int i = 0; i < units.length; i++) {
            Button child = (Button) btnLl.getChildAt(i);
            child.setText(units[i]);
            child.setOnClickListener(this);
        }
    }

    protected LinearLayout btnLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month2);
        initView();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_unit1:
                showUnit1();
                break;
            case R.id.btn_unit2:
                showUnit2();
                break;
            case R.id.btn_unit3:
                showUnit3();
                break;
            case R.id.btn_unit4:
                showUnit4();
                break;
            case R.id.btn_unit5:
                showUnit5();
                break;
            case R.id.btn_unit11:
                showUnit11();
                break;
            case R.id.btn_unit12:
                showUnit12();
                break;
            case R.id.btn_unit14:
                showUnit14();
                break;
        }
    }

    protected void showUnit14() {

    }

    protected void showUnit11() {

    }

    protected void showUnit12() {

    }

    protected void showUnit5() {

    }

    protected void showUnit4() {

    }

    protected void showUnit3() {

    }

    protected void showUnit2() {

    }

    protected void showUnit1() {

    }

    protected void initView() {
        btnLl = (LinearLayout) findViewById(R.id.btn_ll);

        initButton(getUnitsId());
    }

    protected abstract int getUnitsId();

}
