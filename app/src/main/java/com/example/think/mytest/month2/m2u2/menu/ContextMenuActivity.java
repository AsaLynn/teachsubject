package com.example.think.mytest.month2.m2u2.menu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;

/*
1,注册上下文菜单
    registerForContextMenu(View view)
2,生成上下文菜单
    重写onCreateContextMenu方法,
    调用menu的add方法.
3,响应上下文菜单项
    boolean onContextItemSelected(MenuItem item)
    根据item的id做不同逻辑处理
4,长按view控件后弹出ContextMenu菜单选项
5,每次长按都会调用onCreateContextMenu方法.

 */
public class ContextMenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 显示列表
        simpleShowList();
        // 为所有列表项注册上下文菜单
        this.registerForContextMenu(getListView());
    }

    private void simpleShowList() {
        String[] files = new String[]{
                "文件1",
                "文件2",
                "文件3",
                "文件4"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                files);
        this.setListAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        DemonstrateUtil.showLogResult("onCreateContextMenu");
        //生成上下文菜单

        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.ic_launcher_round);
        // add context menu item
        menu.add(0, 1, Menu.NONE, "发送");
        menu.add(0, 2, Menu.NONE, "标记为重要");
        menu.add(0, 3, Menu.NONE, "重命名");
        menu.add(0, 4, Menu.NONE, "删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // 得到当前被选中的item信息
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        DemonstrateUtil.showLogResult("context item seleted ID=" + menuInfo.id);

        switch (item.getItemId()) {
            case 1:
                DemonstrateUtil.showToastResult(this,item.getTitle().toString());
                break;
            case 2:
                DemonstrateUtil.showToastResult(this,item.getTitle().toString());
                break;
            case 3:
                DemonstrateUtil.showToastResult(this,item.getTitle().toString());
                break;
            case 4:
                DemonstrateUtil.showToastResult(this,item.getTitle().toString());
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}
