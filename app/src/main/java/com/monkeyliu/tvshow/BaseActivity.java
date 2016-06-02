package com.monkeyliu.tvshow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public abstract class BaseActivity extends AppCompatActivity{

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		ButterKnife.bind(this);
		initViews();
	}
	
	protected abstract int getLayoutId();
	
	protected abstract void initViews();
}
