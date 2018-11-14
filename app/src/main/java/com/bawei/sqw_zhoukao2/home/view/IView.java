package com.bawei.sqw_zhoukao2.home.view;

import android.content.Context;

import com.bawei.sqw_zhoukao2.bean.JiuBean;
import com.bawei.sqw_zhoukao2.bean.Product;

import java.util.List;

/**
 * Created by 小哥 on 2018/11/12.
 */

public interface IView {

    void getCatgory(List<JiuBean.DataBean> list);

    void getProduct(List<Product.DataBean> list);

    void failed(Exception e);

    Context getcontext();
}
