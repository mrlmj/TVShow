package com.monkeyliu.tvshow.tvseries;

import android.support.v4.app.FragmentManager;

import com.monkeyliu.tvshow.R;
import com.monkeyliu.tvshow.tvseriesdown.TvSeriesDownFragment;
import com.monkeyliu.tvshow.utils.FragmentSwitcher;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class MainPresenter implements MainContract.Presenter {
	
	private FragmentSwitcher mSwitcher;
	private MainContract.View mView;
	
	public MainPresenter(FragmentManager manager, int containerId, MainContract.View view){
		mSwitcher = new FragmentSwitcher(manager, containerId);
		mView = view;
		mView.setPresenter(this);
	}
	
	@Override
	public void switchPage(int itemId) {
		switch (itemId){
			case R.id.nav_tvseriesdown:
				mSwitcher.switchTo(TvSeriesDownFragment.TAG);
		}
	}
}
