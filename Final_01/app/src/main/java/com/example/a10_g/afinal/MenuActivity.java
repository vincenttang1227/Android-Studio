package com.example.a10_g.afinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private CheckBox cbKalaBurger, cbBigmac, cbDouble, cbMike, cbGeneral, cbCheese;
    private Button btnOk;
    private ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        cbKalaBurger = findViewById(R.id.cb_kalaburger);
        cbBigmac = findViewById(R.id.cb_bigmac);
        cbDouble = findViewById(R.id.cb_doubleburg);
        cbMike = findViewById(R.id.cb_mikechicken);
        cbGeneral = findViewById(R.id.cb_generalchicken);
        cbCheese = findViewById(R.id.cb_cheesechicken);
        btnOk = findViewById(R.id.btn_ok);
        ivMenu = findViewById(R.id.iv_menu);

        btnOk.setOnClickListener(btnOkListener);
    }

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = getText(R.string.choose_food).toString();
            if (cbBigmac.isChecked()) {
                str += cbBigmac.getText().toString() + "\n";
                ivMenu.setImageResource(R.drawable.bigmac);
            }
            if (cbCheese.isChecked()){
                str += cbCheese.getText().toString() + "\n";
                ivMenu.setImageResource(R.drawable.cheese);
            }
            if (cbDouble.isChecked()){
                str += cbDouble.getText().toString() + "\n";
                ivMenu.setImageResource(R.drawable.doubleb);
            }
            if (cbGeneral.isChecked()){
                str += cbGeneral.getText().toString() + "\n";
                ivMenu.setImageResource(R.drawable.general);
            }
            if (cbKalaBurger.isChecked()){
                str += cbKalaBurger.getText().toString() + "\n";
                ivMenu.setImageResource(R.drawable.kala);
            }
            if (cbMike.isChecked()){
                str += cbMike.getText().toString() + "\n";
                ivMenu.setImageResource(R.drawable.mike);
            }

            new AlertDialog.Builder(MenuActivity.this)
                    .setTitle("確認點餐內容")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage(str)
                    .setPositiveButton("送出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(MenuActivity.this, "您的點餐內容已送出，稍後將為您送上", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 500);
                            toast.show();
                            finish();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
        }
    };
}