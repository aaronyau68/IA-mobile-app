package com.example.chesterwong.iaproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int num = 0;
    private MyDBHelper helper;

    TextView txtRecordMon,txtRecordTue,txtRecordWed,txtRecordThu,txtRecordFri,txtRecordSat,txtRecordSun;

    String date_of_mon,date_of_tue,date_of_wed,date_of_thu,date_of_fri,date_of_sat,date_of_sun,selectedDate;

    String _TableName = "binRecord";
    private void openDB(){

        helper = new MyDBHelper(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnBack: //轉去上星期的7天
                num -= 7;

                break;
            case R.id.btnNext://轉去下星期的7天
                num += 7;
                break;
            case R.id.btnAddRecord: //跳至add record page
                Intent i = new Intent(MainActivity.this,AddRecordActivity.class);
                i .putExtra("selectedDate",selectedDate); // 用戶所選擇要修改 / 增加紀錄的日期
                startActivity(i);// 開始跳往add record page
            case R.id.txtRecordMon: //用戶選擇星期一
                txtRecordMon.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_mon;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordTue.setBackgroundResource(R.drawable.border);
                txtRecordWed.setBackgroundResource(R.drawable.border);
                txtRecordThu.setBackgroundResource(R.drawable.border);
                txtRecordFri.setBackgroundResource(R.drawable.border);
                txtRecordSat.setBackgroundResource(R.drawable.border);
                txtRecordSun.setBackgroundResource(R.drawable.border);


                break;
            case R.id.txtRecordTue://用戶選擇星期二
                txtRecordTue.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_tue;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordMon.setBackgroundResource(R.drawable.border);
                txtRecordWed.setBackgroundResource(R.drawable.border);
                txtRecordThu.setBackgroundResource(R.drawable.border);
                txtRecordFri.setBackgroundResource(R.drawable.border);
                txtRecordSat.setBackgroundResource(R.drawable.border);
                txtRecordSun.setBackgroundResource(R.drawable.border);


                break;
            case R.id.txtRecordWed://用戶選擇星期三
                txtRecordWed.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_wed;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordMon.setBackgroundResource(R.drawable.border);
                txtRecordTue.setBackgroundResource(R.drawable.border);
                txtRecordThu.setBackgroundResource(R.drawable.border);
                txtRecordFri.setBackgroundResource(R.drawable.border);
                txtRecordSat.setBackgroundResource(R.drawable.border);
                txtRecordSun.setBackgroundResource(R.drawable.border);


                break;
            case R.id.txtRecordThu://用戶選擇星期四
                txtRecordThu.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_thu;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordMon.setBackgroundResource(R.drawable.border);
                txtRecordTue.setBackgroundResource(R.drawable.border);
                txtRecordWed.setBackgroundResource(R.drawable.border);
                txtRecordFri.setBackgroundResource(R.drawable.border);
                txtRecordSat.setBackgroundResource(R.drawable.border);
                txtRecordSun.setBackgroundResource(R.drawable.border);


                break;
            case R.id.txtRecordFri://用戶選擇星期五
                txtRecordFri.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_fri;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordMon.setBackgroundResource(R.drawable.border);
                txtRecordTue.setBackgroundResource(R.drawable.border);
                txtRecordWed.setBackgroundResource(R.drawable.border);
                txtRecordThu.setBackgroundResource(R.drawable.border);
                txtRecordSat.setBackgroundResource(R.drawable.border);
                txtRecordSun.setBackgroundResource(R.drawable.border);


                break;
            case R.id.txtRecordSat://用戶選擇星期6
                txtRecordSat.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_sat;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordMon.setBackgroundResource(R.drawable.border);
                txtRecordTue.setBackgroundResource(R.drawable.border);
                txtRecordWed.setBackgroundResource(R.drawable.border);
                txtRecordThu.setBackgroundResource(R.drawable.border);
                txtRecordFri.setBackgroundResource(R.drawable.border);
                txtRecordSun.setBackgroundResource(R.drawable.border);


                break;
            case R.id.txtRecordSun://用戶選擇星期一
                txtRecordSun.setBackgroundColor(Color.parseColor("#F77575"));
                selectedDate=date_of_sun;

                //每次用戶選擇一個新日期，之前選舉左既日期會冇左high light
                txtRecordMon.setBackgroundResource(R.drawable.border);
                txtRecordTue.setBackgroundResource(R.drawable.border);
                txtRecordWed.setBackgroundResource(R.drawable.border);
                txtRecordThu.setBackgroundResource(R.drawable.border);
                txtRecordFri.setBackgroundResource(R.drawable.border);
                txtRecordSat.setBackgroundResource(R.drawable.border);


                break;

        }
        ShowTable();
        showRecord();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtRecordMon=(TextView) findViewById(R.id.txtRecordMon);
        txtRecordTue=(TextView) findViewById(R.id.txtRecordTue);
        txtRecordWed=(TextView) findViewById(R.id.txtRecordWed);
        txtRecordThu=(TextView) findViewById(R.id.txtRecordThu);
        txtRecordFri=(TextView) findViewById(R.id.txtRecordFri);
        txtRecordSat=(TextView) findViewById(R.id.txtRecordSat);
        txtRecordSun=(TextView) findViewById(R.id.txtRecordSun);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        Button btnAddRecord = (Button) findViewById(R.id.btnAddRecord);
        Button btnQuestionnaire = (Button)findViewById(R.id.btnQuestionnaire);
        Button btnQuestionnaire2 = (Button)findViewById(R.id.btnQuestionnaire2);
        Button btnInfo = (Button)findViewById(R.id.btnInfo);
        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnAddRecord.setOnClickListener(this);
        txtRecordMon.setOnClickListener(this);
        txtRecordTue.setOnClickListener(this);
        txtRecordWed.setOnClickListener(this);
        txtRecordThu.setOnClickListener(this);
        txtRecordFri.setOnClickListener(this);
        txtRecordSat.setOnClickListener(this);
        txtRecordSun.setOnClickListener(this);
        ShowTable();
        openDB();
        showRecord();

        SharedPreferences prefs = getSharedPreferences("file", MODE_PRIVATE);
        Long timeInMillis = prefs.getLong("time", 0);
   //     Toast.makeText(this,"original time = " + timeInMillis, Toast.LENGTH_SHORT).show();
        int done = prefs.getInt("doneQuestion", 0);
   //     Toast.makeText(this,"original int = " + done, Toast.LENGTH_SHORT).show();

        if (timeInMillis != 0) {
      //      Toast.makeText(this,"original time = " + timeInMillis, Toast.LENGTH_SHORT).show();
            Calendar current = Calendar.getInstance();
            long currentTimeInMillis = current.getTimeInMillis();
            long diff = (currentTimeInMillis - timeInMillis);
            long days = diff / (24 * 60 * 60 * 1000);
      //      Toast.makeText(this,"days = " + days, Toast.LENGTH_SHORT).show();

            if(days > 30 && done != 1){
                btnQuestionnaire2.performClick();   //after
                SharedPreferences.Editor editor = getSharedPreferences("file", MODE_PRIVATE).edit();
                editor.putInt("doneQuestion", 1);
                editor.apply();

            }
        }else{
            Calendar current = Calendar.getInstance();
            long currentInMillis = current.getTimeInMillis();
            SharedPreferences.Editor editor = getSharedPreferences("file", MODE_PRIVATE).edit();
            editor.putLong("time", currentInMillis);
            editor.putInt("doneQuestion", 0);
            editor.apply();
            btnQuestionnaire.performClick();    //before
        }

        //notification
        // set the calender
        Calendar c1 = Calendar.getInstance();
        //set the first notification time
        c1.set(Calendar.HOUR_OF_DAY,8);
        c1.set(Calendar.MINUTE,00);
        c1.set(Calendar.SECOND,00);

        //to set when click the notification, where did it go
        Intent intent = new Intent(getApplicationContext(), Notification_reciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        // when the time equals to the setting time , the nitification will push
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c1.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);


        Calendar c2 = Calendar.getInstance();
        //set the second notification time
        c2.set(Calendar.HOUR_OF_DAY,21);
        c2.set(Calendar.MINUTE,00);
        c2.set(Calendar.SECOND,00);

        //to set when click the notification, where did it go
        Intent intent1 = new Intent(getApplicationContext(),Notification_reciever1.class);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(),101,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        // when the time equals to the setting time , the nitification will push
        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP, c2.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent1);

}

    public void showRecord(){
        boolean mon=false,tue=false,wed=false,thu=false,fri=false,sat=false,sun=false;
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor c=db.rawQuery("SELECT * FROM "+_TableName, null);


        if (c.getCount()>0){    // 若有資料


            c.moveToFirst();    // 移到第 1 筆資料
            do{        // 逐筆讀出資料
                if(c.getString(1).equals(date_of_mon)) {
                    txtRecordMon.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordMon.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    mon=true;
                }


                if(c.getString(1).equals(date_of_tue)) {
                    txtRecordTue.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordTue.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    tue=true;
                }

                if(c.getString(1).equals(date_of_wed)) {
                    txtRecordWed.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordWed.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    wed = true;
                }

                if(c.getString(1).equals(date_of_thu)) {
                    txtRecordThu.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordThu.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    thu = true;
                }

                if(c.getString(1).equals(date_of_fri)) {
                    txtRecordFri.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordFri.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    fri = true;
                }

                if(c.getString(1).equals(date_of_sat)) {
                    txtRecordSat.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordSat.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    sat = true;
                }
                if(c.getString(1).equals(date_of_sun)) {
                    txtRecordSun.setText(c.getString(5)+" "+c.getString(3)+"屎\nNo exercise");
                    if(c.getString(6).equals("yes"))
                        txtRecordSun.setText(c.getString(5)+" "+c.getString(3)+"屎\nHave exercise");
                    sun = true;
                }

                if(mon==false)
                    txtRecordMon.setText("");
                if(tue==false)
                    txtRecordTue.setText("");
                if(wed==false)
                    txtRecordWed.setText("");
                if(thu==false)
                    txtRecordThu.setText("");
                if(fri==false)
                    txtRecordFri.setText("");
                if(sat==false)
                    txtRecordSat.setText("");
                if(sun==false)
                    txtRecordSun.setText("");

            } while(c.moveToNext());    // 有一下筆就繼續迴圈


        }


    }

    public void ShowTable() {

        Calendar calendar = Calendar.getInstance();

        /* get date of today*/
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        calendar.add(Calendar.DAY_OF_YEAR, num);
        Date d = calendar.getTime();
        String dayOfTheWeek = sdf.format(d);


        /*  case of  todat is mon */
        if (dayOfTheWeek.equals("Monday")||dayOfTheWeek.equals("星期一")) {
            /* show date of Mon*/
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);

            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow;
            /* show date of Tue*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow;
            /* show date of  Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow;

        }

        if (dayOfTheWeek.equals("Tuesday")||dayOfTheWeek.equals("星期二")) {
            /* show date of Mon*/
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);
            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow + "(一)";
            /* show date of Tue*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow;
            /* show date of  Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow;

        }

        if (dayOfTheWeek.equals("Wednesday")||dayOfTheWeek.equals("星期三")) {
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, -2);
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);
            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow;
            /* show date of  Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow;
            /* show date of Wed*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow;

        }

        if (dayOfTheWeek.equals("Thursday")||dayOfTheWeek.equals("星期四")) {
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, -3);
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);
            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow ;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow ;
            /* show date of  Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow ;
            /* show date of Thu*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow ;

        }

        if (dayOfTheWeek.equals("Friday")||dayOfTheWeek.equals("星期五")) {
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, -4);
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);
            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow;
            /* show date of  Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow;
            /* show date of Fri*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow;

        }

        if (dayOfTheWeek.equals("Sunday")||dayOfTheWeek.equals("星期")) {
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, -6);
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);
            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow;
            /* show date of  Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow;
            /* show date of Sun*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow;

        }

        if (dayOfTheWeek.equals("Saturday")||dayOfTheWeek.equals("星期六")) {
            /* show date of Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, -5);
            Date day = calendar.getTime();
            SimpleDateFormat dd = new SimpleDateFormat("dd/MM");
            String dayShow = dd.format(day);
            TextView lableMon = (TextView) findViewById(R.id.txtLableMon);
            lableMon.setText(dayShow + "(一)");
            date_of_mon=dayShow;
            /* show date of Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableTue = (TextView) findViewById(R.id.txtLableTue);
            lableTue.setText(dayShow + "(二)");
            date_of_tue=dayShow;
            /* show date of Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableWed = (TextView) findViewById(R.id.txtLableWed);
            lableWed.setText(dayShow + "(三)");
            date_of_wed=dayShow;
            /* show date of Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableThu = (TextView) findViewById(R.id.txtLableThu);
            lableThu.setText(dayShow + "(四)");
            date_of_thu=dayShow;
            /* show date of Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableFri = (TextView) findViewById(R.id.txtLableFri);
            lableFri.setText(dayShow + "(五)");
            date_of_fri=dayShow;
            /* show date of  Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSat = (TextView) findViewById(R.id.txtLableSat);
            lableSat.setText(dayShow + "(六)");
            date_of_sat=dayShow;
            /* show date of Sat*/
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            day = calendar.getTime();
            dayShow = dd.format(day);
            TextView lableSun = (TextView) findViewById(R.id.txtLableSun);
            lableSun.setText(dayShow + "(日)");
            date_of_sun=dayShow;

        }
    }

    public void questionnairePage(View view){
        Intent intent = null;
        intent = new Intent(this, questionnaire.class);
        startActivityForResult(intent, 1);
    }
    public void questionnairePage2(View view){
        Intent intent = null;
        intent = new Intent(this, questionnaire2.class);
        startActivityForResult(intent, 1);
    }
    public void moreInfo(View view){
        Intent intent = null;
        intent = new Intent(this, playVideoActivity.class);
        startActivityForResult(intent, 1);
    }

}