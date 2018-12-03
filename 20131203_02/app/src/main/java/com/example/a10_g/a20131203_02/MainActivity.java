package com.example.a10_g.a20131203_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvSug;
    private EditText etSex,etAge;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSex = findViewById(R.id.etSex);
        etAge = findViewById(R.id.etAge);
        btnOk = findViewById(R.id.btnOk);
        tvSug = findViewById(R.id.tvSug);

        btnOk.setOnClickListener(btnOkListener);
    }

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
