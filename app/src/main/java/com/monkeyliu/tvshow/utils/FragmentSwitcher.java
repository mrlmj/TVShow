package com.monkeyliu.tvshow.utils;

import android.nfc.Tag;
import android.support.annotation.FloatRange;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;

import com.monkeyliu.tvshow.BaseFragment;
import com.monkeyliu.tvshow.tvseriesdown.TvSeriesDownContract;
import com.monkeyliu.tvshow.tvseriesdown.TvSeriesDownFragment;
import com.monkeyliu.tvshow.tvseriesdown.TvSeriesDownPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class FragmentSwitcher {
	
	private FragmentManager mFragmentManager;
	private int mContainer;
	private ArrayList<String> mFragments;
	
	public FragmentSwitcher(FragmentManager manager, int container){
		mFragmentManager = manager;
		mContainer = container;
		mFragments = new ArrayList<>();
	}

	/**
	 *  hide当前fragment,show要显示的fragment 
	 */
	public void switchTo(String fragmentTag){
		if(isFragmentExits(fragmentTag)){
			showFragment(fragmentTag);
		}else{
			mFragments.add(fragmentTag);
			showFragment(fragmentTag);
		}
	}

	/**
	 * 移除fragment
	 */
	public void removeFragment(String fragmentTag){
		int index = getFragmentIndex(fragmentTag);
		if(index != -1){
			mFragments.remove(index);
			if(mFragmentManager.findFragmentByTag(fragmentTag) != null){
				FragmentTransaction transaction = mFragmentManager.beginTransaction();
				transaction.remove(FragmentFactory.getFragment(fragmentTag));
				transaction.commitAllowingStateLoss();
			}
		}
	}

	/**
	 * 添加fragment
	 * @param fragmentTag
	 */
	public void addFragment(String fragmentTag){
		if(!isFragmentExits(fragmentTag)) {
			mFragments.add(fragmentTag);
		}
		if(mFragmentManager.findFragmentByTag(fragmentTag) == null){
			FragmentTransaction transaction = mFragmentManager.beginTransaction();
			transaction.add(mContainer,FragmentFactory.getFragment(fragmentTag),fragmentTag);
			transaction.commitAllowingStateLoss();
		}
	}

	/**
	 * 替换fragment
	 * @param fragmentTag
	 */
	public void replaceFragment(String fragmentTag){
		if(!isFragmentExits(fragmentTag)){
			mFragments.add(fragmentTag);
		}
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		transaction.replace(mContainer,FragmentFactory.getFragment(fragmentTag), fragmentTag);
		transaction.commitAllowingStateLoss();
	}
	
	private void showFragment(String fragmentTag){
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		for(int i = 0; i < mFragments.size(); i++){
			String tag = mFragments.get(i);
			if(tag.equals(fragmentTag)){
				if(mFragmentManager.findFragmentByTag(tag) == null){
					transaction.add(mContainer,FragmentFactory.getFragment(tag),tag);
				}else{
					transaction.show(FragmentFactory.getFragment(tag));
				}
			}else{
				transaction.hide(FragmentFactory.getFragment(tag));
			}
		}
		transaction.commitAllowingStateLoss();
	}
	
	private boolean isFragmentExits(String fragmentTag){
		return getFragmentIndex(fragmentTag) != -1;
	}
	
	private int getFragmentIndex(String fragmentTag){
		for(int i = 0; i < mFragments.size(); i++){
			if(mFragments.get(i).equals(fragmentTag)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Fragment工厂
	 */
	public static class FragmentFactory{
		
		private static HashMap<String, BaseFragment> mFragmentMap = new HashMap<>();
		
		public static BaseFragment getFragment(String tag){
			BaseFragment fragment = mFragmentMap.get(tag);
			if(fragment == null) {
				switch (tag) {
					case TvSeriesDownFragment.TAG:
						fragment = new TvSeriesDownFragment();
						new TvSeriesDownPresenter((TvSeriesDownContract.View)fragment);
						break;
					default:
						break;
				}
				mFragmentMap.put(tag,fragment);
			}
			return fragment;
		}
		
		public static void clearFragments(){
			mFragmentMap.clear();
		}
	}
}
