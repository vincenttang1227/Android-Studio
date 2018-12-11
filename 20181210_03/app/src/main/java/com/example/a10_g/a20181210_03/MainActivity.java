package com.example.a10_g.a20181210_03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 宣告物件變數
    private RadioGroup rgSex, rgAge;
    private RadioButton rbAgeS, rbAgeM, rbAgeL;
    private TextView tvSug;
    private Button btnOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 將各版面元件id指定給對應的物件變數
        rgSex = findViewById(R.id.rgSex);
        rgAge = findViewById(R.id.rgAge);
        rbAgeS = findViewById(R.id.rbAgeS);
        rbAgeM = findViewById(R.id.rbAgeM);
        rbAgeL = findViewById(R.id.rbAgeL);
        btnOk = findViewById(R.id.btnOk);
        tvSug = findViewById(R.id.tvSug);

        // 登錄按鈕元件的事件監聽
        btnOk.setOnClickListener(btnOkListener);

        // 登錄單選鈕群組元件的事件監聽
        rgSex.setOnCheckedChangeListener(rgSexListener);

    }

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        //按鈕事件處理方法
        public void onClick(View v) {
            String strSug = getString(R.string.suggest);

            switch (rgAge.getCheckedRadioButtonId()) {
                case R.id.rbAgeS:
                    strSug += getString(R.string.notHurry);
                    break;
                case R.id.rbAgeM:
                    strSug += getString(R.string.startFinding);
                    break;
                case R.id.rbAgeL:
                    strSug += getString(R.string.getMarry);
                    break;
            }
            tvSug.setText(strSug);
        }
    };


    private RadioGroup.OnCheckedChangeListener rgSexListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int i) {
            /*
            當單選鈕選項改變時取得的id索引等於男性時，
            就將年齡的顯示設定為男性的年齡資料，否則設定為女性的年齡資料
             */
            if (i == R.id.rbMale) {
                rbAgeS.setText(getString(R.string.maleAgeS));
                rbAgeM.setText(getString(R.string.maleAgeM));
                rbAgeL.setText(getString(R.string.maleAgeL));
            } else {
                rbAgeS.setText(getString(R.string.femaleAgeS));
                rbAgeM.setText(getString(R.string.femaleAgeM));
                rbAgeL.setText(getString(R.string.femaleAgeL));
            }

        }
    };
}