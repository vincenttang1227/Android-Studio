package com.example.administrator.a20181203_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvSug;
    private EditText etSex, etAge;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSex = findViewById(R.id.etSex);
        etAge = findViewById(R.id.etAge);
        btnOk = findViewById(R.id.btnOk);
        tvSug = findViewById(R.id.tvSug);
    }

    public void btnOnClick(View view) {
        if (btnOk.getText().toString().equals("確定")) {
            btnOk.setText("重來");
            String inputSex = etSex.getText().toString();
            int inputAge = Integer.parseInt(etAge.getText().toString());
            String sugStr = getString(R.string.suggest);

            if (inputSex.equals(getString(R.string.male))) {
                if (inputAge < 30)
                    sugStr += getString(R.string.notHurry);
                else if (inputAge > 35)
                    sugStr += getString(R.string.getMarry);
                else
                    sugStr += getString(R.string.startFinding);
            } else {
                if (inputAge < 27)
                    sugStr += getString(R.string.notHurry);
                else if (inputAge > 32)
                    sugStr += getString(R.string.getMarry);
                else
                    sugStr += getString(R.string.startFinding);
            }
            tvSug.setText(sugStr);
        } else {
            btnOk.setText("確定");
            etSex.setText("");
            etAge.setText("");
            tvSug.setText(R.string.suggest);
        }
    }
}