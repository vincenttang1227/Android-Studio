package com.example.a10_g.afinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
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
    private TextView tvMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        cbKalaBurger = findViewById(R.id.cb_kalaburger);
        cbBigmac = findViewById(R.id.cb_bigmac);
        cbDouble = findViewById(R.id.cb_doubleburg);
        cbMike = findViewById(R.id.cb_mikechicken);
        cbGeneral = findViewById(R.id.cb_generalchicken);
        cbCheese = findViewById(R.id.cb_cheesechicken);
        btnOk = findViewById(R.id.btn_ok);
        ivMenu = findViewById(R.id.iv_menu);
        tvMenu = findViewById(R.id.tv_menu);

        btnOk.setOnClickListener(btnOkListener);
        cbKalaBurger.setOnCheckedChangeListener(Listener);
        cbMike.setOnCheckedChangeListener(Listener);
        cbGeneral.setOnCheckedChangeListener(Listener);
        cbDouble.setOnCheckedChangeListener(Listener);
        cbCheese.setOnCheckedChangeListener(Listener);
        cbBigmac.setOnCheckedChangeListener(Listener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private CheckBox.OnCheckedChangeListener Listener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.cb_kalaburger:
                    ivMenu.setImageResource(R.drawable.kala);
                    tvMenu.setText(R.string.kala_chicken_burg);
                    break;
                case R.id.cb_bigmac:
                    ivMenu.setImageResource(R.drawable.bigmac);
                    tvMenu.setText(R.string.super_big_mac);
                    break;
                case R.id.cb_cheesechicken:
                    ivMenu.setImageResource(R.drawable.cheese);
                    tvMenu.setText(R.string.cheese_chicken);
                    break;
                case R.id.cb_doubleburg:
                    ivMenu.setImageResource(R.drawable.doubleb);
                    tvMenu.setText(R.string.double_burg);
                    break;
                case R.id.cb_generalchicken:
                    ivMenu.setImageResource(R.drawable.general);
                    tvMenu.setText(R.string.general_chicken);
                    break;
                case R.id.cb_mikechicken:
                    ivMenu.setImageResource(R.drawable.mike);
                    tvMenu.setText(R.string.mike_chicken);
                    break;
            }
        }
    };

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = getText(R.string.choose_food).toString();
            if (cbBigmac.isChecked()) {
                str += cbBigmac.getText().toString() + "\n";
            }
            if (cbCheese.isChecked()) {
                str += cbCheese.getText().toString() + "\n";
            }
            if (cbDouble.isChecked()) {
                str += cbDouble.getText().toString() + "\n";
            }
            if (cbGeneral.isChecked()) {
                str += cbGeneral.getText().toString() + "\n";
            }
            if (cbKalaBurger.isChecked()) {
                str += cbKalaBurger.getText().toString() + "\n";
            }
            if (cbMike.isChecked()) {
                str += cbMike.getText().toString() + "\n";
            }

            new AlertDialog.Builder(MenuActivity.this)
                    .setTitle("確認點餐內容")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage(str)
                    .setPositiveButton("送出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = Toast.makeText(MenuActivity.this, "點餐內容已送出", Toast.LENGTH_LONG);
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