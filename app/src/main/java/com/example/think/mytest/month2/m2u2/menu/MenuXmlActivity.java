package com.example.think.mytest.month2.m2u2.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.R;

/*
1,在res目录下新建menu目录，在这下面创建menu资源文件如mani_menu.xml
2,onCreateOptionsMenu方法中进行初始化xml操作
    getMenuInflater().inflate(R.menu.xml_menu, menu);
3,onOptionsItemSelected方法中获取id处理条目的点击事件.

 */
public class MenuXmlActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_xml);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.xml_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.group1_item1:
                DemonstrateUtil.showToastResult(this,"group1_item1");
                break;
//            case R.id.group1_item2:
//                DemonstrateUtil.showToastResult(this,"group1_item2");
//                break;
//            case R.id.sub_item1:
//                DemonstrateUtil.showToastResult(this,"sub_item1");
//                break;
//            case R.id.sub_item2:
//                DemonstrateUtil.showToastResult(this,"sub_item2");
//                break;
//            case R.id.sub_item3:
//                DemonstrateUtil.showToastResult(this,"sub_item3");
//                break;
//            case R.id.group1_item7:
//                DemonstrateUtil.showToastResult(this,"group1_item7");
//                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *  android 4.0以后使用AppCompatActivity必须在该方法中调用setIconEnable（），
     *  隐藏的menuitem的icon才会显示
     *  android 4.0以后其他的activity可以再onPrepreOptionMenu()中调用
     *  android 4.0以前可以正常显示overflow中的menuitem的icon
     * @param view
     * @param menu
     * @return
     */
    /*@SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        setIconEnable(menu, true);//让在overflow中的menuitem的icon显示
        return super.onPrepareOptionsPanel(view, menu);
    }*/

    /**
     * 利用反射机制调用MenuBuilder中的setOptionIconsVisable（），
     * 如果是集成自AppCompatActivity则不行,需要在onPreareOptionPanel（）中调用该方法
     * @param menu   该menu实质为MenuBuilder，该类实现了Menu接口
     * @param enable enable为true时，菜单添加图标有效，enable为false时无效。因为4.0系统之后默认无效
     */
    /*private void setIconEnable(Menu menu, boolean enable) {
        if (menu != null) {
            try {
                Class clazz = menu.getClass();
                if (clazz.getSimpleName().equals("MenuBuilder")) {
                    Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);

                    //MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
                    m.invoke(menu, enable);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }*/

}
