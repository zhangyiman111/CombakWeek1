package com.bawei.combakweek1.view.fragment;

import android.view.View;
import android.widget.Button;

import com.bawei.combakweek1.R;
import com.bawei.combakweek1.base.BaseFragment;
import com.bawei.combakweek1.view.activity.MainActivity;

/*
 *@auther:张奕漫
 *@Date: 2019/12/2
 *@Time:14:26
 *@Description:
 * */
public class newFragment extends BaseFragment {

    private Button button;

    @Override
    protected void initData() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.Data();
            }
        });
    }

    @Override
    protected void initView(View view) {

        button = view.findViewById(R.id.btn);
    }

    @Override
    protected int layoutId() {
        return R.layout.newfragment;
    }
}
