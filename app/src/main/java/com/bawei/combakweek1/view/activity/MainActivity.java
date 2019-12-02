package com.bawei.combakweek1.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.combakweek1.R;
import com.bawei.combakweek1.base.BaseActivity;
import com.bawei.combakweek1.view.fragment.HomeFragment;
import com.bawei.combakweek1.view.fragment.myFragment;
import com.bawei.combakweek1.view.fragment.newFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ViewPager vp;
    private RadioGroup rg;
    ArrayList<Fragment> list = new ArrayList<>();
    @Override
    protected void initData() {
        list.add(new HomeFragment());
        list.add(new newFragment());
        list.add(new myFragment());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb01:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb02:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb03:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initView() {

        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
    public void Data(){
        vp.setCurrentItem(2);
    }
}
