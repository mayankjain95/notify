package com.example.mayank.notify;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);z
    }

    public  void showNotification (View view){
        switch (view.getId()){
            case R.id.button1:
                showNormalNotification();
                break;
            case R.id.button2:
                showBigText();
                break;
            case R.id.button3:
                showBigPicture();
                break;
            case R.id.button4:
                showInboxStyle();
                break;
        }
    }

    private void showInboxStyle() {


        NotificationCompat.InboxStyle style=new NotificationCompat.InboxStyle();
        style.setBigContentTitle("Mr Mayank");
        style.addLine("hello1");
        style.addLine("hello2");


        //Build the content of  Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("MayankJain");
        builder.setContentText("Jain");
        builder.setTicker("ticker");
        builder.setSmallIcon(R.drawable.ic_notify);
        builder.setAutoCancel(true);
        builder.setStyle(style);


        Notification notification=builder.build();
        NotificationManager manager=(NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(9847, notification);
    }

   private void showBigPicture() {
       Bitmap bmp= BitmapFactory.decodeResource(this.getResources(),R.drawable.ic_notify);
       NotificationCompat.BigPictureStyle style=new NotificationCompat.BigPictureStyle();
       style.setBigContentTitle("something");
       style.bigPicture(bmp);

        //Build the content of  Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("MayankJain");
        builder.setContentText("Jain");
        builder.setTicker("ticker");
        builder.setSmallIcon(R.drawable.ic_notify);
        builder.setAutoCancel(true);
        builder.setStyle(style);


        Notification notification=builder.build();
        NotificationManager manager=(NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(987, notification);
    }


    private void showBigText() {

        //Assign the style
        NotificationCompat.BigTextStyle style=new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Mr Mayank");
        style.bigText("Mr Jain");

        //Build the content of  Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("MayankJain");
        builder.setContentText("Jain");
        builder.setTicker("ticker");
        builder.setSmallIcon(R.drawable.ic_notify);
        builder.setAutoCancel(true);
        builder.setStyle(style);


        Notification notification=builder.build();
        NotificationManager manager=(NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(95687, notification);
    }

    private void showNormalNotification() {

        //Build the content of  Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Mayank");
        builder.setContentText("Jain");
        builder.setTicker("ticker");
        builder.setSmallIcon(R.drawable.ic_notify);
        builder.setAutoCancel(true);



        // Provide intent for notification
        Intent i=new Intent(MainActivity.this, ActivityB.class);

        //Add Back Stack using TaskBuilder and set the intent to pendingIntent
        TaskStackBuilder stackBuilder=TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ActivityB.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent j=new Intent(MainActivity.this, Setting.class);
        TaskStackBuilder stackBuilder1=TaskStackBuilder.create(this);
        stackBuilder1.addParentStack(MainActivity.class);
        stackBuilder1.addNextIntent(i);
        PendingIntent pi_s=stackBuilder1.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.addAction(R.drawable.setting, "Setting", pi_s);
        builder.setContentIntent(pi);



        //Notification through Notification manager
        Notification notification=builder.build();
        NotificationManager manager=(NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1234,notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
