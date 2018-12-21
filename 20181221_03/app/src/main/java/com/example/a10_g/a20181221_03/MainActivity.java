package com.example.a10_g.a20181221_03;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tvMain;
    private Button btn1,btn2,btn3;
    private Button btn4,btn5,btn6;
    private Button btn7,btn8,btn9;
    private Button btnCls, btn0, btnOk,btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tv_main);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnCls = findViewById(R.id.btn_cls);
        btnOk = findViewById(R.id.btn_ok);
        btnEnd = findViewById(R.id.btn_end);

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btn0.setOnClickListener(listener);
        btnCls.setOnClickListener(listener);
        btnOk.setOnClickListener(listener);
        btnEnd.setOnClickListener(listener);
    }

    private Button.OnClickListener listener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_1:
                    displayATM("1");
                    break;
                case R.id.btn_2:
                    displayATM("2");
                    break;
                case R.id.btn_3:
                    displayATM("3");
                    break;
                case R.id.btn_4:
                    displayATM("4");
                    break;
                case R.id.btn_5:
                    displayATM("5");
                    break;
                case R.id.btn_6:
                    displayATM("6");
                    break;
                case R.id.btn_7:
                    displayATM("7");
                    break;
                case R.id.btn_8:
                    displayATM("8");
                    break;
                case R.id.btn_9:
                    displayATM("9");
                    break;
                case R.id.btn_0:
                    displayATM("0");
                    break;
                case R.id.btn_cls:
                    String str = tvMain.getText().toString();
                    if(str.length()>0){
                        str = str.substring(0,str.length()-1);
                        tvMain.setText(str);
                    }
                    break;
                case  R.id.btn_ok:
                    str = tvMain.getText().toString();
                    if(str.equals("123456")) {
                        Toast toast = Toast.makeText(MainActivity.this,"密碼正確，歡迎使用提款功能！",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                    else {
                        Toast toast = Toast.makeText(MainActivity.this,"密碼錯誤，請重新輸入！",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,0,50);
                        toast.show();
                        tvMain.setText("");
                    }
                    break;
                case R.id.btn_end:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("確認視窗")
                            .setIcon(R.mipmap.ic_launcher)
                            .setMessage("確定要結束應用程式嗎？")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                    break;


            }
        }
    };

    private void displayATM(String s) {
        String str = tvMain.getText().toString();
        tvMain.setText(str + s);
    }
}
