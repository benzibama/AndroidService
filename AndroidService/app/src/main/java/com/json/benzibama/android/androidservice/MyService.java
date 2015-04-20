package com.json.benzibama.android.androidservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.security.Provider;

/**
 * Created by bama on 4/14/2015.
 */
public class MyService extends Service {
    IBinder mBinder=new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return mBinder;
    }

    @Override
    public void onCreate() {
        //super.onCreate();
        Toast.makeText(this,"OnCreate executed",Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"OnStart COMMAND EXECUTED",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    public class LocalBinder extends Binder {
        public MyService getServerInstance(){
            return MyService.this;

        }
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this,"OnDestroy Executed",Toast.LENGTH_LONG).show();
    }

    public  int Add(int a,int b){
                int c;
        return c=a+b;
    }
}




