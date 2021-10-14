package com.publicicat.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.internal.CheckableImageButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tvDate;
    DatePickerDialog.OnDateSetListener setListener;

    public static final String EXTRA_MESSAGE_NAME = "com.publicicat.testing.MESSAGE_NAME";
    public static final String EXTRA_MESSAGE_TEL = "com.publicicat.testing.MESSAGE_TEL";
    public static final String EXTRA_MESSAGE_EMAIL = "com.publicicat.testing.MESSAGE_EMAIL";
    public static final String EXTRA_MESSAGE_DESC = "com.publicicat.testing.MESSAGE_DESC";
    public static final String EXTRA_MESSAGE_CALEN = "com.publicicat.testing.MESSAGE_CALEN";

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thanks to:
        //https://www.youtube.com/watch?v=E1LSY3g-CtY
        tvDate = findViewById(R.id.tv_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = year+"/"+month+"/"+day;
                tvDate.setText(date);
            }
        };

        Bundle i = getIntent().getExtras();
        if( i != null) {

            //Do second part of exercise from here
            String message_name_b = i.getString(DisplayMessageActivity.intentBackName);
            String message_tel_b = i.getString(DisplayMessageActivity.intentBackTel);
            String message_email_b = i.getString(DisplayMessageActivity.intentBackEmail);
            String message_desc_b = i.getString(DisplayMessageActivity.intentBackDesc);
            String message_calen_b = i.getString(DisplayMessageActivity.intentBackCalen);

            // Capture the layout's TextView and set the string as its text
            EditText editText_name = findViewById(R.id.editTextTextPersonName);
            editText_name.setText(message_name_b);
            EditText editText_tel = findViewById(R.id.editTextTextPersonName4);
            editText_tel.setText(message_tel_b);
            EditText editText_email = findViewById(R.id.editTextTextPersonName5);
            editText_email.setText(message_email_b);
            EditText editText_desc = findViewById(R.id.editTextTextPersonName6);
            editText_desc.setText(message_desc_b);
            TextView tv_date = findViewById(R.id.tv_date);
            //java.sql.Date sqlDate = java.sql.Date.valueOf(String.valueOf(datePicker_calen));
            tv_date.setText(message_calen_b);
            //startActivity(i);


            //Do second part of exercise to here
            Button check = findViewById(R.id.check);
            check.setVisibility(View.VISIBLE);
        } else {
            Button check = findViewById(R.id.check);
            check.setVisibility(View.GONE);
        }

    }



    public void checkIntent(View view) {
        Bundle i = getIntent().getExtras();
        if( i != null) {

            //Do second part of exercise from here
            String message_name_b = i.getString(DisplayMessageActivity.intentBackName);
            String message_tel_b = i.getString(DisplayMessageActivity.intentBackTel);
            String message_email_b = i.getString(DisplayMessageActivity.intentBackEmail);
            String message_desc_b = i.getString(DisplayMessageActivity.intentBackDesc);
            //String message_calen_b = i.getStringExtra(DisplayMessageActivity.intentBackCalen);

            // Capture the layout's TextView and set the string as its text
            EditText editText_name = findViewById(R.id.editTextTextPersonName);
            editText_name.setText(message_name_b);
            EditText editText_tel = findViewById(R.id.editTextTextPersonName4);
            editText_tel.setText(message_tel_b);
            EditText editText_email = findViewById(R.id.editTextTextPersonName5);
            editText_email.setText(message_email_b);
            EditText editText_desc = findViewById(R.id.editTextTextPersonName6);
            editText_desc.setText(message_desc_b);
            //DatePicker datePicker_calen = findViewById(R.id.datePicker);
            //java.sql.Date sqlDate = java.sql.Date.valueOf(String.valueOf(datePicker_calen));
            //datePicker_calen.setText(sqlDate);
            //startActivity(i);


            //Do second part of exercise to here
        }
    }
    String name;
    String tel;
    String email;
    String desc;
    int day; int month; int yer;
    String cal;

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        name = editText.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.editTextTextPersonName4);
        tel = editText4.getText().toString();
        EditText editText5 = (EditText) findViewById(R.id.editTextTextPersonName5);
        email = editText5.getText().toString();
        EditText editText6 = (EditText) findViewById(R.id.editTextTextPersonName6);
        desc = editText6.getText().toString();

        intent.putExtra(EXTRA_MESSAGE_NAME, name);
        intent.putExtra(EXTRA_MESSAGE_TEL, tel);
        intent.putExtra(EXTRA_MESSAGE_EMAIL, email);
        intent.putExtra(EXTRA_MESSAGE_DESC, desc);

        TextView dateOfBirth = (TextView) findViewById(R.id.tv_date);
        cal = dateOfBirth.getText().toString();
        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    //final SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                    day = datePicker.getDayOfMonth();
                    month = datePicker.getMonth();
                    yer = datePicker.getYear();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(day, month, day);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String formatedDate = sdf.format(calendar.getTime());

                    String sday = Integer.toString(day);
                    String smonth = Integer.toString(month);
                    String syer = Integer.toString(yer);

                    yer = Integer.toString(year);
                    month = Integer.toString(monthOfYear);
                    day = Integer.toString(dayOfMonth);
                    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, monthOfYear, dayOfMonth);
                    String sDate = sdf.format(calendar.getTime());
                    Log.d("sDate formatted: " + sDate);
                    cal = sDate;
                    cal = day + month + yer;

                    cal = sday + smonth + syer;

                    //cal = formatedDate;
                    //Log.d(TAG, "The date tapped is: " + cal);

                }

            });

        }*/

        intent.putExtra(EXTRA_MESSAGE_CALEN, cal);
        /*
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //Th Thanks to: https://stackoverflow.com/questions/12121214/android-calendarview-how-do-i-get-the-date-in-correct-format/64871776
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                String sDate = sdf.format(calendar.getTime());
                //Log.d("sDate formatted: " + sDate);
                cal = sDate;
            }
        });*/

        //String message = editText.getText().toString();

        //intent.putExtra(EXTRA_MESSAGE_CALEN, cal);
        startActivity(intent);
        finish();
    }

}