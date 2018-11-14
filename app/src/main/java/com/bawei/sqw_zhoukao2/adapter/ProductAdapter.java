package com.bawei.sqw_zhoukao2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.sqw_zhoukao2.R;
import com.bawei.sqw_zhoukao2.bean.Product;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 小哥 on 2018/11/12.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private Context context;
    private List<Product.DataBean> list;

    public ProductAdapter(Context context, List<Product.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getPic_url()).into(holder.img);
        holder.txtTitle.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView txtTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_view);
            txtTitle = itemView.findViewById(R.id.text_view);
        }
    }
}
