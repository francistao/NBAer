package com.geniusvjr.nbaer.ui.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.bruce.pickerview.popwindow.DatePickerPopWin;
import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.app.AppService;
import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.event.GamesEvent;
import com.geniusvjr.nbaer.model.Games;
import com.geniusvjr.nbaer.ui.adapter.RecycleAdapter.GamesAdapter;
import com.geniusvjr.nbaer.ui.fragment.base.SwipeRefreshBaseFragment;
import com.geniusvjr.nbaer.utils.DateFormatter;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by dream on 16/5/3.
 */
public class GamesFragment extends SwipeRefreshBaseFragment{

    @Bind(R.id.rv_news)
    RecyclerView mGamesListView;
    private GamesAdapter mGamesAdapter;

    private String mDate;
    private String mDateToday = DateFormatter.formatDate("yyyy-MM-dd");
    private List<Games.GamesEntity> mGamesEntity = new ArrayList<>();

    public static GamesFragment newInstance(){
        GamesFragment gamesFragment = new GamesFragment();
        return gamesFragment;
    }


    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mGamesListView.getContext());
        mGamesListView.setLayoutManager(linearLayoutManager);
        mGamesAdapter = new GamesAdapter(getActivity(), mGamesEntity);
        mGamesListView.setAdapter(mGamesAdapter);
        mDate = mDateToday;
        setRefreshing();
    }

    public void onEventMainThread(GamesEvent gamesEvent){
        stopRefreshing();
        if(Constant.Result.FAIL.equals(gamesEvent.getEventResult())){
            return;
        }
        mGamesEntity.clear();
        mGamesEntity.addAll(gamesEvent.getAllGames().getGames());
        mGamesAdapter.notifyDataSetChanged();
    }
    @Override
    public void onRefresh() {
        AppService.getInstance().getGames(getTaskId(), mDate);
        mDate = mDateToday;
    }

    @Override
    protected int getTitle() {
        return R.string.gameDate;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_date, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.date:
                chooseDate();
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void chooseDate() {
        if(isRefreshing()){
            return;
        }
        DatePickerPopWin datePicker = new DatePickerPopWin.Builder(getActivity(), new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                mDate = dateDesc;
                setRefreshing();
            }
        }).colorConfirm(Color.parseColor("#448AFF"))
                .minYear(2015)
                .maxYear(2017)
                .build();
        datePicker.showPopWin(getActivity());



    }
}
