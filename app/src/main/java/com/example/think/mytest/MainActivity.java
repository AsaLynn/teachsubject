package com.example.think.mytest;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.think.mytest.base.BaseActivity;
import com.example.think.mytest.monthsubjects.Month1Activity;
import com.example.think.mytest.monthsubjects.Month2Activity;
import com.example.think.mytest.monthsubjects.Month4Activity;

/**
 * 大纲练习题
 */
public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public void registerForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_1) {
            startActivity(new Intent(this, Month1Activity.class));
        } else if (view.getId() == R.id.btn_2) {
            startActivity(new Intent(this, Month2Activity.class));
        } else if (view.getId() == R.id.btn_3) {
        } else if (view.getId() == R.id.btn_4) {
            startActivity(new Intent(this, Month4Activity.class));
        }
    }

    private void initView() {
        LinearLayout rooLl = (LinearLayout) findViewById(R.id.root_ll);
        String[] months = getResources().getStringArray(R.array.test_subject_months);
        for (int i = 0; i < months.length; i++) {
            Button button = (Button) rooLl.getChildAt(i);
            button.setOnClickListener(this);
            button.setText(months[i]);
        }
    }
}
