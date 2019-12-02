package com.bawei.combakweek1.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.combakweek1.R;
import com.bawei.combakweek1.base.BaseFragment;
import com.bawei.combakweek1.util.NetUtli;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:26
 *@Description:
 * */
public class HomeFragment extends BaseFragment {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void initData() {

        if (NetUtli.getInstance().hasNet(getActivity())) {
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initView(View view) {
        textView = view.findViewById(R.id.tv);
        imageView = view.findViewById(R.id.iv);
    }

    @Override
    protected int layoutId() {
        return R.layout.homefragment;
    }
}
