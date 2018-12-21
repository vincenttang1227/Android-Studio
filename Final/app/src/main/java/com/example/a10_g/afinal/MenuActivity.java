package com.example.a10_g.afinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MenuActivity extends AppCompatActivity {

    private CheckBox cbKalaBurger, cbBigmac, cbDouble, cbMike, cbGeneral, cbCheese;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cbKalaBurger = findViewById(R.id.cb_kalaburger);
        cbBigmac = findViewById(R.id.cb_bigmac);
        cbDouble = findViewById(R.id.cb_doubleburg);
        cbMike = findViewById(R.id.cb_mikechicken);
        cbGeneral = findViewById(R.id.cb_generalchicken);
        cbCheese = findViewById(R.id.cb_cheesechicken);

        btnOk.setOnClickListener(btnOkListener);

    }

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = "您的點餐內容為：";
            if(cbKalaBurger.isChecked())
                str += cbKalaBurger.getText().toString();
            if(cbBigmac.isChecked())
                str += cbBigmac.getText().toString();
            if(cbDouble.isChecked())
                str += cbDouble.getText().toString();
            if(cbMike.isChecked())
                str += cbMike.getText().toString();
            if(cbGeneral.isChecked())
                str += cbGeneral.getText().toString();
            if(cbCheese.isChecked())
                str += cbCheese.getText().toString();

            new AlertDialog.Builder(MenuActivity.this)
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
        }
    };
}
