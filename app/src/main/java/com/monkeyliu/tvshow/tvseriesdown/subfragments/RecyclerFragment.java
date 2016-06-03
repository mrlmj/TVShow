package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.monkeyliu.tvshow.BaseFragment;
import com.monkeyliu.tvshow.R;

import butterknife.Bind;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public abstract class RecyclerFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

	@Bind(R.id.data_recyclerview)
	RecyclerView mRecyclerView;
	@Bind(R.id.swipe_refresh_layout)
	SwipeRefreshLayout mSwipeRefreshLayout;
	
	@Override
	protected int getLayoutId() {
		return R.layout.fragment_recycler;
	}

	@Override
	protected void initViews() {
		mSwipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent);
		mSwipeRefreshLayout.setOnRefreshListener(this);
	}
}
