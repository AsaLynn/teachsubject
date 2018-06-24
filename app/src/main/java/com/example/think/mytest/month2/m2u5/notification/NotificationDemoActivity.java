package com.example.think.mytest.month2.m2u5.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RemoteViews;

import com.example.demonstrate.DemonstrateUtil;
import com.example.demonstrate.DialogUtil;
import com.example.think.mytest.R;
import com.example.think.mytest.base.BaseActivity;

public class NotificationDemoActivity extends BaseActivity {

    protected LinearLayout commonRootLl;
    private NotificationManager mNotificationManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_comcon);
        initView();

        //获取NotificationManager
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        pendingIntent = PendingIntent.getActivity(this, 0, new Intent("android.settings.SETTINGS"), 0);
    }

    private void initView() {
        commonRootLl = (LinearLayout) findViewById(R.id.common_root_ll);
        for (int i = 0; i < 2; i++) {
            Button button = new Button(this);
            button.setOnClickListener(this);
            button.setId(Button.NO_ID + i);
            button.setText("Notification的操作!" + i);
            commonRootLl.addView(button);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case Button.NO_ID + 0:
                DialogUtil.showListDialog(this, "Notification的操作!", new String[]{
                        "0默认的Notification",
                        "1自定义的Notification",
                        "2取消Notification",
                        "3DEFAULT_ALL的Notification",
                        "4DEFAULT_LIGHTS的Notification",
                        "5DEFAULT_VIBRATE的Notification",
                        "6sdk4.4以下的NotificationCompat.Builder",
                        "7倒计时的Notification",
                        "8下载进度的Notification",
                        "9BigTextStyle的Notification",
                        "10InboxStyle的Notification",
                        "11BigPictureStyle的Notification",
                        "12hangup横幅通知",
                        "13MediaStyle的通知",
                        "14自定义的通知",
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                show0();
                                break;
                            case 1:
                                show1();
                                break;
                            case 2:
                                show2();
                                break;
                            case 3:
                                show3();
                                break;
                            case 4:
                                show4();
                                break;
                            case 5:
                                show5();
                                break;
                            case 6:
                                show6();
                                break;
                            case 7:
                                show7();
                                break;
                            case 8:
                                show8();
                                break;
                            case 9:
                                show9();
                                break;
                            case 10:
                                show10();
                                break;
                            case 11:
                                show11();
                                break;
                            case 12:
                                show12();
                                break;
                            case 13:
                                show13();
                                break;
                            case 14:
                                show14();
                                break;
                        }
                    }
                });
                break;
        }
    }

    private void show14() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Notification");
        builder.setContentText("自定义通知栏示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        builder.setShowWhen(false);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.notification_template_customer);
        remoteViews.setTextViewText(R.id.title,"Notification");
        remoteViews.setTextViewText(R.id.text,"song"+0);

        remoteViews.setOnClickPendingIntent(R.id.btn1,pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.btn2,pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.btn3,pendingIntent);

        builder.setContent(remoteViews);
        Notification notification = builder.build();
        mNotificationManager.notify(14,notification);
    }

    private void show13() {
        android.support.v4.media.app.NotificationCompat.MediaStyle mediaStyle = new android.support.v4.media.app.NotificationCompat.MediaStyle();
        mediaStyle.setMediaSession(new MediaSessionCompat(this,"MediaSession",
                new ComponentName(this,Intent.ACTION_MEDIA_BUTTON),null).getSessionToken());
        mediaStyle.setCancelButtonIntent(pendingIntent);
        mediaStyle.setShowCancelButton(true);
        mediaStyle.setShowActionsInCompactView(2,2);
        Notification notification = new NotificationCompat.Builder(this, "")
                .setContentText("MediaStyle")
                .setContentTitle("Song Title")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setContentIntent(pendingIntent)
                .addAction(R.mipmap.heart0, "00", null)////第一个参数是图标资源id 第二个是图标显示的名称，第三个图标点击要启动的PendingIntent
                .addAction(R.mipmap.heart2, "11", null)////第一个参数是图标资源id 第二个是图标显示的名称，第三个图标点击要启动的PendingIntent
                .addAction(R.mipmap.heart4, "22", null)////第一个参数是图标资源id 第二个是图标显示的名称，第三个图标点击要启动的PendingIntent
                .setShowWhen(false)
                .setStyle(mediaStyle)
                .build();
        mNotificationManager.notify(13,notification);
    }

    private void show12() {
        Notification notification = new NotificationCompat.Builder(this, "show12")
                .setContentTitle("横幅通知")
                .setContentText("请在设置通知管理中开启消息横幅提醒权限")
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.heart2))
                .setContentIntent(pendingIntent)
                .setFullScreenIntent(pendingIntent, true)
                .setAutoCancel(true)
                .build();
        mNotificationManager.notify(12,notification);
    }

    private void show11() {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat
                .BigPictureStyle()
                .setSummaryText("BigPicture演示示例")
                .bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.iv_big_pic));

        Notification notification = new NotificationCompat.Builder(this, "channelid11")
                .setContentTitle("BigPictureStyle")
                .setContentText("setContentText")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.heart1))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setStyle(bigPictureStyle)
                .build();
        mNotificationManager.notify(11, notification);
    }

    private void show10() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat
                .InboxStyle()
                .setBigContentTitle("BigContentTitle")
                .addLine("第一行，第一行，第一行，第一行，第一行，第一行，第一行")
                .addLine("第二行")
                .addLine("第3行")
                .addLine("第4行")
                .addLine("第5行")
                .addLine("第6行")
                .setSummaryText("SummaryText");
        Notification notification = new NotificationCompat.Builder(this, "channelId10")
                .setContentTitle("InBoxStyle")
                .setContentText("InBoxStyle演示实例")
                .setSmallIcon(R.mipmap.heart0)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setStyle(inboxStyle)
                .build();
        mNotificationManager.notify(10, notification);
    }

    private void show9() {
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.bigText("这里是点击通知后要显示的正文，可以换行可以显示很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长");
        style.setBigContentTitle("点击后的标题");
        //SummaryText没什么用 可以不设置
        style.setSummaryText("末尾只一行的文字内容");

        Notification notification = new NotificationCompat
                .Builder(this, "channelid9")
                .setContentTitle("BigTextStyle")
                .setContentText("BigTextStyle演示示例")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.heart2))
                .setStyle(style)
                .setAutoCancel(true)//点击后通知消失
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setContentIntent(pendingIntent)
                .build();
        mNotificationManager.notify(9, notification);
    }

    private void show8() {
        Notification notification = new NotificationCompat
                .Builder(this, "channelId8")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.heart1))
                .setAutoCancel(false) //禁止用户点击删除按钮删除
                .setOngoing(true)//禁止滑动删除
                .setShowWhen(false)//取消右上角的时间显示
                .setContentTitle("下载中..." + 50 + "%")
                .setProgress(100, 50, false)
                //builder.setContentInfo(progress+"%");
                .setOngoing(true)
                .build();
        mNotificationManager.notify(8, notification);
    }

    private void show7() {
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent("android.settings.SETTINGS"), 0);
        Notification notification = new NotificationCompat.Builder(this, "channelId0")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.heart0))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setTicker("hello,你有新的消息7!")
                .setContentTitle("今日说法")
                .setContentText("今日说法：我是通知内容")
                .setContentIntent(pendingIntent)
                .setSubText("This is the subText !")
                .setUsesChronometer(true)
                .setContentInfo("ContentInfo")
                .build();
        mNotificationManager.notify(2, notification);
    }

    private void show6() {
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent("android.settings.SETTINGS"), 0);
        Notification notification = new NotificationCompat.Builder(this, "channelId0")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.payment_method_wechat))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setTicker("hello,你有新的消息!")
                .setContentTitle("今日说法")
                .setContentText("今日说法：我是通知内容")
                .setContentIntent(pendingIntent)
                .setColor(getResources().getColor(R.color.colorAccent))
                .setShowWhen(false)
                .setSubText("This is the subText !")
                .setNumber(3)
                .setAutoCancel(false)
                .setOngoing(true)//禁止滑动删除
                .build();
        mNotificationManager.notify(2, notification);
    }

    private void show5() {
        if (Build.VERSION.SDK_INT >= 16) {
            //创建Notification
            Notification mNotification = new Notification.Builder(this)
                    .setTicker("Notification:你有新的消息!")//来通知的时的提示文字
                    .setDefaults(Notification.DEFAULT_VIBRATE)//设置来消息的声音
                    .setSmallIcon(R.mipmap.ic_launcher_round)//展示小图标
                    .setContentTitle("this is ContentTitle !")//展示在状态栏的标题
                    .setContentText("this is ContentText!")//展示在状态栏的内容
                    .build();
            mNotificationManager.notify(1, mNotification);
        }
    }

    private void show4() {
        if (Build.VERSION.SDK_INT >= 16) {
            //创建Notification
            Notification mNotification = new Notification.Builder(this)
                    .setTicker("Notification,你有新的消息!")//来通知的时的提示文字
                    .setDefaults(Notification.DEFAULT_LIGHTS)//设置
                    .setSmallIcon(R.mipmap.ic_launcher_round)//展示小图标
                    .setContentTitle("this is ContentTitle !")//展示在状态栏的标题
                    .setContentText("this is ContentText!")//展示在状态栏的内容
                    .build();
            mNotificationManager.notify(1, mNotification);
        }
    }

    private void show3() {
        if (Build.VERSION.SDK_INT >= 16) {
            //创建Notification
            Notification mNotification = new Notification.Builder(this)
                    .setTicker("Notification,你有新的消息!")//来通知的时的提示文字
                    .setDefaults(Notification.DEFAULT_ALL)//设置来消息的声音
                    .setSmallIcon(R.mipmap.ic_launcher_round)//展示小图标
                    .setContentTitle("this is ContentTitle !")//展示在状态栏的标题
                    .setContentText("this is ContentText!")//展示在状态栏的内容
                    .build();//所有属性设置后,到最后调用此方法


            //开始执行通知
            // 如果该NOTIFICATION_ID的通知已存在，会显示最新通知的相关信息 ，比如tickerText 等
            mNotificationManager.notify(1, mNotification);
        }
    }

    private void show2() {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // 取消的只是当前Context的Notification
        mNotificationManager.cancel(2);
    }

    private void show1() {
        //定义一个Notification
        CharSequence title = "i am new";
        int icon = R.mipmap.ic_launcher_round;
        long when = System.currentTimeMillis();
        //参数1:,参数2:,参数3:
        Notification noti = new Notification(icon, title, when + 10 * 1000);

        noti.flags = Notification.FLAG_INSISTENT;

        // 1、创建一个自定义的消息布局 view.xml
        // 2、在程序代码中使用RemoteViews的方法来定义image和text。然后把RemoteViews对象传到contentView字段
        RemoteViews remoteView = new RemoteViews(this.getPackageName(), R.layout.notification);
        remoteView.setImageViewResource(R.id.image, R.mipmap.ic_launcher_round);
        remoteView.setTextViewText(R.id.text, "通知类型为：自定义View");
        noti.contentView = remoteView;
        // 3、为Notification的contentIntent字段定义一个Intent(注意，使用自定义View不需要setLatestEventInfo()方法)
        //这儿点击后简单启动Settings模块
        PendingIntent contentIntent = PendingIntent.getActivity
                (this, 0, new Intent("android.settings.SETTINGS"), 0);
        noti.contentIntent = contentIntent;
        NotificationManager mnotiManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mnotiManager.notify(0, noti);
    }

    private void show0() {

        if (Build.VERSION.SDK_INT >= 16) {
            //创建Notification

            Notification mNotification = new Notification.Builder(this)
                    .setTicker("Notification:你有新的消息!")//来通知的时的提示文字
                    .setDefaults(Notification.DEFAULT_SOUND)//设置来消息的声音
                    .setSmallIcon(R.mipmap.ic_launcher_round)//展示小图标
                    .setContentTitle("this is ContentTitle !")//展示在状态栏的标题
                    .setContentText("this is ContentText!")//展示在状态栏的内容
                    .setContentIntent(pendingIntent)//状态栏的点击意图
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.payment_method_wechat))
                    .build();//所有属性设置后,到最后调用此方法

            //开始执行通知
            // 如果该NOTIFICATION_ID的通知已存在，会显示最新通知的相关信息 ，比如tickerText 等
            mNotificationManager.notify(1, mNotification);
        } else {
            DemonstrateUtil.showToastResult(this, "版本低于16!");
        }

    }
}
