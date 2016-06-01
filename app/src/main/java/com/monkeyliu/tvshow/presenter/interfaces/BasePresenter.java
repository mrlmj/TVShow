package com.monkeyliu.tvshow.presenter.interfaces;

/**
 * @author monkey
 * @brief
 * @date 2016/6/1 0001.
 */
public abstract class BasePresenter<V> {
	protected V mView;
	
	public void attach(V view){
		mView = view;
	}
	
	public void dettach(){
		mView = null;
	}
}
