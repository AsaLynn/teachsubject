package com.example.think.mytest.monthsubjects;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.demonstrate.DemonstrateUtil;
import com.example.demonstrate.DialogUtil;
import com.example.demonstrate.HDHelper;
import com.example.think.mytest.R;
import com.example.think.mytest.month2.m2u11.broadcast.BroadcastActivity;
import com.example.think.mytest.month2.m2u11.eventbus.EventBusActivity;
import com.example.think.mytest.month2.m2u14.viewpager.ViewPagerDemoActivity;
import com.example.think.mytest.month2.m2u2.menu.ContextMenuActivity;
import com.example.think.mytest.month2.m2u2.menu.ContextMenuXmlActivity;
import com.example.think.mytest.month2.m2u2.menu.MenuCodeActivity;
import com.example.think.mytest.month2.m2u2.menu.MenuCustomActivity;
import com.example.think.mytest.month2.m2u2.menu.MenuDrawerActivity;
import com.example.think.mytest.month2.m2u2.menu.MenuSubMenuActivity;
import com.example.think.mytest.month2.m2u2.menu.MenuXmlActivity;
import com.example.think.mytest.month2.m2u2.menu.PopupMenuActivity;
import com.example.think.mytest.month2.m2u3.popupwindow.PopupWindowActivity;
import com.example.think.mytest.month2.m2u4.toast.ToastActivity;
import com.example.think.mytest.month2.m2u5.notification.NotificationDemoActivity;

import java.util.ArrayList;

/*
第2月内容.
 */
public class Month2Activity extends MonthBaseActivity {

    @Override
    protected void showUnit14() {
        startActivity(new Intent(this, ViewPagerDemoActivity.class));
    }

    @Override
    protected void showUnit11() {
        startActivity(new Intent(this, BroadcastActivity.class));
    }

    @Override
    protected void showUnit12() {
        startActivity(new Intent(this, EventBusActivity.class));
    }


    @Override
    protected void showUnit5() {
        startActivity(new Intent(this, NotificationDemoActivity.class));
    }

    protected void showUnit1() {
        String title = "1单元的内容使用!";
        String[] items = {
                "0确认对话框",
                "1单选对话框",
                "2单选对话框适配器方式",
                "3多选对话框",
                "4圆形进度对话框",
                "5日期选择对话框",
                "6时间选择对话框",
                "7自定义对话框",
                "8水平进度对话框",
                "9水平2级进度对话框",
        };
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        showUnit1Select0();
                        break;
                    case 1:
                        showUnit1Select1();
                        break;
                    case 2:
                        showUnit1Select2();
                        break;
                    case 3:
                        showUnit1Select3();
                        break;
                    case 4:
                        showUnit1Select4();
                        break;
                    case 5:
                        showUnit1Select5();
                        break;
                    case 6:
                        showUnit1Select6();
                        break;
                    case 7:
                        showUnit1Select7();
                        break;
                    case 8:
                        showUnit1Select8();
                        break;
                    case 9:
                        showUnit1Select9();
                        break;
                }
            }
        };
        DialogUtil.showListDialog(this, title, items, listener);
    }

    @Override
    protected int getUnitsId() {
        return R.array.test_m2_units;
    }

    protected void showUnit2() {
        String title = "2单元的内容使用!";
        String[] items = {
                "0Menu在代码中创建使用",
                "1Menu在xml中创建使用",
                "2Menu自定义自定义actionBar",
                "3Menu配合DrawerLayout",
                "4Menu使用SubMenu",
                "5ContextMenu使用",
                "6PopupMenu使用",
                "7ContextMenuxml使用",
        };
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                select(which);
            }
        };
        DialogUtil.showListDialog(this, title, items, listener);
    }

    @Override
    protected void showUnit3() {
        startActivity(new Intent(this, PopupWindowActivity.class));
    }

    @Override
    protected void showUnit4() {
        startActivity(new Intent(this, ToastActivity.class));
    }

    private void showUnit1Select9() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("2级的进度");
        progressDialog.setMessage("欢迎大家支持2级的进度");
        progressDialog.setMax(100);
        // 设置初始化已经增长的进度
        progressDialog.incrementProgressBy(20);
        progressDialog.incrementSecondaryProgressBy(50);
        //                设置进度条明确显示进度
        progressDialog.setIndeterminate(false);
