package com.example.think.mytest.month2.m2u2.menu;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;

/*




 */
public class MenuDrawerActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView textview;
    protected TextView textview1;
    protected ImageView imageView;
    protected LinearLayout contentFrame;
    protected ListView leftDrawer;
    protected RelativeLayout rightDrawer;
    protected DrawerLayout drawerLayout;
    private ImageView actionImageView;
    private TextView actionTextView;
    private TextView actionPersonalView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_menu_drawer);

        initActionBar();
        initView();

        //左边侧滑菜单
        String[] strs = getResources().getStringArray(R.array.menu_list);
        leftDrawer.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
        leftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DemonstrateUtil.showToastResult(parent.getContext(),"menu:-->"+position);
            }
        });


        /**
         * drawerLayout添加监听，监听侧滑过程，包括打开，关闭，和侧滑offSet
         * ActionBarDrawerToggle继承了DrawerLayout.DrawerListener
         * 所以可以直接使用
         */
        drawerLayout.addDrawerListener(new ActionBarDrawerToggle(this, drawerLayout, R.string.hello_blank_fragment, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                actionTextView.setText("标题");
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //设置actionbar中的icon和主界面的imageview旋转
                actionImageView.setRotation(slideOffset*90);
                imageView.setRotation(slideOffset * 270);

            }
        });


    }

    private void initActionBar() {
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


    private void initView() {
        textview = (TextView) findViewById(R.id.textview);
        textview.setOnClickListener(MenuDrawerActivity.this);
        textview1 = (TextView) findViewById(R.id.textview1);
        textview1.setOnClickListener(MenuDrawerActivity.this);
        imageView = (ImageView) findViewById(R.id.image_view);
        contentFrame = (LinearLayout) findViewById(R.id.content_frame);
        leftDrawer = (ListView) findViewById(R.id.left_drawer);
        rightDrawer = (RelativeLayout) findViewById(R.id.right_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textview:
                drawerLayout.openDrawer(leftDrawer);
                actionTextView.setText("左滑菜单");
                break;
            case R.id.textview1:
                drawerLayout.openDrawer(rightDrawer);
                actionTextView.setText("右滑菜单");
                break;
            case R.id.personal_textview:
                drawerLayout.openDrawer(rightDrawer);
                actionTextView.setText("右滑菜单");
                break;
            case R.id.image_view:
                drawerLayout.openDrawer(leftDrawer);
                actionTextView.setText("左滑菜单");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        int groupId = 1;
        MenuItem item1 = menu.add(groupId, Menu.FIRST + 1, 1, "item0");
        item1.setIcon(R.mipmap.ic_launcher);
        menu.add(groupId, Menu.FIRST + 2, 2, "item1");
        menu.add(groupId, Menu.FIRST + 3, 3, "item2");

        /**
         * 这个监听事件可以对item的点击事件进行拦截，拦截后的item在onOptionsItemSelected()中不会得到执行
         */
        item1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;//返回true为拦截，false不拦截
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case Menu.FIRST + 1:
                DemonstrateUtil.showToastResult(this,"onOptionsItemSelected-->1");
                break;
            case Menu.FIRST + 2:
                DemonstrateUtil.showToastResult(this,"onOptionsItemSelected-->2");
                break;
            case Menu.FIRST + 3:
                DemonstrateUtil.showToastResult(this,"onOptionsItemSelected-->3");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
