package com.example.zzzhu.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class ZhihuFragment extends Fragment {

    private RecyclerView rv;
    private SwipeRefreshLayout srl;

    public ZhihuFragment(){}
    public static ZhihuFragment newInstance(){
        return new ZhihuFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        rv = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);
        srl = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        //设置下拉刷新的颜色
        srl.setColorSchemeResources(R.color.colorPrimary);
    }

}
