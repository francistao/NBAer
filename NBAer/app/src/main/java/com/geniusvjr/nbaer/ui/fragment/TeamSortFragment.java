package com.geniusvjr.nbaer.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.geniusvjr.nbaer.R;
import com.geniusvjr.nbaer.app.AppService;
import com.geniusvjr.nbaer.data.Constant;
import com.geniusvjr.nbaer.event.TeamSortEvent;
import com.geniusvjr.nbaer.model.Teams;
import com.geniusvjr.nbaer.ui.adapter.RecycleAdapter.TeamSortAdapter;
import com.geniusvjr.nbaer.ui.fragment.base.SwipeRefreshBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by dream on 16/5/3.
 */
public class TeamSortFragment extends SwipeRefreshBaseFragment{

    @Bind(R.id.rv_news)
    RecyclerView mTeamListView;
    private TeamSortAdapter mTeamSortAdapter;
    protected List<Teams.TeamsortEntity> mTeamsSortEntity = new ArrayList<>();

    public static TeamSortFragment newInstance(){
        TeamSortFragment teamSortFragment = new TeamSortFragment();
        return teamSortFragment;
    }


    @Override
    protected void initViews() {
        super.initViews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                mTeamListView.getContext()
        );
        mTeamListView.setLayoutManager(linearLayoutManager);
        mTeamSortAdapter = new TeamSortAdapter(getActivity(), mTeamsSortEntity);
        mTeamListView.setAdapter(mTeamSortAdapter);
        setRefreshing();
    }

    @Override
    public void onRefresh() {
        AppService.getInstance().getTeamSort(getTaskId());
    }

    public void onEventMainThread(TeamSortEvent teamSortEvent){
        stopRefreshing();
        if(Constant.Result.FAIL.equals(teamSortEvent.getEventResult())){
            return;
        }
        mTeamsSortEntity.clear();
        mTeamsSortEntity.addAll(teamSortEvent.getmTeams().getTeamsort());
        mTeamListView.setAdapter(mTeamSortAdapter);
        setRefreshing();
    }
    @Override
    protected int getTitle() {
        return R.string.sort;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_main;
    }
}
