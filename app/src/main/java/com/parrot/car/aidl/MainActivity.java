package com.parrot.car.aidl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.telecom.ConnectionService;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    ServiceConnection mConnection;
    IClient mIClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.texts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mIClient.take(new Book("王项羽"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        mConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mIClient = IClient.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mIClient = null;
            }
        };

        Intent intent = new Intent(this,MyService.class);
        bindService(intent,mConnection,BIND_AUTO_CREATE);
    }
}
