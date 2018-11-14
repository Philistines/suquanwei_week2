package com.bawei.sqw_zhoukao2.home.presenter;

import com.bawei.sqw_zhoukao2.bean.JiuBean;
import com.bawei.sqw_zhoukao2.bean.Product;
import com.bawei.sqw_zhoukao2.home.model.HomeModel;
import com.bawei.sqw_zhoukao2.home.view.IView;
import com.bawei.sqw_zhoukao2.net.ICallBack;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/11/12.
 */

public class HomePresenter {
    private IView iv;
    private HomeModel model;
    public void  attach(IView iv){
        this.iv = iv;
        model = new HomeModel();
    }
    public void getCatgory(){
        Type type = new TypeToken<JiuBean>() {
        }.getType();
        String url = "http://www.zhaoapi.cn/product/getCatagory";
        model.getData(url, new ICallBack() {
            @Override
            public void onsucces(Object object) {
                JiuBean jiuBean = (JiuBean) object;
                if(jiuBean != null){
                    iv.getCatgory(jiuBean.getData());
                }
            }

            @Override
            public void failed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void getProduct(){
        Type type = new TypeToken<Product>() {
        }.getType();
        String url = "http://www.wanandroid.com/tools/mockapi/6523/restaurants_offset_0_limit_4";
        model.getData(url, new ICallBack() {
            @Override
            public void onsucces(Object object) {
                Product product = (Product) object;
                if (product != null){
                    iv.getProduct(product.getData());
                }
            }

            @Override
            public void failed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
}
