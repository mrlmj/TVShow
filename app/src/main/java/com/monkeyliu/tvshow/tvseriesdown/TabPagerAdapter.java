package com.monkeyliu.tvshow.tvseriesdown;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.monkeyliu.tvshow.tvseriesdown.subfragments.RecyclerFragment;

import java.util.List;

/**
 * @author monkey
 * @date 2016/6/3 0003.
 */
public class TabPagerAdapter extends FragmentPagerAdapter{

	private List<RecyclerFragment> mFragments;
	private List<String> mTitles;
	
	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public void setFragments(List<RecyclerFragment> fragments, List<String> titles){
		mFragments = fragments;
		mTitles = titles;
	}
	
	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mTitles.get(position);
	}
}
