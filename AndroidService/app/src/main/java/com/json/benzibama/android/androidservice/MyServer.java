package com.json.benzibama.android.androidservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by bama on 4/21/2015.
 */
public class MyServer extends Service{
    private MediaPlayer mplayer;
    IBinder mBinder=new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return mBinder;
    }

    @Override
    public void onCreate() {
        //super.onCreate();
        Toast.makeText(this, "OnCreate executed", Toast.LENGTH_LONG).show();
    }
    public class LocalBinder extends Binder {
        public MyServer getServerInstance(){
            return MyServer.this;

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
