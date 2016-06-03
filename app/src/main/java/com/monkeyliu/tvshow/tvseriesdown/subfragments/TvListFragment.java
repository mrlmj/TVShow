package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.monkeyliu.tvshow.data.bean.Drama;
import com.monkeyliu.tvshow.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListFragment extends RecyclerFragment implements TvListContract.View {

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

	}

	@Override
	public void showLoadingMore() {

	}

	@Override
	public void fillData(ArrayList<Drama> data) {
		mAdapter.fillDataWithClear(data);
	}

	@Override
	public void appendData(ArrayList<Drama> data) {

	}
}
