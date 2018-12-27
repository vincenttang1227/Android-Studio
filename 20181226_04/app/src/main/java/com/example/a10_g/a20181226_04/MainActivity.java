package com.example.a10_g.a20181226_04;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db = null;
    //建立 table01資料表
    private final static String CREATE_TABLE =
            "CREATE TABLE table01(_id INTEGER PRIMARY KEY,name TEXT,price INTEGER)";

    ListView lvMain;
    Button btnSear, btnSearAll;
    EditText etResult;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etResult = findViewById(R.id.et_result);
        btnSear = findViewById(R.id.btn_sear);
        btnSearAll = findViewById(R.id.btn_searAll);
        lvMain = findViewById(R.id.lv_main);

        btnSear.setOnClickListener(myListener);
        btnSearAll.setOnClickListener(myListener);
        lvMain.setOnItemClickListener(lvMainListener);

        db = openOrCreateDatabase("db1.db", MODE_PRIVATE, null);
        try {
            db.execSQL(CREATE_TABLE);
            db.execSQL("INSERT INTO table01 (name,price) values ('香蕉',6)");
            db.execSQL("INSERT INTO table01 (name,price) values ('火龍果',80)");
            db.execSQL("INSERT INTO table01 (name,price) values ('梨子',120)");
            db.execSQL("INSERT INTO table01 (name,price) values ('水蜜桃',350)");
            db.execSQL("INSERT INTO table01 (name,price) values ('蘋果',25)");
        } catch (Exception e) {
        }
        cursor = getAll();
        UpdateAdapter(cursor);
    }

    private ListView.OnItemClickListener lvMainListener =
            new ListView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    cursor.moveToPosition(position);
                    Cursor c = get(id);
                    String s = "id=" + id + "\r\n" + "name=" + c.getString(1) + "\r\n" + "price=" + c.getInt(2);
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                }
            };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    private Button.OnClickListener myListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                switch (v.getId()) {
                    case R.id.btn_sear: {
                        long id = Integer.parseInt(etResult.getText().toString());
                        cursor = get(id);
                        UpdateAdapter(cursor);
                        break;
                    }
                    case R.id.btn_searAll: {
                        cursor = getAll();
                        UpdateAdapter(cursor);
                        break;
                    }
                }
            } catch (Exception err) {
                Toast.makeText(getApplicationContext(), "查無此資料", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void UpdateAdapter(Cursor cursor) {
        if (cursor != null && cursor.getCount() >= 0) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{"pname", "price"},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    0);
            lvMain.setAdapter(adapter);
        }
    }

    public Cursor getAll() {
        Cursor cursor = db.rawQuery("SELECT _id, _id||'.'||name pname,price FROM table01", null);
        return cursor;
    }

    public Cursor get(long rowId) throws SQLException {
        Cursor cursor = db.rawQuery("SELECT _id, _id||'.'||name pname,price FROM table01 WHERE _id=" + rowId, null);
        if (cursor.getCount() > 0)
            cursor.moveToFirst();
        else
            Toast.makeText(getApplicationContext(), "查無此筆資料！", Toast.LENGTH_SHORT).show();
        return cursor;
    }
}

