package com.bawei.combakweek1.model;

import com.bawei.combakweek1.contract.IMyContract;
import com.bawei.combakweek1.model.bean.Bean;
import com.bawei.combakweek1.util.NetUtli;
import com.google.gson.Gson;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:43
 *@Description:
 * */
public class MyModel {
    public void getMyData(final IMyContract.IModelCollBack iModelCollBack){
        NetUtli.getInstance().getdata("http://blog.zhaoliang5156.cn/api/shop/shop1.json", new NetUtli.MyCollBack() {
            @Override
            public void getJson(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCollBack.onMySuccess(bean);
            }

            @Override
            public void onErratic(Throwable throwable) {
                iModelCollBack.onMyFailure(throwable);
            }
        });
    }
}
