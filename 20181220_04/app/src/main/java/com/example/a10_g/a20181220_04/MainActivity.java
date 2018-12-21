package com.example.a10_g.a20181220_04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPage2 = findViewById(R.id.btn_main);
        btnPage2.setOnClickListener(btnPage2Listener);
    }

    private Button.OnClickListener btnPage2Listener = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            //增加Intent物件
            Intent intent = new Intent();
            //設定Intent內容
            intent.setClass(MainActivity.this,SecActivity.class);
            //啟動Intent
            startActivity(intent);
        }
    };
}