//                是否可以通过返回按钮来取消对话框
        progressDialog.setCancelable(true);
        progressDialog.show();
        new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(200);
                        // 更新进度条的进度,可以在子线程中更新进度条进度
                        progressDialog.incrementProgressBy(1);
                        progressDialog.incrementSecondaryProgressBy(1);
                        i++;
                    } catch (Exception e) {
                    }
                }
                // 在进度条走完时删除Dialog
                progressDialog.dismiss();
            }
        }).start();
    }

    private void showUnit1Select8() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
        dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        dialog.setTitle("提示");
        dialog.setMax(100);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        dialog.setMessage("这是一个水平进度条");
        dialog.show();
        new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (i < 100) {
                    try {
                        Thread.sleep(200);
                        // 更新进度条的进度,可以在子线程中更新进度条进度
                        dialog.incrementProgressBy(1);
                        i++;

                    } catch (Exception e) {
                    }
                }
                // 在进度条走完时删除Dialog
                dialog.dismiss();
            }
        }).start();
    }

    private void showUnit1Select7() {
        new AlertDialog.Builder(this)
                .setTitle("这是自定义对话框!")
                .setPositiveButton("确定", null)
                .setNegativeButton("取消", null)
                .setView(View.inflate(Month2Activity.this, R.layout.layout_dialog, null))
                .create()
                .show();
    }

    private void showUnit1Select6() {
        TimePickerDialog dialog = new TimePickerDialog(Month2Activity.this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker arg0, int hourOfDay, int minute) {
                String text = "设置时间为：" + hourOfDay + "时" + minute + "分";
                DemonstrateUtil.showLogResult(text);
                DemonstrateUtil.showToastResult(Month2Activity.this, text);
            }
        }, 20, 55, true);
        dialog.show();
    }

    private void showUnit1Select5() {
        DatePickerDialog dialog = new DatePickerDialog(
                Month2Activity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                String text = "设置的时间为：" + year + "年" + (monthOfYear + 1)
                        //此处month要加1，原始月份从零开始了
                        + "月" + dayOfMonth + "日";
                DemonstrateUtil.showLogResult(text);
                DemonstrateUtil.showToastResult(Month2Activity.this, text);
            }
        }, 2014, 8, 17);
        dialog.show();
    }

    private void showUnit1Select4() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载信息，请稍后！");
        progressDialog.setTitle("正在加载");
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.onStart();

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        progressDialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        progressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
                DemonstrateUtil.showLogResult("onDismiss");
            }
        });
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    DemonstrateUtil.showLogResult("KEYCODE_BACK");
                }
                return false;
            }
        });
        // 监听cancel事件
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                DemonstrateUtil.showLogResult("onCancel");
            }
        });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DemonstrateUtil.showLogResult("取消按钮!");
                    }
                });
        progressDialog.show();
        HDHelper.getInstance().getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DemonstrateUtil.showToastResult(Month2Activity.this, "加载完毕!");
                progressDialog.dismiss();
            }
        }, 5 * 1000);
    }

    private void showUnit1Select3() {
        new AlertDialog.Builder(this)
                .setTitle("多选对话框标题!")
                .setMultiChoiceItems(new String[]{"条目0", "条目1", "条目2"}, new boolean[]{true, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        DemonstrateUtil.showLogResult(which + "--" + isChecked);
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DemonstrateUtil.showToastResult(Month2Activity.this, "确定");
            }
        }).create().show();
    }

    private void showUnit1Select2() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("单选框标题!")
                .setSingleChoiceItems(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>() {
                    {
                        for (int i = 0; i < 3; i++) {
                            add("选项" + i);
                        }
                    }
                }), 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DemonstrateUtil.showToastResult(Month2Activity.this, "选了选项:" + which);
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DemonstrateUtil.showToastResult(Month2Activity.this, "确定" + which);
            }
        }).create()
                .show();
    }

    private void showUnit1Select1() {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("单选对话框的标题!")
                .setSingleChoiceItems(new String[]{"单选条目0", "单选条目1", "单选条目2"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DemonstrateUtil.showToastResult(Month2Activity.this, "选择了选项" + which);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DemonstrateUtil.showToastResult(Month2Activity.this, "取消了");
            }
        }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DemonstrateUtil.showToastResult(Month2Activity.this, "确定" + which);
            }
        })
                .create()
                .show();
    }

    private void showUnit1Select0() {
        new AlertDialog.Builder(this)
                .setTitle("这是确认对话框标题!")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("这是确认对话框消息内容!")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DemonstrateUtil.showToastResult(Month2Activity.this, "确定");
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DemonstrateUtil.showToastResult(Month2Activity.this, "取消");
            }
        }).create().show();
    }

    private void select(int which) {
        switch (which) {
            case 0:
                Intent intent = new Intent();
                intent.setClass(Month2Activity.this, MenuCodeActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent();
                intent1.setClass(Month2Activity.this, MenuXmlActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent();
                intent2.setClass(Month2Activity.this, MenuCustomActivity.class);
                startActivity(intent2);
                break;
            case 3:
                startActivity(new Intent(this, MenuDrawerActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, MenuSubMenuActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, ContextMenuActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, PopupMenuActivity.class));
                break;
            case 7:
                startActivity(new Intent(this, ContextMenuXmlActivity.class));
                break;
            /*case 8:
                startActivity(new Intent(this, NotificationDemoActivity.class));
                break;*/
        }

    }

}
