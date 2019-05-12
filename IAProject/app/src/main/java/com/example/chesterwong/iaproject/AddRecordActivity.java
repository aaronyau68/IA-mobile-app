package com.example.chesterwong.iaproject;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddRecordActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtSelectedDate;
    EditText editTextDate,editTextTime,editTextColor,editTextShape,editTextQuantity;
    CheckBox chkExercise;
    RadioButton rdbLess,rdbGeneral,rdbMuch;
    TimePicker simpleTimePicker;
    int hour;
    int minute;
    String quantity;
    private MyDBHelper helper;
    String exercise="no";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        Button btnSaveRecord = (Button) findViewById(R.id.btnSaveRecord);
        btnSaveRecord.setOnClickListener(this);


        Intent i = this.getIntent();
        rdbLess = (RadioButton) findViewById(R.id.rdbLess);
        rdbGeneral = (RadioButton) findViewById(R.id.rdbGeneral);
        rdbMuch = (RadioButton) findViewById(R.id.rdbMuch);
        chkExercise = (CheckBox)findViewById(R.id.chkExercise);

        txtSelectedDate=(TextView) findViewById(R.id.txtSelectedDate);
        txtSelectedDate.setText("You have selected "+i.getStringExtra("selectedDate") );
        editTextDate=(EditText) findViewById(R.id.editTextDate);
        setEditTextReadOnly(editTextDate);
         simpleTimePicker=(TimePicker)findViewById(R.id.simpleTimePicker);

        simpleTimePicker.setIs24HourView(true);

        editTextColor=(EditText) findViewById(R.id.editTextColor);
        editTextShape=(EditText) findViewById(R.id.editTextShape);


        editTextDate.setText(i.getStringExtra("selectedDate") );
        openDB();
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnSaveRecord:
                if(chkExercise.isChecked())
                    exercise="yes";
                if(rdbLess.isChecked())
                    quantity="less";
                if(rdbGeneral.isChecked())
                    quantity="general";
                if(rdbMuch.isChecked())
                    quantity="much";

                hour = simpleTimePicker.getCurrentHour();
                 minute = simpleTimePicker.getCurrentMinute();
                add();
                Intent ii = new Intent(AddRecordActivity.this,addToGoogleExcel.class);
                ii .putExtra("date",editTextDate.getText().toString()); // 用戶所選擇要修改 / 增加紀錄的日期
                ii .putExtra("time",hour+":"+minute); // 用戶所選擇要修改 / 增加紀錄的日期
                ii .putExtra("color",editTextColor.getText().toString()); // 用戶所選擇要修改 / 增加紀錄的日期
                ii .putExtra("shape",editTextShape.getText().toString()); // 用戶所選擇要修改 / 增加紀錄的日期
                ii .putExtra("quantity", quantity); // 用戶所選擇要修改 / 增加紀錄的日期
                ii .putExtra("exercise", exercise); // 用戶所選擇要修改 / 增加紀錄的日期
                startActivity(ii);// 開始跳往add record page
                break;
        }
    }

    private void add(){

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("_date", editTextDate.getText().toString());

        values.put("_time", hour+":"+minute);

        values.put("_color", editTextColor.getText().toString());
        values.put("_shape", editTextShape.getText().toString());
        values.put("_quantity", quantity);
        values.put("_exercise", exercise);

        db.insert("binRecord", null, values);

    }

    private void openDB(){

        helper = new MyDBHelper(this);

    }

    public static void setEditTextReadOnly(TextView view){

        if (view instanceof android.widget.EditText){
            view.setCursorVisible(false);      //設置光標不可見
            view.setFocusable(false);           //無焦點
            view.setFocusableInTouchMode(false);     //觸摸時也得不到焦點
        }
    }

}
