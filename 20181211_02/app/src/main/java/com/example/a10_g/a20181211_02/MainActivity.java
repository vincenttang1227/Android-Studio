package com.example.a10_g.a20181211_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbMusic, cbSing, cbDance, cbTravel, cbRead, cbWrite, cbClimb, cbSwim, cbSport,
            cbFit, cbPhoto, cbFood, cbDraw;
    private Button btnOk;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbMusic = findViewById(R.id.cbMusic);
        cbSing = findViewById(R.id.cbSing);
        cbDance = findViewById(R.id.cbDance);
        cbTravel = findViewById(R.id.cbTravel);
        cbRead = findViewById(R.id.cbRead);
        cbWrite = findViewById(R.id.cbWrite);
        cbClimb = findViewById(R.id.cbClimb);
        cbSport = findViewById(R.id.cbSport);
        cbFit = findViewById(R.id.cbFit);
        cbPhoto = findViewById(R.id.cbPhoto);
        cbFood = findViewById(R.id.cbFood);
        cbDraw = findViewById(R.id.cbDraw);
        cbSwim = findViewById(R.id.cbSwim);
        btnOk = findViewById(R.id.btnOk);
        tvResult = findViewById(R.id.tvResult);

        btnOk.setOnClickListener(btnOkListener);
    }

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = getString(R.string.yourHobby);
            if (btnOk.getText().equals(getString(R.string.ok))) {
                btnOk.setText(R.string.reset);
                if (cbClimb.isChecked())
                    str += cbClimb.getText().toString();
                if (cbMusic.isChecked())
                    str += cbMusic.getText().toString();
                if (cbSing.isChecked())
                    str += cbSing.getText().toString();
                if (cbDance.isChecked())
                    str += cbDance.getText().toString();
                if (cbTravel.isChecked())
                    str += cbTravel.getText().toString();
                if (cbRead.isChecked())
                    str += cbRead.getText().toString();
                if (cbWrite.isChecked())
                    str += cbWrite.getText().toString();
                if (cbSport.isChecked())
                    str += cbSport.getText().toString();
                if (cbFit.isChecked())
                    str += cbFit.getText().toString();
                if (cbPhoto.isChecked())
                    str += cbPhoto.getText().toString();
                if (cbFood.isChecked())
                    str += cbFood.getText().toString();
                if (cbDraw.isChecked())
                    str += cbDraw.getText().toString();
                if (cbSwim.isChecked())
                    str += cbSwim.getText().toString();
                tvResult.setText(str);
            } else {
                cbClimb.setChecked(false);
                cbMusic.setChecked(false);
                cbSing.setChecked(false);
                cbDance.setChecked(false);
                cbTravel.setChecked(false);
                cbRead.setChecked(false);
                cbWrite.setChecked(false);
                cbSport.setChecked(false);
                cbFit.setChecked(false);
                cbPhoto.setChecked(false);
                cbFood.setChecked(false);
                cbDraw.setChecked(false);
                cbSwim.setChecked(false);
                btnOk.setText(R.string.ok);
                tvResult.setText(R.string.yourHobby);
            }
        }
    };
}
