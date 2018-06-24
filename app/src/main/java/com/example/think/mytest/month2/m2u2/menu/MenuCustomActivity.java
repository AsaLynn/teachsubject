package com.example.think.mytest.month2.m2u2.menu;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;

import java.lang.reflect.Field;

/*
ActionBar自定义的实现:



 */
public class MenuCustomActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView actionImageView;
    private TextView actionTextView;
    private TextView actionPersonalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_custom);

        setHasPermanentMenuKey(false);

        //获取ActionBar
        //这里注意使用getSupportActionBar（）的时候有些时候获取到的actionbar为null，这个时候检查是否在menifest或者代码中设置了No_title或者全屏，设置成任何一个都会导致null
        ActionBar actionBar = getSupportActionBar();
        //设定自定义布局,定义配置,自定义配置生效.
        actionBar.setCustomView(R.layout.action_bar_layout);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);

        //实例化自定义actionbar的view
        actionImageView = (ImageView) actionBar.getCustomView().findViewById(R.id.image_view);
        actionTextView = (TextView) actionBar.getCustomView().findViewById(R.id.textview);
        actionPersonalView = (TextView) actionBar.getCustomView().findViewById(R.id.personal_textview);
        actionPersonalView.setOnClickListener(this);
        actionImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_view:
                DemonstrateUtil.showToastResult(this,"image_view");
                break;
            case R.id.personal_textview:
                DemonstrateUtil.showToastResult(this,"personal_textview");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //返回true,才会显示Menu
        return true;
    }

    /**
     * 通过反射，设置实体menu键可用与否
     * 该方法在onCreate（）中调用
     * @param enable  false:实体键不可用，会在actionbar上显示小点
     *                true：可用，点击menu实体键才会显示menuitem
     */
    public void setHasPermanentMenuKey(boolean enable){
        try {
            ViewConfiguration mconfig = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(mconfig, enable);
            }
        } catch (Exception ex) {

        }
    }
}
