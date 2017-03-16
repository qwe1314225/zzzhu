package com.example.zzzhu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zzzhu.homepage.MainFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout dl;
    private NavigationView nvView;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        if(savedInstanceState !=null ){
            mainFragment = (MainFragment) getSupportFragmentManager().getFragment(savedInstanceState,"MainFragment");
        }else {
            mainFragment = MainFragment.newInstance();
        }
        if(mainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(mainFragment,"MainFragment").commit();
        }

        showMainFragment();
    }

    /**
     * 初始化控件，toolbar，drawerlayout，navigationview
     */
    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dl = (DrawerLayout) findViewById(R.id.activity_drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,dl,toolbar,R.string.open_drawer,R.string.close_drawer);
        dl.setDrawerListener(toggle);
        toggle.syncState();

        nvView = (NavigationView) findViewById(R.id.nv_view);
        nvView.setNavigationItemSelectedListener(this);


    }

    /**
     * 抽屉布局中的item被点击后
     * @param item 被点击的条目
     * @return
     */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //关闭侧边栏
        dl.closeDrawer(GravityCompat.START);
        //根据被点击的条目，显示相应的布局
        int id = item.getItemId();
        switch (id){
            case R.id.nv_main:
                showMainFragment();
                break;
            case R.id.nv_about:
                break;
            case R.id.nv_setting:
                break;
            case R.id.nv_change:
                break;
            case R.id.nv_collection:
                showCollectionFragment();
                break;
        }
        return true;
    }

    /**
     * 显示收藏界面的布局
     */
    private void showCollectionFragment() {

    }


    /**
     * 显示主页面布局
     */
    private void showMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(mainFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("知乎日报");
    }
}
