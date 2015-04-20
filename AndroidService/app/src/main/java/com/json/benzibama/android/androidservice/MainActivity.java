package com.json.benzibama.android.androidservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import com.json.benzibama.android.androidservice.MyService;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    boolean mBounded;
    MyService mServer;
    EditText avalue,bvalue;
    Button startButton,StopButton,AddButton;
    MyService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avalue=(EditText) findViewById(R.id.text1);
        final Integer s1=Integer.parseInt(avalue.getText().toString());
        bvalue=(EditText) findViewById(R.id.text2);
        final Integer s2=Integer.parseInt(bvalue.getText().toString());
        AddButton=(Button) findViewById(R.id.Add);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cvalue=service.Add(s1,s2);
                Toast.makeText(MainActivity.this,cvalue,Toast.LENGTH_LONG).show();
            }
        });

    }



    public void startService(View v){
        startService(new Intent(getBaseContext(),MyService.class));
    }

    public void stopService(View v){
        stopService(new Intent(getBaseContext(),MyService.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(MainActivity.this,MyService.class);
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }
    ServiceConnection mConnection=new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            Toast.makeText(MainActivity.this, "Service Disconnected", Toast.LENGTH_LONG).show();
            mBounded=false;
            mServer=null;

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            Toast.makeText(MainActivity.this, "Service Connected", Toast.LENGTH_LONG).show();
            mBounded=true;

            MyService.LocalBinder mLocalBinder=(MyService.LocalBinder)service;
            mServer=mLocalBinder.getServerInstance();
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
