package com.bawei.sqw_zhoukao2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bawei.sqw_zhoukao2.R;
import com.bawei.sqw_zhoukao2.bean.JiuBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 小哥 on 2018/11/12.
 */

public class JIuAadapter extends BaseAdapter{
    private Context context;
    private List<JiuBean.DataBean> list;

    public JIuAadapter(Context context, List<JiuBean.DataBean> list) {
        this.context = context;
        this.list = list;
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
        ViewHodel hodel = null;
        if (view == null){
            hodel = new ViewHodel();
            view = View.inflate(context, R.layout.img_layout,null);
            hodel.img = view.findViewById(R.id.ima);
            view.setTag(hodel);
        }else{
            hodel = (ViewHodel) view.getTag();
        }
        Glide.with(context).load(list.get(i).getIcon()).into(hodel.img);
        return view;
    }
    class ViewHodel{
        ImageView img;
    }
}
