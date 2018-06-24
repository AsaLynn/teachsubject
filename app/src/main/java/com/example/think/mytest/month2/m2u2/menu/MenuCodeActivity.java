package com.example.think.mytest.month2.m2u2.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.example.think.mytest.R;

public class MenuCodeActivity extends AppCompatActivity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month2_unit2);

    }

    //通过重写onCreateOptionMenu方法,在代码中来创建Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        int groupId = 1;
        MenuItem item1 = menu.add(groupId, Menu.FIRST + 1, 1, "第1组item1");
        item1.setIcon(R.mipmap.ic_launcher);
        menu.add(groupId, Menu.FIRST + 2, 2, "第1组item2");
        menu.add(groupId, Menu.FIRST + 3, 3, "第1组item3");
        menu.add("第1组item4");
        //true隐藏组,false显示组
        menu.setGroupVisible(1,false);


        MenuItem item4 = menu.add(groupId, Menu.FIRST + 4, 4, "将第二组item可用");
        item4.setIcon(R.mipmap.ic_launcher);
        menu.add(groupId, Menu.FIRST + 5, 5, "将第二组item可单选");
        menu.add(groupId, Menu.FIRST + 6, 6, "将第二组item可多选");

        groupId = 2;
        MenuItem item7 = menu.add(groupId, Menu.FIRST + 7, 7, "menu2_1");
        item7.setIcon(R.mipmap.ic_launcher);
        MenuItem item8 = menu.add(groupId, Menu.FIRST + 8, 8, "menu2_2");
        item8.setIcon(R.mipmap.ic_launcher);

        SubMenu subMenu = menu.addSubMenu(groupId, Menu.FIRST + 9, 9, "sub menu");
        subMenu.add(groupId, Menu.FIRST + 10, 1, "sub1");
        subMenu.add(groupId, Menu.FIRST + 11, 2, "sub2");

        /**
         * 这个监听事件可以对item的点击事件进行拦截，拦截后的item在onOptionsItemSelected()中不会得到执行
         */
        item1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;//返回true为拦截，false不拦截
            }
        });

        //true表示展示菜单，return false表示隐藏菜单
        return true;
    }

    //添加menuitem的点击事件，在activity的onOptionsItemSeleted（MenuItem menuitem）中进行设置
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case Menu.FIRST + 1:
                menu.setGroupVisible(2, false);
                break;
            case Menu.FIRST + 2:
                menu.setGroupVisible(2, true);
                break;
            case Menu.FIRST + 3:
                menu.setGroupEnabled(2, false);
                break;
            case Menu.FIRST + 4:
                menu.setGroupEnabled(2, true);
                break;
            case Menu.FIRST + 5:
                menu.setGroupCheckable(2, true, true);
                break;
            case Menu.FIRST + 6:
                menu.setGroupCheckable(2, true, false);
                break;
            case Menu.FIRST + 7:
                Toast.makeText(this, "menu2_1", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 8:
                Toast.makeText(this, "menu2_2", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 10:
                Toast.makeText(this, "sub1", Toast.LENGTH_SHORT).show();
                break;
            case Menu.FIRST + 11:
                Toast.makeText(this, "sub2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
