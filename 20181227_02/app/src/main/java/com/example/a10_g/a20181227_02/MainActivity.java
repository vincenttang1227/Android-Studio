package com.example.a10_g.a20181227_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etCel;
    private Button btnConver, btnClear;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCel = findViewById(R.id.et_cel);
        btnConver = findViewById(R.id.btn_conver);
        btnClear = findViewById(R.id.btn_clear);
        tvResult = findViewById(R.id.tv_result);

        btnConver.setOnClickListener(btnConverListener);
        btnClear.setOnClickListener(btnClearListener);
    }

    private Button.OnClickListener btnConverListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            String str = getString(R.string.result);
            double celTemp = Double.parseDouble(etCel.getText().toString());
            double fahConver = (celTemp * 9 / 5) + 32;

            str += "\n" + getResources().getString(R.string.cel) + celTemp
                    + getResources().getString(R.string.degree) + " = "
                    + getResources().getString(R.string.fah) + fahConver
                    + getResources().getString(R.string.degree);

            tvResult.setText(str);
        }
    };

    private Button.OnClickListener btnClearListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            etCel.setText("");
            tvResult.setText(R.string.result);
        }
    };
}
