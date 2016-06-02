package com.monkeyliu.tvshow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public abstract class BaseFragment extends Fragment{
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(getLayoutId(), container, false);
		ButterKnife.bind(this, rootView);
		initViews();
		return rootView;
	}
	
	protected abstract int getLayoutId();
	
	protected abstract void initViews();
}
