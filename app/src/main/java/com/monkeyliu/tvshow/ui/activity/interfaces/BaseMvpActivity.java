package com.monkeyliu.tvshow.ui.activity.interfaces;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.monkeyliu.tvshow.presenter.interfaces.BasePresenter;

/**
 * @author monkey
 * @brief
 * @date 2016/6/1 0001.
 */
public abstract class BaseMvpActivity<V,P extends BasePresenter<V>> extends BaseActivity{
	protected P mPresenter;

	@Override
	public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
		mPresenter = initPresenter();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mPresenter.attach((V)this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mPresenter.dettach();
	}

	protected abstract P initPresenter();
}
