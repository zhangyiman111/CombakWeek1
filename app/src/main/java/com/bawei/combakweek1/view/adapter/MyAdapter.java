package com.bawei.combakweek1.view.adapter;

import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.combakweek1.R;
import com.bawei.combakweek1.base.BaseActivity;
import com.bawei.combakweek1.model.bean.Bean;
import com.bawei.combakweek1.util.NetUtli;

import java.util.List;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:56
 *@Description:
 * */
public class MyAdapter extends BaseAdapter {
    private List<Bean.DataBean> list;

    public MyAdapter(List<Bean.DataBean> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView = View.inflate(parent.getContext(), R.layout.item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.img);
            holder.textView = convertView.findViewById(R.id.tv_my);
            convertView .setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Bean.DataBean dataBean = list.get(position);
        String name = dataBean.getGoods_name();
        holder.textView.setText(name);
        NetUtli.getInstance().getphoto(dataBean.getGoods_thumb(),holder.imageView);
        return convertView;
    }
    private class ViewHolder{
        private ImageView imageView;
        private TextView textView;
    }
}
