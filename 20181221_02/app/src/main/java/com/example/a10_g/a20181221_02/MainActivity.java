package com.example.a10_g.a20181221_02;

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

        Button btnMain = findViewById(R.id.btn_main);
        btnMain.setOnClickListener(btnMainListener);
    }

    private Button.OnClickListener btnMainListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SecActivity.class);

            String name="Simon";
            int age=50;
            Double tall=177.5;

            Bundle bundle = new Bundle();
            bundle.putString("Name",name);
            bundle.putInt("AGE",age);
            bundle.putDouble("TALL",tall);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    };
}
