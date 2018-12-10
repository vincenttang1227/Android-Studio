package com.example.a10_g.a20181210;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.widget.Button.*;

public class MainActivity extends AppCompatActivity {

    private EditText etAge;
    private Spinner spinSex;
    private Button btnOk;
    private TextView tvSug;
    private String sexStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAge = findViewById(R.id.etAge);
        spinSex = findViewById(R.id.spinSex);
        btnOk = findViewById(R.id.btnOk);
        tvSug = findViewById(R.id.tvSug);

        btnOk.setOnClickListener(btnOkListener);
        spinSex.setOnItemSelectedListener(spinSexListener);
    }

    private Button.OnClickListener btnOkListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btnOk.getText().toString().equals("確定")) {
                btnOk.setText("重來");
                sexStr = spinSex.getSelectedItem().toString();
                int inputAge = Integer.parseInt(etAge.getText().toString());
                String sugStr = getString(R.string.suggest);

                if (sexStr.equals(getString(R.string.male))) {
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
                sexStr = spinSex.getSelectedItem().toString();
                etAge.setText("");
                tvSug.setText(R.string.suggest);
            }

        }
    };

    private Spinner.OnItemSelectedListener spinSexListener= new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sexStr = spinSex.getSelectedItem().toString();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


}
