package com.example.test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!= null) {
            actionBar.hide();
        }

        //绑定
        listView = findViewById(R.id.main_list_view);
        //数据源
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_launcher_foreground);
        map.put("name", "android");
        map.put("sex", "sex: unknown");
        map.put("age", "age:unknown");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_launcher_background);
        map.put("name", "Young");
        map.put("sex", "sex: male");
        map.put("age", "age:18");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_launcher_foreground);
        map.put("name", "BlackDn");
        map.put("sex", "sex: male");
        map.put("age", "age:21");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("logo", R.drawable.ic_launcher_background);
        map.put("name", "Lily");
        map.put("sex", "sex: female");
        map.put("age", "age:16");
        list.add(map);

        //适配器
//        String[] from = new String[] {"logo", "name", "sex", "age"};
//        int[] to = new int[] {R.id.item_logo, R.id.item_name, R.id.item_sex, R.id.item_age};
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.item, from, to);
//        // 简便写法
//        // SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.item, new String[] {"logo", "name", "sex", "age"}, new int[] {R.id.item_logo});
//
//

        MyAdapter myAdapter = new MyAdapter(this);
        myAdapter.setList(list);
        //关联
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(this, "点击了：" + i, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("title")
                .setMessage("message")
                .setNegativeButton("no", null)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "toast text", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
        return false;   //不消化，向下传递
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle("title")
                .setMessage("quit?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("no", null)
                .show();
    }

}