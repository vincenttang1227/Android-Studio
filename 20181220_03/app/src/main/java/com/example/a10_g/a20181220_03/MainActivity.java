package com.example.a10_g.a20181220_03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private ListView lstPrefer;
    private Button btnDo;

    String[] Balls = new String[]{"籃球", "足球", "棒球", "其他"};
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDo = findViewById(R.id.btn_do);
        txtResult = findViewById(R.id.tv_result);
        lstPrefer = findViewById(R.id.lv_prefer);

        // ListView必須建Adapter設定layout和接收圖片或文字的Array
        ArrayAdapter<String> adapterBalls = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, Balls);
        //設定ListView的選取模式(單選、複選。。。)
        lstPrefer.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //設定ListView的Adapter來源
        lstPrefer.setAdapter(adapterBalls);

        count = adapterBalls.getCount();

        btnDo.setOnClickListener(btnDoListener);
        lstPrefer.setOnItemClickListener(lstPreferListener);
    }

    private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strAll = "";

            for (int p = 0; p < count; p++) {
                if (lstPrefer.isItemChecked(p))
                    strAll += Balls[p] + " ";
            }
            txtResult.setText("我最喜歡的球類運動是 ：\n" + strAll);
        }
    };

    private ListView.OnItemClickListener lstPreferListener = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String str = parent.getItemAtPosition(position).toString();

            if (lstPrefer.isItemChecked(position)) {
                setTitle("目前選取： " + str);
            } else {
                setTitle("取消選取： " + str);
            }
        }
    };
}
