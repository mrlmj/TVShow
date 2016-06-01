package com.monkeyliu.tvshow.ui.activity.interfaces;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.monkeyliu.tvshow.presenter.BasePresenter;

/**
 * @author monkey
 * @brief
 * @date 2016/6/1 0001.
 */
public abstract class BaseMvpActivity<V,P extends BasePresenter<V>> extends BaseActivity{
	protected P mPresenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
