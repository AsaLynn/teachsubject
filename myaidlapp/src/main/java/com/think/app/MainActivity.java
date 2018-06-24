package com.think.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.think.mytest.IMyAidlAppInterface;

public class MainActivity extends AppCompatActivity {

    private IMyAidlAppInterface iMyAidlInterface;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //com.example.think.mytest.myaidl.MyAppService
        //cc.abto.server
        bindService(new Intent("cc.abto.server"), new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iMyAidlInterface = IMyAidlAppInterface.Stub.asInterface(service);
                Log.i(TAG, "onServiceConnected: ---***");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "onServiceDisconnected: ");
            }
        }, BIND_AUTO_CREATE);


        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplication(),iMyAidlInterface.getName(),Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
