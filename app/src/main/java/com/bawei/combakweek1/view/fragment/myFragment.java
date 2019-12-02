package com.bawei.combakweek1.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.combakweek1.R;
import com.bawei.combakweek1.base.BaseFragment;
import com.bawei.combakweek1.contract.IMyContract;
import com.bawei.combakweek1.model.bean.Bean;
import com.bawei.combakweek1.presenter.MyPresenter;
import com.bawei.combakweek1.view.activity.MainActivity;
import com.bawei.combakweek1.view.adapter.MyAdapter;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:26
 *@Description:
 * */
public class myFragment extends BaseFragment implements IMyContract.IView {


    private GridView gv;
    private MyPresenter myPresenter;

    @Override
    protected void initData() {
        myPresenter = new MyPresenter();
        myPresenter.getMyData(this);

    }
    @Override
    protected void initView(View view) {
        gv = view.findViewById(R.id.gv);
    }

    @Override
    protected int layoutId() {
        return R.layout.myfragment;
    }

    @Override
    public void onMySuccess(Bean bean) {
        Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
        gv.setAdapter(new MyAdapter(bean.getData()));
    }

    @Override
    public void onMyFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
    }
}
