package com.example.a10_g.a20181217_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private ImageButton btnSci, btnPaper, btnStone;
    private ImageView ivCompGue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCompGue = findViewById(R.id.iv_compGue);
        tvResult = findViewById(R.id.tv_result);
        btnPaper = findViewById(R.id.btn_paper);
        btnSci = findViewById(R.id.btn_sci);
        btnStone = findViewById(R.id.btn_stone);

        btnPaper.setOnClickListener(btnPaperListener);
        btnStone.setOnClickListener(btnStoneListener);
        btnSci.setOnClickListener(btnSciListener);
    }

    private Button.OnClickListener btnPaperListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com = (int) (Math.random() * 3 + 1);

            //1-剪刀 2-石頭 3-布
            if (com == 1) {
                ivCompGue.setImageResource(R.drawable.scissor);
                tvResult.setText(getString(R.string.result) + getString(R.string.lose));
            } else if (com == 2) {
                ivCompGue.setImageResource(R.drawable.stone);
                tvResult.setText(getString(R.string.result) + getString(R.string.win));
            } else {
                ivCompGue.setImageResource(R.drawable.paper);
                tvResult.setText(getString(R.string.result) + getString(R.string.even));
            }
        }
    };

    private Button.OnClickListener btnStoneListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com = (int) (Math.random() * 3 + 1);

            //1-剪刀 2-石頭 3-布
            if (com == 1) {
                ivCompGue.setImageResource(R.drawable.scissor);
                tvResult.setText(getString(R.string.result) + getString(R.string.win));
            } else if (com == 2) {
                ivCompGue.setImageResource(R.drawable.stone);
                tvResult.setText(getString(R.string.result) + getString(R.string.even));
            } else {
                ivCompGue.setImageResource(R.drawable.paper);
                tvResult.setText(getString(R.string.result) + getString(R.string.lose));
            }
        }
    };

    private Button.OnClickListener btnSciListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            int com = (int) (Math.random() * 3 + 1);

            //1-剪刀 2-石頭 3-布
            if (com == 1) {
                ivCompGue.setImageResource(R.drawable.scissor);
                tvResult.setText(getString(R.string.result) + getString(R.string.even));
            } else if (com == 2) {
                ivCompGue.setImageResource(R.drawable.stone);
                tvResult.setText(getString(R.string.result) + getString(R.string.lose));
            } else {
                ivCompGue.setImageResource(R.drawable.paper);
                tvResult.setText(getString(R.string.result) + getString(R.string.win));
            }
        }
    };
}
