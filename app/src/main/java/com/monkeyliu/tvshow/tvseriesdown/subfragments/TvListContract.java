package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import com.monkeyliu.tvshow.BasePresenter;
import com.monkeyliu.tvshow.BaseView;
import com.monkeyliu.tvshow.data.bean.Drama;

import java.util.ArrayList;
import java.util.List;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public interface TvListContract {
	
	interface Presenter extends BasePresenter{
		void reloadData();
		void loadMoreData();
	}
	
	interface View extends BaseView<Presenter>{
		void setLoadingIndicator(boolean active);
		void showLoadingError();
		void showLoadingMore();
		void fillData(ArrayList<Drama> data);
		void appendData(ArrayList<Drama> data);
	}
	
}
