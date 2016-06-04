package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.monkeyliu.tvshow.R;
import com.monkeyliu.tvshow.data.bean.Drama;
import com.monkeyliu.tvshow.utils.Constants;
import com.vlonjatg.progressactivity.ProgressActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListFragment extends LoadingFragment implements TvListContract.View {

	public static final int TYPE_ACTION = 0;
	public static final int TYPE_COMEDY = 1;
	public static final int TYPE_THRILLER = 1;
	public static final int TYPE_MAGIC = 1;
	public static final int TYPE_CRIME = 1;
	
	private int mType;
	private TvListAdapter mAdapter;
	private ArrayList<Drama> mData = new ArrayList<>();
	
	private TvListContract.Presenter mPresenter;
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new TvListPresenter(this);
	}

	public static TvListFragment newInstance(int type) {
		Bundle args = new Bundle();
		args.putInt(Constants.TV_TYPE, type);
		TvListFragment fragment = new TvListFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	protected void initViews() {
		super.initViews();
		mType = getArguments().getInt(Constants.TV_TYPE);
		mAdapter = new TvListAdapter(getContext(),mData);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
		mRecyclerView.setAdapter(mAdapter);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.addOnScrollListener(mOnScrollListener);
	}

	@Override
	public void onResume() {
		super.onResume();
		mPresenter.reloadData();
	}

	@Override
	public void onRefresh() {
		mPresenter.reloadData();
	}

	@Override
	public void setPresenter(TvListContract.Presenter presenter) {
		mPresenter = presenter;
	}

	@Override
	public void setLoadingIndicator(boolean active) {
		mSwipeRefreshLayout.setRefreshing(active);
	}

	@Override
	public void showLoadingError() {
		Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
		mProgressLayout.showError(drawable, "NoConnect", "Could not connect to our servers", "try agin", new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	}

	@Override
	public void showLoadingMore(boolean active) {
		mSwipeRefreshLayout.setRefreshing(active);
	}

	@Override
	public void fillData(ArrayList<Drama> data) {
		mAdapter.fillDataWithClear(data);
	}

	@Override
	public void appendData(ArrayList<Drama> data) {
		mAdapter.appendMoreData(data);
	}
	
	private int mLastVisibleItem;

	private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			super.onScrollStateChanged(recyclerView, newState);
			if(newState == RecyclerView.SCROLL_STATE_IDLE && mLastVisibleItem + 1 == mAdapter.getItemCount()){
				mPresenter.loadMoreData();
			}
		}

		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			super.onScrolled(recyclerView, dx, dy);
			mLastVisibleItem = ((LinearLayoutManager)recyclerView.getLayoutManager()).findLastVisibleItemPosition();
		}
	};
}
