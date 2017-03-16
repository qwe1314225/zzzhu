package com.example.zzzhu.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zzzhu.R;

/**
 * ---------------------------------------------
 * Created by small-star-star on 2017/3/14.
 * 纸上得来终觉浅
 * ---------------------------------------------
 */

public class MainFragment extends Fragment {

    private Context context;
    private ZhihuFragment zhihuFragment;
    private TabLayout tb;

    //构造器
    public MainFragment(){
    }

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();

        if(savedInstanceState!=null){
            FragmentManager manager = getChildFragmentManager();
            zhihuFragment= (ZhihuFragment) manager.getFragment(savedInstanceState, "zhihu");
        }else{
            zhihuFragment = ZhihuFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        initView(view);
        tb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private void initView(View view) {
        ViewPager vp = (ViewPager) view.findViewById(R.id.vp_main_fragment);
        tb = (TabLayout) view.findViewById(R.id.tl_main_fragment);

    }
}
