package com.geniusvjr.nbaer.ui.fragment.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.geniusvjr.nbaer.R;

import butterknife.Bind;

/**
 * Created by dream on 16/4/30.
 */
public abstract class ToorbarBaseFragment extends BaseFragment{

    protected Toolbar mToolBar;

    protected  abstract int getTitle();

    @Override
    protected void initViews() {
        initToolbar();
        setHasOptionsMenu(true);
    }

    private void initToolbar() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolBar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getTitle());
        mToolBar.setNavigationIcon(R.mipmap.ic_menu_white);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.about:

                break;
            case R.id.setting:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
