package com.monkeyliu.tvshow.tvseries;

import com.monkeyliu.tvshow.BasePresenter;
import com.monkeyliu.tvshow.BaseView;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public interface MainContract {
	
	interface View extends BaseView<Presenter>{
		
	}
	
	interface Presenter extends BasePresenter{
		void switchPage(int itemId);
		void exit();
	}
	
}
