package com.example.a10_g.a20181220_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] imgId = {R.drawable.a201806131842081, R.drawable.a201806131842082,
            R.drawable.a201806131842083, R.drawable.a201806131842084, R.drawable.a201806131842085,
            R.drawable.a201806131842086, R.drawable.a201806131842087, R.drawable.a201806131842088,
            R.drawable.a201806131842089, R.drawable.a2018061318420810, R.drawable.a2018061318420811,
            R.drawable.a2018061318420812, R.drawable.a2018061318420813, R.drawable.a2018061318420814,
            R.drawable.a2018061318420815, R.drawable.a2018061318420816, R.drawable.a2018061318420817,
            R.drawable.a2018061318420818, R.drawable.a2018061318420819, R.drawable.a2018061318420820,
            R.drawable.a2018061318420821, R.drawable.a2018061318420822, R.drawable.a2018061318420823,
            R.drawable.a2018061318420824, R.drawable.a2018061318420825, R.drawable.a2018061318420826,
            R.drawable.a2018061318420827, R.drawable.a2018061318420828, R.drawable.a2018061318420829,
            R.drawable.a2018061318420830, R.drawable.a2018061318420831, R.drawable.a2018061318420832,
            R.drawable.a2018061318420833};

    private String[] imgTxt = {"MORE THAN A HERO", "MORE THAN A SUIT", "MORE THAN A SHIELD",
            "MORE THAN A GOD", "MORE THAN A SECRET", "MORE THAN A MARKSMAN", "MORE THAN A TEMPER",
            "MORE THAN A MISSION", "MORE THAN A DOCTOR", "MORE THAN A KING",
            "MORE THAN A LEGENDARY OUTLAW", "MORE THAN A KID", "MORE THAN A TRICKSTER",
            "MORE THAN A THIEF", "MORE THAN A PARTNER", "MORE THAN A WINGMAN", "MORE THAN A SPY",
            "MORE THAN A TRAGIC PAST", "MORE THAN A MIND", "MORE THAN A FIGHTER",
            "MORE THAN A WEAPON", "MORE THAN A TRASH PANDA", "I AM A GROOT",
            "MORE THAN A DESTROYER", "MORE THAN A MACHINE", "MORE THAN A SENSATION",
            "MORE THAN A SWORD", "MORE THAN A WATCHFUL EYE", "MORE THAN A WARRIOR",
            "MORE THAN A GENIUS", "MORE THAN A BODYGUARD", "MORE THAN A LIBRARIAN",
            "MORE THAN A FRIEND OF DOUG'S"};

    private Button btnPrev, btnNext;
    private ImageView ivPhoto;
    private TextView tvPhoto;
    int p = 0;
    int count = imgId.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
        ivPhoto = findViewById(R.id.iv_photo);
        tvPhoto = findViewById(R.id.tv_photo);

        btnPrev.setOnClickListener(btnPrevListener);
        btnNext.setOnClickListener(btnNextListener);
    }

    private Button.OnClickListener btnPrevListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            p--;
            if (p < 0)
                p = count - 1;
            ivPhoto.setImageResource(imgId[p]);
            tvPhoto.setText(imgTxt[p]);
            setTitle("第" + (p + 1) + "/" + count);
        }
    };

    private Button.OnClickListener btnNextListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            p++;
            if (p == count)
                p = 0;
            ivPhoto.setImageResource(imgId[p]);
            tvPhoto.setText(imgTxt[p]);
            setTitle("第" + (p + 1) + "/" + count);
        }
    };
}
