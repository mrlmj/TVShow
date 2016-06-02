package com.monkeyliu.tvshow.tvseriesdown;

import com.monkeyliu.tvshow.BaseFragment;
import com.monkeyliu.tvshow.R;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvSeriesDownFragment extends BaseFragment implements TvSeriesDownContract.View{
	
	public static final String TAG = "TvSeriesDown";
	
	private TvSeriesDownContract.Presenter mPresenter;
	
	@Override
	protected int getLayoutId() {
		return R.layout.fragment_tvseriesdown;
	}

	@Override
	protected void initViews() {

	}

	@Override
	public void setPresenter(TvSeriesDownContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
