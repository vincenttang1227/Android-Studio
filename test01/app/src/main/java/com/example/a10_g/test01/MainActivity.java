package com.example.a10_g.test01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //宣告物件變數
    private TextView tv1;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //將版面元件 id指定給物件變數
        tv1 = findViewById(R.id.tv1);
        btn = findViewById(R.id.btn);
        //設定按鈕監聽，監聽事件名稱 btnListener事件名稱可自訂
        btn.setOnClickListener(btnListener);
    }

    //    建立btnListener事件監聽的內容
    private Button.OnClickListener btnListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tv1.getText()=="This is my first Android Project.")
                tv1.setText("你按到按鈕了");
            else
                tv1.setText("This is my first Android Project.");
        }
    };
}