package com.bawei.sqw_zhoukao2.home.model;

import com.bawei.sqw_zhoukao2.net.HttpUtils;
import com.bawei.sqw_zhoukao2.net.ICallBack;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/11/12.
 */

public class HomeModel {

    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
