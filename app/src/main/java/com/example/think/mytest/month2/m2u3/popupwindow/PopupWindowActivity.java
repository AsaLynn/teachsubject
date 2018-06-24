package com.example.think.mytest.month2.m2u3.popupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;

/*
1,初始化
2,配置必须属性
3,弹出操作

 */
public class PopupWindowActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btn;
    protected LinearLayout rootLl;
    protected TextView menu;
    protected Button btn1;
    private PopupWindow mPopWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_popup_window);
        initView();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            showPopupWindow();
        } else if (view.getId() == R.id.pop_computer) {
            DemonstrateUtil.showToastResult(this, "pop_computer");
            mPopWindow.dismiss();
        } else if (view.getId() == R.id.pop_financial) {
            DemonstrateUtil.showToastResult(this, "pop_financial");
            mPopWindow.dismiss();
        } else if (view.getId() == R.id.pop_manage) {
            DemonstrateUtil.showToastResult(this, "pop_manage");
            mPopWindow.dismiss();
        } else if (view.getId() == R.id.menu) {
            showPopupWindow2();
        } else if (view.getId() == R.id.btn1) {
            showPopupWindow3();
        }
    }

    private void showPopupWindow3() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.popuplayout, null);
        mPopWindow = new BasePopupWindow(this);
        mPopWindow.setContentView(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv1 = (TextView) contentView.findViewById(R.id.pop_computer);
        TextView tv2 = (TextView) contentView.findViewById(R.id.pop_financial);
        TextView tv3 = (TextView) contentView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        mPopWindow.showAsDropDown(btn1);
    }

    private void showPopupWindow2() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.popuplayout, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置动画所对应的style
        mPopWindow.setAnimationStyle(R.style.contextMenuAnim);

        TextView tv1 = (TextView) contentView.findViewById(R.id.pop_computer);
        TextView tv2 = (TextView) contentView.findViewById(R.id.pop_financial);
        TextView tv3 = (TextView) contentView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        mPopWindow.showAsDropDown(menu);
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(this).inflate(R.layout.popuplayout, null);
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);
        mPopWindow.setContentView(contentView);
        //设置各个控件的点击响应
        TextView tv1 = (TextView) contentView.findViewById(R.id.pop_computer);
        TextView tv2 = (TextView) contentView.findViewById(R.id.pop_financial);
        TextView tv3 = (TextView) contentView.findViewById(R.id.pop_manage);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        //显示PopupWindow
        mPopWindow.showAtLocation(rootLl, Gravity.BOTTOM, 0, 0);
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(PopupWindowActivity.this);
        rootLl = (LinearLayout) findViewById(R.id.root_ll);
        menu = (TextView) findViewById(R.id.menu);
        menu.setOnClickListener(PopupWindowActivity.this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(PopupWindowActivity.this);


    }
}
