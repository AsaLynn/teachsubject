package com.example.think.mytest.month2.m2u2.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;

/*



 */
public class MenuSubMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comcon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int groupId = 1;
        SubMenu subMenu1 = menu.addSubMenu(groupId, Menu.FIRST + 10, 1, "subMenu1");
        subMenu1.add(groupId, Menu.FIRST + 11, 1, "sub1-->1");
        subMenu1.add(groupId, Menu.FIRST + 12, 1, "sub1-->2");
        SubMenu subMenu2 = menu.addSubMenu(groupId, Menu.FIRST + 20, 2, "subMenu2");
        subMenu2.add(2, Menu.FIRST + 21, 1, "sub2-->3");
        subMenu2.add(2, Menu.FIRST + 22, 1, "sub2-->4");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case Menu.FIRST+11:
            case Menu.FIRST+12:
            case Menu.FIRST+21:
            case Menu.FIRST+22:
                DemonstrateUtil.showToastResult(this,item.getTitle().toString());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
