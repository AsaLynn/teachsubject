package com.example.think.mytest.month2.m2u11.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.demonstrate.DemonstrateUtil;

/**
 * Created by think on 2017/11/12.
 * 1,创建广播接收器
 * 2,注册广播接收器
 * 3,发送一个条广播!
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        DemonstrateUtil.showToastResult(context,"接收到了我的自定义广播哦!!!");
    }
}
