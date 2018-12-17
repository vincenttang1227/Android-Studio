package com.example.a10_g.a20181217_02;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);

        ArrayAdapter<CharSequence> adapteredu =
                ArrayAdapter.createFromResource(this, R.array.edu,
                        android.R.layout.simple_list_item_1);

        setListAdapter(adapteredu);

        ListView lst = getListView();

        lst.setOnItemClickListener(lstvieweduListener);
    }

    private ListView.OnItemClickListener lstvieweduListener = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tvResult.setText("您的教育程度是："+((TextView) view).getText());
        }
    };
}
