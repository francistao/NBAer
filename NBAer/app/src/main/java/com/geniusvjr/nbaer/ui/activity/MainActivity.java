package com.geniusvjr.nbaer.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.event.DrawerClickEvent;
import com.geniusvjr.nbaer.ui.activity.BaseActivity;
import com.geniusvjr.nbaer.ui.fragment.BlogFragment;
import com.geniusvjr.nbaer.ui.fragment.DrawerFragment;
import com.geniusvjr.nbaer.ui.fragment.GamesFragment;
import com.geniusvjr.nbaer.ui.fragment.MainFragment;
import com.geniusvjr.nbaer.ui.fragment.TeamSortFragment;
import com.geniusvjr.nbaer.ui.fragment.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {


    private DrawerFragment mNavigationFragment;
    private BaseFragment mCurrentFragment;
    private int mCurrentDrawId = R.string.news;

    private Map<String,BaseFragment> mBaseFragmentByName = new HashMap<>();
    private Map<Integer,String> mFragmentNameByDrawerId = new HashMap<>();




    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initViews() {

        getWindow().setBackgroundDrawable(null);
        mNavigationFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationFragment.setUp(findViewById(R.id.main_content), R.id.navigation_drawer,
                findViewById(R.id.main_drawer));
        initDrawerMap();
        mCurrentFragment = getFragment(mFragmentNameByDrawerId.get(R.string.news));
        transactionSupportFragment(mCurrentFragment);
    }

    private void initDrawerMap() {
        mFragmentNameByDrawerId.put(R.string.news, MainFragment.class.getName());
        mFragmentNameByDrawerId.put(R.string.blog,BlogFragment.class.getName());
        mFragmentNameByDrawerId.put(R.string.sort, TeamSortFragment.class.getName());
        mFragmentNameByDrawerId.put(R.string.gameDate, GamesFragment.class.getName());
    }

    private BaseFragment getFragment(String fragmentName){
        BaseFragment baseFragment = mBaseFragmentByName.get(fragmentName);
        if(mBaseFragmentByName.get(fragmentName) == null){
            try {
                baseFragment=(BaseFragment)Class.forName(fragmentName).newInstance();
            } catch (Exception e) {
//                baseFragment=MainFragment.newInstance();
            }

        }
        return baseFragment;
    }



    private void transactionSupportFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(mNavigationFragment.isDrawerOpen()){
            mNavigationFragment.closeDrawer();
        }else {
            finish();
        }
    }
}
