package com.bawei.combakweek1.presenter;

import com.bawei.combakweek1.contract.IMyContract;
import com.bawei.combakweek1.model.MyModel;
import com.bawei.combakweek1.model.bean.Bean;

import androidx.viewpager.widget.ViewPager;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:43
 *@Description:
 * */
public class MyPresenter {

    private MyModel myModel;

    public void getMyData(final IMyContract.IView iView){
        myModel = new MyModel();
        myModel.getMyData(new IMyContract.IModelCollBack() {
            @Override
            public void onMySuccess(Bean bean) {
                iView.onMySuccess(bean);
            }

            @Override
            public void onMyFailure(Throwable throwable) {
                iView.onMyFailure(throwable);
            }
        });
    }
}
