package com.publicicat.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    public static final String intentBackName = "com.publicicat.testing.MESSAGE_NAME";
    public static final String intentBackTel = "com.publicicat.testing.MESSAGE_TEL";
    public static final String intentBackEmail = "com.publicicat.testing.MESSAGE_EMAIL";
    public static final String intentBackDesc = "com.publicicat.testing.MESSAGE_DESC";
    public static final String intentBackCalen = "com.publicicat.testing.MESSAGE_CALEN";

    String nameB;
    String telB;
    String emailB;
    String descB;
    String calenB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Bundle intent = getIntent().getExtras();
        String message_name = intent.getString(MainActivity.EXTRA_MESSAGE_NAME);
        String message_tel = intent.getString(MainActivity.EXTRA_MESSAGE_TEL);
        String message_email = intent.getString(MainActivity.EXTRA_MESSAGE_EMAIL);
        String message_desc = intent.getString(MainActivity.EXTRA_MESSAGE_DESC);
        String message_calen = intent.getString(MainActivity.EXTRA_MESSAGE_CALEN);

        // Capture the layout's TextView and set the string as its text
        TextView textView_name = findViewById(R.id.textView_name);
        textView_name.setText(message_name);
        TextView textView_tel = findViewById(R.id.textView_tel);
        textView_tel.setText(message_tel);
        TextView textView_email = findViewById(R.id.textView_email);
        textView_email.setText(message_email);
        TextView textView_desc = findViewById(R.id.textView_desc);
        textView_desc.setText(message_desc);
        TextView textView_calen = findViewById(R.id.textView_calen);
        textView_calen.setText(message_calen);
    }

    /**Call buttons by their own and single onClick name event*/
    public void previous(View view) {
        Intent i = new Intent(DisplayMessageActivity.this, MainActivity.class);

        /*Navegació directa:
        startActivity(new Intent(DisplayMessageActivity.this, MainActivity.class));
         */
        TextView textView_name = (TextView) findViewById(R.id.textView_name);
        TextView textView_tel = (TextView) findViewById(R.id.textView_tel);
        TextView textView_email = (TextView) findViewById(R.id.textView_email);
        TextView textView_desc = (TextView) findViewById(R.id.textView_desc);
        TextView textView_calen = (TextView) findViewById(R.id.textView_calen);

        nameB = textView_name.getText().toString();
        telB = textView_tel.getText().toString();
        emailB = textView_email.getText().toString();
        descB = textView_desc.getText().toString();
        calenB = textView_calen.getText().toString();

        i.putExtra(intentBackName, nameB);
        i.putExtra(intentBackTel, telB);
        i.putExtra(intentBackEmail, emailB);
        i.putExtra(intentBackDesc, descB);
        i.putExtra(intentBackCalen, calenB);

        startActivity(i);
        finish();
    }

}