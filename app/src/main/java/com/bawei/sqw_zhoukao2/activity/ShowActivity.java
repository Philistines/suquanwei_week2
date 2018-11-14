package com.bawei.sqw_zhoukao2.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.sqw_zhoukao2.R;
import com.bawei.sqw_zhoukao2.adapter.JIuAadapter;
import com.bawei.sqw_zhoukao2.adapter.ProductAdapter;
import com.bawei.sqw_zhoukao2.bean.JiuBean;
import com.bawei.sqw_zhoukao2.bean.Product;
import com.bawei.sqw_zhoukao2.home.presenter.HomePresenter;
import com.bawei.sqw_zhoukao2.home.view.IView;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements IView{

    private GridView grid_view;
    private RecyclerView recy_view;
    private HomePresenter presenter;
    private List<Product.DataBean> productList;
    private List<JiuBean.DataBean> jiuList;
    private ProductAdapter productAdapter;
    private JIuAadapter jiuAadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
        findViewById(R.id.img_src).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(ShowActivity.this,CaptureActivity.class),0);
            }
        });
    }

    private void initData() {
        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.getCatgory();
        presenter.getProduct();
        productList = new ArrayList<>();
        jiuList = new ArrayList<>();
        productAdapter = new ProductAdapter(this,productList);
        jiuAadapter = new JIuAadapter(this,jiuList);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recy_view.setLayoutManager(manager);
        grid_view.setAdapter(jiuAadapter);
        recy_view.setAdapter(productAdapter);
    }

    private void initView() {
        grid_view = findViewById(R.id.grid_view);
        recy_view = findViewById(R.id.recy_view);
    }

    @Override
    public void getCatgory(List<JiuBean.DataBean> list) {
        if (list != null){
            jiuList.clear();
            jiuList.addAll(list);
            jiuAadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getProduct(List<Product.DataBean> list) {
        if (list != null){
            productList.clear();
            productList.addAll(list);
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getcontext() {
        return this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
