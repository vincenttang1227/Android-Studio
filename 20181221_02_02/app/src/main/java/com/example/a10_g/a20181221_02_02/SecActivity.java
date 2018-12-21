package com.example.a10_g.a20181221_02_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        TextView txtShow = findViewById(R.id.tv_sec);
        Button btnSec = findViewById(R.id.btn_sec);

        btnSec.setOnClickListener(btnSecListener);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("Name");
        int age = bundle.getInt("AGE");
        double tall = bundle.getDouble("TALL");
        String s = "姓名：" + name + "\n" +
                "年齡：" + age + "\n" +
                "身高：" + tall;
        txtShow.setText(s);
    }

    private Button.OnClickListener btnSecListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
