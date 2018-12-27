package com.example.a10_g.a20181227_01;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyDB db = null;

    Button btnAppend, btnEdit, btnDelete, btnClear;
    EditText etName, etPrice;
    ListView lvMain;
    Cursor cursor;
    long myid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);
        lvMain = findViewById(R.id.lv_main);
        btnAppend = findViewById(R.id.btn_append);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);
        btnClear = findViewById(R.id.btn_clear);

        btnAppend.setOnClickListener(myListener);
        btnEdit.setOnClickListener(myListener);
        btnDelete.setOnClickListener(myListener);
        btnClear.setOnClickListener(myListener);
        lvMain.setOnItemClickListener(lvMainListener);

        db = new MyDB(this);
        db.open();
        cursor = db.getAll();
        UpdateAdapter(cursor);
    }

    private ListView.OnItemClickListener lvMainListener =
            new ListView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    ShowData(id);
                    cursor.moveToPosition(position);
                }
            };

    private void ShowData(long id) {
        Cursor c = db.get(id);
        myid = id;
        etName.setText(c.getString(1));
        etPrice.setText("" + c.getInt(2));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    private Button.OnClickListener myListener = new Button.OnClickListener() {
        public void onClick(View v) {
            try {
                switch (v.getId()) {
                    case R.id.btn_append: {
                        int price = Integer.parseInt(etPrice.getText().toString());
                        String name = etName.getText().toString();
                        if (db.append(name, price) > 0) {
                            cursor = db.getAll();
                            UpdateAdapter(cursor);
                            ClearEdit();
                        }
                        break;
                    }
                    case R.id.btn_edit: {
                        int price = Integer.parseInt(etPrice.getText().toString());
                        String name = etName.getText().toString();
                        if (db.update(myid, name, price)) {
                            cursor = db.getAll();
                            UpdateAdapter(cursor);
                        }
                        break;
                    }
                    case R.id.btn_delete: {
                        if (cursor != null && cursor.getCount() >= 0) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("確定刪除");
                            builder.setMessage("確定要刪除" + etName.getText() + "這筆資料？");
                            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int i) {
                                }
                            });
                            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int i) {
                                    if (db.delete(myid)) {
                                        cursor = db.getAll();
                                        UpdateAdapter(cursor);
                                        ClearEdit();
                                    }
                                }
                            });
                            builder.show();
                        }
                        break;
                    }
                    case R.id.btn_clear: {
                        ClearEdit();
                        break;
                    }
                }
            } catch (Exception err) {
                Toast.makeText(getApplicationContext(), "資料不正確！", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void ClearEdit() {
        etName.setText("");
        etPrice.setText("");
    }

    public void UpdateAdapter(Cursor cursor) {
        if (cursor != null && cursor.getCount() >= 0) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{"name", "price"},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    0);
            lvMain.setAdapter(adapter);
        }
    }
}
