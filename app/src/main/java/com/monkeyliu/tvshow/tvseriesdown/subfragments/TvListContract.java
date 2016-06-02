package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import com.monkeyliu.tvshow.BasePresenter;
import com.monkeyliu.tvshow.BaseView;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public interface TvListContract {
	
	interface Presenter extends BasePresenter{
		void loadData();
		void loadMoreData();
	}
	
	interface View extends BaseView<Presenter>{
		void setLoadingIndicator(boolean active);
		void showLoadingError();
		void showLoadingMore();
	}
	
}
