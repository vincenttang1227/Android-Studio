package com.example.a10_g.a20181226_03;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    //宣告全域資料庫類別物件
    private SQLiteDatabase db = null;

    //建立資料表欄位
    private final static String CREATE_TABLE =
            "CREATE TABLE table01(_id INTEGER PRIMARY KEY,num INTERGER,data TEXT)";

    ListView listView01;
    Button btnDo;
    EditText etSQL;
    String str, itemdata;
    int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView01 = findViewById(R.id.lv_main);
        btnDo = findViewById(R.id.btn_do);
        etSQL = findViewById(R.id.et_sql);
        btnDo.setOnClickListener(btnDoListener);

        //預設SQL指令為新增資料
        itemdata = "資料項目" + n;
        str = "INSERT INTO table01 (num,data) values (" + n + ",'" + itemdata + "')";
        etSQL.setText(str);

        //建立資料庫，若資料庫已存在，則將之開啟
        db = openOrCreateDatabase("db1.db", MODE_PRIVATE, null);
        try {
            db.execSQL(CREATE_TABLE); //建立資料表
        } catch (Exception e) {
            UpdateAdapter(); //載入資料表至ListView
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //刪除原有資料表，每次執行時，讓資料表都是空的
        db.execSQL("DROP TABLE table01");
        db.close();
    }

    private Button.OnClickListener btnDoListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                db.execSQL(etSQL.getText().toString()); //執行SQL
                UpdateAdapter();
                n++;
                itemdata = "資料項目" + n;
                str = "INSERT INTO table01 (num,data) values (" + n + ",'" + itemdata + "')";
                etSQL.setText(str);
                setTitle("資料新增完畢！");
            } catch (Exception err) {
                setTitle("SQL 語法錯誤！");
            }
        }
    };

    public void UpdateAdapter() {
        Cursor cursor = db.rawQuery("SELECT * FROM table01", null);
        if (cursor != null && cursor.getCount() >= 0) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2, //包含兩個資料項
                    cursor, //資料庫的Cursors物件
                    new String[]{"num", "data"}, //num、data欄位
                    new int[]{android.R.id.text1, android.R.id.text2}, //與num、data對應的元件
                    0); //adapter行為最佳化
            listView01.setAdapter(adapter);
        }
    }
}
