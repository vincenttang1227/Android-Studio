package com.example.a10_g.a20181221_02_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etAge,etTall;
    private Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etTall = findViewById(R.id.et_tall);
        btnMain = findViewById(R.id.btn_main);
        btnMain.setOnClickListener(btnMainListener);
    }

    private Button.OnClickListener btnMainListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SecActivity.class);

            String name = etName.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());
            Double tall = Double.parseDouble(etTall.getText().toString());

            Bundle bundle = new Bundle();
            bundle.putString("Name", name);
            bundle.putInt("AGE", age);
            bundle.putDouble("TALL", tall);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };
}
