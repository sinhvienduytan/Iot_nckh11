package com.example.pc.iot_nckh;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ImageButton btnon1,btnon2,btnon3,btnon4,btnonall,btnonxk1,btnonxk2,btnoncambien;
    ImageButton btnoff1,btnoff2,btnoff3,btnoff4,btnoffall,btnoffxk1,btnoffxk2,btnoffcambien;
    AlarmManager alarmManager1;
    AlarmManager alarmManager2;
    RadioButton radioButton1,radioButton2;
    RadioGroup radioGroup;
    private PendingIntent pendingIntent1,pendingIntent2;
    private TimePicker alarmTimePicker1,alarmTimePicker2;
    private static MainActivity inst;
    private TextView alarmTextView;
    public static String urlbat = "http://192.168.1.9/?buttonTTon";
    public static String urltat = "http://192.168.1.9/?buttonTToff";
    public static String url1on = "http://192.168.1.9/?button1on";
    public static String url1off = "http://192.168.1.9/?button1off";
    public static String url2on = "http://192.168.1.9/?button2on";
    public static String url2off = "http://192.168.1.9/?button2off";
    public static String url3on = "http://192.168.1.9/?button3on";
    public static String url3off = "http://192.168.1.9/?button3off";
    public static String url4on = "http://192.168.1.9/?button4on";
    public static String url4off = "http://192.168.1.9/?button4off";
    public static MainActivity instance() {
        return inst;
    }
    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker1 = (TimePicker) findViewById(R.id.timePicker3);
        alarmTimePicker2 = (TimePicker) findViewById(R.id.timePicker4);
        alarmTextView = (TextView) findViewById(R.id.textView6);
        alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager2 = (AlarmManager) getSystemService(ALARM_SERVICE);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //checkedid: tra ve id cua radiobutton
                switch (checkedId){
                    case R.id.radioButton1:
                        Toast.makeText(MainActivity.this,"Bạn chọn bật tất cả",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this,"Bạn chọn bật xen kẻ",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        btnoncambien = (ImageButton) findViewById(R.id.btnbatcambien);
        btnoffcambien = (ImageButton) findViewById(R.id.btntatcambien);

        btnon1 = (ImageButton) findViewById(R.id.b1);
        btnon2 = (ImageButton) findViewById(R.id.b2);
        btnon3 = (ImageButton) findViewById(R.id.b3);
        btnon4 = (ImageButton) findViewById(R.id.b4);

        btnoff1 = (ImageButton) findViewById(R.id.t1);
        btnoff2 = (ImageButton) findViewById(R.id.t2);
        btnoff3 = (ImageButton) findViewById(R.id.t3);
        btnoff4 = (ImageButton) findViewById(R.id.t4);

        btnonall = (ImageButton) findViewById(R.id.ball);
        btnonxk1 = (ImageButton) findViewById(R.id.bxk1);
        btnonxk2 = (ImageButton) findViewById(R.id.bxk2);

        btnoffall = (ImageButton) findViewById(R.id.tall);
        btnoffxk1 = (ImageButton) findViewById(R.id.txk1);
        btnoffxk2 = (ImageButton) findViewById(R.id.txk2);

        btnoncambien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(urlbat);
            }
        });

        btnoffcambien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(urltat);
            }
        });

        btnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url1on);
            }
        });
        btnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url1off);
            }
        });
        btnon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url2on);
            }
        });
        btnoff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url2off);
            }
        });
        btnon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url3on);
            }
        });
        btnoff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url3off);
            }
        });
        btnon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url4on);
            }
        });
        btnoff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url4off);
            }
        });
        btnonall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url1on);
                t = new ButtonTask();
                t.execute(url2on);
                t = new ButtonTask();
                t.execute(url3on);
                t = new ButtonTask();
                t.execute(url4on);
            }
        });
        btnoffall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url1off);
                t = new ButtonTask();
                t.execute(url2off);
                t = new ButtonTask();
                t.execute(url3off);
                t = new ButtonTask();
                t.execute(url4off);
            }
        });
        btnonxk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url1on);
                t = new ButtonTask();
                t.execute(url2on);
            }
        });
        btnoffxk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url1off);
                t = new ButtonTask();
                t.execute(url2off);
            }
        });
        btnonxk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url3on);
                t = new ButtonTask();
                t.execute(url4on);
            }
        });
        btnoffxk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonTask t = new ButtonTask();
                t.execute(url3off);
                t = new ButtonTask();
                t.execute(url4off);
            }
        });
        addcontrol();
    }
    //------------------------------------------------------------
    private void addcontrol() {
        // TODO Auto-generated method stub
        TabHost tab=(TabHost)findViewById(android.R.id.tabhost);
        tab.setup();
        TabHost.TabSpec tab1=tab.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Tab1");
        tab.addTab(tab1);
        TabHost.TabSpec tab2=tab.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Tab2");
        tab.addTab(tab2);
    }
    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.HOUR_OF_DAY, alarmTimePicker1.getCurrentHour());
            calendar1.set(Calendar.MINUTE, alarmTimePicker1.getCurrentMinute());
            Intent myIntent1 = new Intent(MainActivity.this, AlarmReceiver.class);
            pendingIntent1 = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent1, 0);
            alarmManager1.set(AlarmManager.RTC, calendar1.getTimeInMillis(), pendingIntent1);
            //------------------------------
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(Calendar.HOUR_OF_DAY, alarmTimePicker2.getCurrentHour());
            calendar2.set(Calendar.MINUTE, alarmTimePicker2.getCurrentMinute());
            Intent myIntent2 = new Intent(MainActivity.this, AlarmReceiver1.class);
            pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent2, 0);
            alarmManager2.set(AlarmManager.RTC, calendar2.getTimeInMillis(), pendingIntent2);
        } else {
            alarmManager1.cancel(pendingIntent1);
            setAlarmText("No Status");
            Log.d("MyActivity", "Alarm Off");
        }
    }
    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }
}
