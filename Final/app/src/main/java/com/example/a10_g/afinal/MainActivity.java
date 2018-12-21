package com.example.a10_g.afinal;

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
        Button btnMain;
        btnMain = findViewById(R.id.btn_main);
        btnMain.setOnClickListener(btnMainListener);
    }

    private Button.OnClickListener btnMainListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MenuActivity.class);
            startActivity(intent);
        }
    };
}
