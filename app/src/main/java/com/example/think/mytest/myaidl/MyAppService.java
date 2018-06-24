package com.example.think.mytest.myaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.IMyAidlAppInterface;

public class MyAppService extends Service {
    public MyAppService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DemonstrateUtil.showLogResult("onCreate---MyAppService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IMyAidlAppInterface.Stub {

        @Override
        public String getName() throws RemoteException {
            return "test--->***";
        }
    }

}
