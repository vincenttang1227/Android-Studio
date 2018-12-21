package com.example.a10_g.a20181219_01;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {
    private ListView lvEdu;
    private List<Map<String, Object>> mapAry;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] icImg = {R.drawable.edu01, R.drawable.edu02, R.drawable.edu03,
                R.drawable.edu04, R.drawable.edu05, R.drawable.edu06};
        String[] stEduList = getResources().getStringArray(R.array.eduList);
        mapAry = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < stEduList.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imgView", icImg[i]);
            item.put("txtView", stEduList[i]);
            mapAry.add(item);
        }

        SimpleAdapter adEduList = new SimpleAdapter(this, mapAry,
                R.layout.list_item,
                new String[]{"imgView", "txtView"},
                new int[]{R.id.liIvEdu, R.id.liTvEdu});

        setListAdapter(adEduList);
        lvEdu = getListView();
        lvEdu.setTextFilterEnabled(true);
        lvEdu.setOnItemClickListener(lvListener);
    }

    private AdapterView.OnItemClickListener lvListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            msg = "您的教育程度為：\n";
            msg += ((TextView) view.findViewById(R.id.liTvEdu)).getText().toString();
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };
}
