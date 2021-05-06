package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {
    //存放数据的变量
    List<Map<String, Object>> list;
    //布局服务
    LayoutInflater inflater;

    //setter
    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    //构造方法
    public MyAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null) {
            view = inflater.inflate(R.layout.item,null);
            holder = new ViewHolder(view);
//            holder.logo = view.findViewById(R.id.item_logo);
//            holder.name = view.findViewById(R.id.item_name);
//            holder.sex = view.findViewById(R.id.item_sex);
//            holder.age = view.findViewById(R.id.item_age);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Map map = list.get(i);
        holder.logo.setImageResource((Integer) map.get("logo"));
        holder.name.setText((String) map.get("name"));
        holder.sex.setText((String) map.get("sex"));
        holder.age.setText((String) map.get("age"));

        return view;
    }

    public class ViewHolder{
        ImageView logo;
        TextView name;
        TextView sex;
        TextView age;

        ViewHolder(View view) {
            this.logo = view.findViewById(R.id.item_logo);
            this.name = view.findViewById(R.id.item_name);
            this.sex = view.findViewById(R.id.item_sex);
            this.age = view.findViewById(R.id.item_age);
        }
    }
}
