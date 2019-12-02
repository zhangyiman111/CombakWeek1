package com.bawei.combakweek1.contract;

import com.bawei.combakweek1.model.bean.Bean;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:43
 *@Description:
 * */
public interface IMyContract {
    interface IView{
        void onMySuccess(Bean bean);
        void onMyFailure(Throwable throwable);
    }
    interface IModelCollBack{
        void onMySuccess(Bean bean);
        void onMyFailure(Throwable throwable);
    }
}
