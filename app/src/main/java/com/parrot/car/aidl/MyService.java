/*
 * Copyright (c) 2019. Parrot Faurecia Automotive S.A.S. All rights reserved.
 */

package com.parrot.car.aidl;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wWX504383 on 2017/9/6.
 */

public class MyService extends Service  {


    int w= 100;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    @Override
    public void onCreate() {
        super.onCreate();


    }

    public class MyBinder extends IClient.Stub {


        @Override
        public void take(Book x) throws RemoteException {

            Log.i("-*---MyBinder----" + x.getName(),"----MyBinder---" + android.os.Process.myPid());
        }
    }

}
