package com.example.think.mytest.month2.m2u4.toast;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.demonstrate.DialogUtil;
import com.example.think.mytest.R;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_toast);
        initView();
    }

    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.btn_toast) {
            final String[] items = {"0默认Toast弹出",
                    "1自定义位置Toast",
                    "2带图片Toast",
                    "3完全自定义Toast",
                    "4顶部位置Toast",
            };
            DialogUtil.showListDialog(this, "Toast弹出样式!", items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            Toast.makeText(getApplication(), items[which], Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast toast = Toast.makeText(getApplication(), items[which], Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            break;
                        case 2:
                            Toast toast1 = Toast.makeText(getApplication(), items[which], Toast.LENGTH_LONG);
                            toast1.setGravity(Gravity.CENTER, 0, 0);
                            LinearLayout view1 = (LinearLayout) toast1.getView();
                            ImageView imageView = new ImageView(getApplication());
                            imageView.setImageResource(R.mipmap.ic_launcher_round);
                            view1.addView(imageView,0);
                            toast1.show();
                            break;
                        case 3:
                            Toast toast2 = new Toast(getApplication());
                            View toastView = View.inflate(getApplication(),R.layout.custom_toast,null);
                            toast2.setView(toastView);
                            toast2.setGravity(Gravity.CENTER,0,0);
                            toast2.setDuration(Toast.LENGTH_LONG);
                            toast2.show();
                            break;
                        case 4:
                            Display display = getWindowManager().getDefaultDisplay();
                            // 获取屏幕高度
                            int height = display.getHeight();
                            Toast toast3 = Toast.makeText(getApplication(), "居中上部位置的Toast", Toast.LENGTH_LONG);
                            // 这里给了一个1/4屏幕高度的y轴偏移量
                            toast3.setGravity(Gravity.TOP, 0, height / 4);
                            toast3.show();
                            break;

                    }
                }
            });
        }
    }

    private void initView() {
        btnToast = (Button) findViewById(R.id.btn_toast);
        btnToast.setOnClickListener(ToastActivity.this);
    }
}
