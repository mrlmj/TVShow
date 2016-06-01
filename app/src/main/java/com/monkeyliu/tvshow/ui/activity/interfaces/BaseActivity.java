package com.monkeyliu.tvshow.ui.activity.interfaces;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author monkey
 * @brief
 * @date 2016/6/1 0001.
 */
public abstract class BaseActivity extends AppCompatActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
	}

	protected abstract int getLayoutId();
}
