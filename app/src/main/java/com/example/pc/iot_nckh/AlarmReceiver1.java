package com.example.pc.iot_nckh;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Date;

public class AlarmReceiver1 extends WakefulBroadcastReceiver {
    public static String url1off = "http://192.168.1.9/?button1off";
    public static String url2off = "http://192.168.1.9/?button2off";
    public static String url3off = "http://192.168.1.9/?button3off";
    public static String url4off = "http://192.168.1.9/?button4off";

    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
        MainActivity inst = MainActivity.instance();
        int is = inst.radioGroup.getCheckedRadioButtonId();
        switch (is) {
            case R.id.radioButton1:
                inst.setAlarmText("Tắt tất cả các đèn!");
                ButtonTask t = new ButtonTask();
                t.execute(url1off);
                t = new ButtonTask();
                t.execute(url2off);
                t = new ButtonTask();
                t.execute(url3off);
                t = new ButtonTask();
                t.execute(url4off);
                break;
            case R.id.radioButton2:
                //Date date; // your date
                Calendar cal = Calendar.getInstance();
                Date currentDate = Calendar.getInstance().getTime();
                cal.setTime(currentDate);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                if ((day % 2) == 0){
                    inst.setAlarmText("Tắt chẵn xen kẻ các đèn!");
                    t = new ButtonTask();
                    t.execute(url1off);
                    t = new ButtonTask();
                    t.execute(url2off);
                } else {
                    inst.setAlarmText("Tắt lẽ xen kẻ các đèn!");
                    t = new ButtonTask();
                    t.execute(url3off);
                    t = new ButtonTask();
                    t.execute(url4off);
                }
                break;
        }
    }
}
