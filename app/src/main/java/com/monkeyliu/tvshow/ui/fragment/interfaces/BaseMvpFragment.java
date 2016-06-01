package com.monkeyliu.tvshow.ui.fragment.interfaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.monkeyliu.tvshow.presenter.BasePresenter;

/**
 * Created by monkey on 2016/6/1.
 */
public abstract class BaseMvpFragment<V,P extends BasePresenter<V>> extends BaseFragment{

    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    protected abstract P initPresenter();

    @Override
    public void onResume() {
        super.onResume();
        Log.v("seewo","onResume");
        mPresenter.attach((V)this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("seewo","onDestroy");
        mPresenter.dettach();
    }
}
