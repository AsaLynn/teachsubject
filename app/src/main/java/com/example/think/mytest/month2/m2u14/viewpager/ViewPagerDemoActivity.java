package com.example.think.mytest.month2.m2u14.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.think.mytest.R;
import com.example.think.mytest.base.BaseActivity;

public class ViewPagerDemoActivity extends BaseActivity implements View.OnClickListener {

    protected Button btn1;
    protected Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_view_pager_demo);
        initView();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn1) {
            startActivity(new Intent(this, ViewPagerActivity.class));
        } else if (view.getId() == R.id.btn2) {
            startActivity(new Intent(this, ViewPager2Activity.class));
        }
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(ViewPagerDemoActivity.this);
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(ViewPagerDemoActivity.this);
    }
}
