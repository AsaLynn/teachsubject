package com.example.think.mytest.myaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;

import com.example.demonstrate.DemonstrateUtil;
import com.example.think.mytest.IMyInterface;
import com.example.think.mytest.R;

public class AidlDemoActivity extends AppCompatActivity {

    private IMyInterface myInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myInterface = IMyInterface.Stub.asInterface(service);
            DemonstrateUtil.showLogResult("连接Service 成功");
            try {
                String s = myInterface.getInfor("我是Activity传来的字符串");
                DemonstrateUtil.showLogResult("从Service得到的字符串：" + s);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            DemonstrateUtil.showLogResult("连接Service失败");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month2_unit2);
        startAndBindService();
        //startService(new Intent())
    }

    private void startAndBindService() {
        Intent service = new Intent(AidlDemoActivity.this, MyService.class);
        Intent serviceApp = new Intent(AidlDemoActivity.this, MyAppService.class);
        startService(serviceApp);
        //startService(service);
        bindService(service, serviceConnection, Context.BIND_AUTO_CREATE);
    }
}
