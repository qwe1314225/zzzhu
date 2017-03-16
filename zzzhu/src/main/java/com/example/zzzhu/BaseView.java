package com.example.zzzhu;

import android.view.View;

/**
 * ---------------------------------------------
 * Created by small-star-star on 2017/3/11.
 * 纸上得来终觉浅
 * ---------------------------------------------
 */

public interface BaseView<T> {
    //为view设置presenter
    void setPresenter(T presenter);
    //初始化界面布局
    void initView(View view);


}
