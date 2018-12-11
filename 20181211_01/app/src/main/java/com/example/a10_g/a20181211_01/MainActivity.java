package com.example.a10_g.a20181211_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinSex;
    private NumberPicker numPick;
    private Button btnOk;
    private TextView tvSug, numPickAge;
    private String sexStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinSex = findViewById(R.id.spinSex);
        numPick = findViewById(R.id.numPick);
        numPickAge = findViewById(R.id.numPickAge);
        btnOk = findViewById(R.id.btnOk);
        tvSug = findViewById(R.id.tvSug);

        numPickAge.setText(R.string.yourAge);
        numPick.setMinValue(1);
        numPick.setMaxValue(150);
        numPick.setValue(25);

        spinSex.setOnItemSelectedListener(spinSexListener);
        numPick.setOnValueChangedListener(numPickListener);
        btnOk.setOnClickListener(btnOkListener);
    }

    private Spinner.OnItemSelectedListener spinSexListener = new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sexStr = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private NumberPicker.OnValueChangeListener numPickListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            numPickAge.setText(getString(R.string.yourAge) + String.valueOf(newVal));
        }
    };

    private Button.OnClickListener btnOkListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int age = numPick.getValue();
            String strSug = getString(R.string.suggest);

            if (sexStr.equals(getString(R.string.male))) {
                if (age < 30)
                    strSug += getString(R.string.notHurry);
                else if (age > 35)
                    strSug += getString(R.string.getMarry);
                else
                    strSug += getString(R.string.startFinding);
            } else {
                if (age < 27)
                    strSug += getString(R.string.notHurry);
                else if (age > 32)
                    strSug += getString(R.string.getMarry);
                else
                    strSug += getString(R.string.startFinding);
            }
            tvSug.setText(strSug);
        }
    };
}