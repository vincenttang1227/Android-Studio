package com.example.a10_g.a20181220_04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        Button btnPage2 = findViewById(R.id.btn_sec);
        btnPage2.setOnClickListener(btnPage1Listener);
    }

    private  Button.OnClickListener btnPage1Listener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
