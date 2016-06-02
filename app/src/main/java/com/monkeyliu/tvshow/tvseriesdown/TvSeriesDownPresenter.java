package com.monkeyliu.tvshow.tvseriesdown;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvSeriesDownPresenter implements TvSeriesDownContract.Presenter {
	
	private TvSeriesDownContract.View mView;
	
	public TvSeriesDownPresenter(TvSeriesDownContract.View view){
		mView = view;
		mView.setPresenter(this);
	}
	
}
