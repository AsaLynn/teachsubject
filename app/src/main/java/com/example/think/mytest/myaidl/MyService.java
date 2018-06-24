package com.example.think.mytest.myaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.IMyInterface;

/**
 * Created by think on 2017/10/31.
 */

public class MyService extends Service {

    private IBinder binder = new IMyInterface.Stub() {
        @Override
        public String getInfor(String s) throws RemoteException {
            DemonstrateUtil.showLogResult("getInfor");
            return "我是 Service 返回的字符串";
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        DemonstrateUtil.showLogResult("onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
