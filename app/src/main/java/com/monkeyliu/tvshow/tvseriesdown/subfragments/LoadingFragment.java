package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.monkeyliu.tvshow.BaseFragment;
import com.monkeyliu.tvshow.R;
import com.vlonjatg.progressactivity.ProgressActivity;

import butterknife.Bind;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public abstract class LoadingFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

	@Bind(R.id.data_recyclerview)
	RecyclerView mRecyclerView;
	@Bind(R.id.swipe_refresh_layout)
	SwipeRefreshLayout mSwipeRefreshLayout;
	@Bind(R.id.progress_layout)
	ProgressActivity mProgressLayout;
	
	@Override
	protected int getLayoutId() {
		return R.layout.fragment_loading;
	}

	@Override
	protected void initViews() {
		mSwipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary,R.color.colorPrimaryDark,R.color.colorAccent);
		mSwipeRefreshLayout.setOnRefreshListener(this);
	}
}
