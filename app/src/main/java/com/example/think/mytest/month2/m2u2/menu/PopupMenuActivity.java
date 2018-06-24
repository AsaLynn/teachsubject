package com.example.think.mytest.month2.m2u2.menu;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;
/*
1,创建PopupMenu
    构造,PopupMenu(Context context, View anchor)
2,加载res/menu目录下的menu菜单
    inflate(@MenuRes int menuRes)
3,设置菜单条目的监听
    setOnMenuItemClickListener(OnMenuItemClickListener listener
4,弹出菜单
    show()

 */
public class PopupMenuActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btnPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_popup_menu);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_popup_menu) {
            PopupMenu popupMenu = new PopupMenu(this, view);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.special_topic:
                        case R.id.elite:
                            DemonstrateUtil.showToastResult(PopupMenuActivity.this,item.getTitle().toString());
                            break;
                    }
                    return false;
                }
            });
           if (Build.VERSION.SDK_INT >= 23){
               popupMenu.setGravity(Gravity.CENTER_HORIZONTAL);
           }
            popupMenu.show();
        }
    }

    private void initView() {
        btnPopupMenu = (Button) findViewById(R.id.btn_popup_menu);
        btnPopupMenu.setOnClickListener(PopupMenuActivity.this);
    }
}
