package com.example.pc.iot_nckh;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Date;

public class AlarmReceiver extends WakefulBroadcastReceiver {
    public static String url1on = "http://192.168.1.9/?button1on";
    public static String url2on = "http://192.168.1.9/?button2on";
    public static String url3on = "http://192.168.1.9/?button3on";
    public static String url4on = "http://192.168.1.9/?button4on";
    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
        MainActivity inst = MainActivity.instance();
        int is = inst.radioGroup.getCheckedRadioButtonId();
        switch (is){
            case R.id.radioButton1:
                inst.setAlarmText("Bật tất cả các đèn!");
                ButtonTask t = new ButtonTask();
                t.execute(url1on);
                t = new ButtonTask();
                t.execute(url2on);
                t = new ButtonTask();
                t.execute(url3on);
                t = new ButtonTask();
                t.execute(url4on);
                break;
            case  R.id.radioButton2:
                //Date date; // your date
                Calendar cal = Calendar.getInstance();
                Date currentDate = Calendar.getInstance().getTime();
                cal.setTime(currentDate);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                if ((day % 2) == 0){
                    inst.setAlarmText("Bật chẵn xen kẻ các đèn!");
                    t = new ButtonTask();
                    t.execute(url1on);
                    t = new ButtonTask();
                    t.execute(url2on);
                }
                else {
                    inst.setAlarmText("Bật lẽ xen kẻ các đèn!");
                    t = new ButtonTask();
                    t.execute(url3on);
                    t = new ButtonTask();
                    t.execute(url4on);
                }
                break;
        }
    }
}

