package com.example.a10_g.a20181217_03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lvEdu;
    static String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildviews();
    }

    private void buildviews() {
        lvEdu = findViewById(R.id.lv_edu);
        ArrayAdapter <CharSequence> lvEduList = ArrayAdapter.createFromResource
                (this,R.array.edu,android.R.layout.simple_list_item_1);
        lvEdu.setAdapter(lvEduList);
        lvEdu.setOnItemClickListener(lvEduListener);
    }

    private ListView.OnItemClickListener lvEduListener = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            msg="您的教育程度為：";
            msg += ((TextView) view).getText().toString();
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    };
}