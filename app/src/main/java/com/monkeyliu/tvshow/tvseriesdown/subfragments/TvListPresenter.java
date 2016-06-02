package com.monkeyliu.tvshow.tvseriesdown.subfragments;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListPresenter implements TvListContract.Presenter {
	
	private TvListContract.View mView;
	
	public TvListPresenter(TvListContract.View view){
		mView = view;
		mView.setPresenter(this);
	}
	
	@Override
	public void loadData() {
		
	}

	@Override
	public void loadMoreData() {

	}
}
