package com.example.a10_g.a20181220_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;

    private int[] image = {R.drawable.ant_man, R.drawable.balck_panther, R.drawable.black_widow,
            R.drawable.captain_america, R.drawable.green_hulk, R.drawable.loki_god,
            R.drawable.spider_man, R.drawable.thor_god, R.drawable.vi_sion};

    private String[] imgText = {"Ant Man", "Black Panther", "Black Widow", "Captain America",
            "Hulk", "Loki", "Spider Man", "Thor", "Vision"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", image[i]);
            item.put("text", imgText[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.grid_item,
                new String[]{"image", "text"}, new int[]{R.id.item_img, R.id.item_text});

        gridView = findViewById(R.id.main_gridview);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "You choose: " + imgText[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
