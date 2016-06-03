package com.monkeyliu.tvshow.tvseriesdown;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.monkeyliu.tvshow.BaseFragment;
import com.monkeyliu.tvshow.R;
import com.monkeyliu.tvshow.tvseriesdown.subfragments.RecyclerFragment;
import com.monkeyliu.tvshow.tvseriesdown.subfragments.TvListFragment;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvSeriesDownFragment extends BaseFragment implements TvSeriesDownContract.View{
	
	@Bind(R.id.tabs)
	TabLayout mTabs;
	@Bind(R.id.viewpager)
	ViewPager mViewPager;
	
	private List<RecyclerFragment> mFragments = new ArrayList<>();
	private List<String> mTitles = new ArrayList<>();
	
	private TabPagerAdapter mPagerAdapter;
	
	public static final String TAG = "TvSeriesDown";
	
	private TvSeriesDownContract.Presenter mPresenter;
	
	@Override
	protected int getLayoutId() {
		return R.layout.fragment_tvseriesdown;
	}

	@Override
	protected void initViews() {
		initFragments();
		mViewPager.setAdapter(mPagerAdapter);
		mTabs.setupWithViewPager(mViewPager);
		mTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				mViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {

			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});
	}

	private void initFragments(){
		mPagerAdapter = new TabPagerAdapter(getChildFragmentManager());
		mTitles = Arrays.asList(getContext().getResources().getStringArray(R.array.tvseries_types));
		mFragments.add(TvListFragment.newInstance(TvListFragment.TYPE_ACTION));
		mFragments.add(TvListFragment.newInstance(TvListFragment.TYPE_COMEDY));
		mFragments.add(TvListFragment.newInstance(TvListFragment.TYPE_THRILLER));
		mFragments.add(TvListFragment.newInstance(TvListFragment.TYPE_MAGIC));
		mFragments.add(TvListFragment.newInstance(TvListFragment.TYPE_CRIME));
		mPagerAdapter.setFragments(mFragments,mTitles);
	}
	
	@Override
	public void setPresenter(TvSeriesDownContract.Presenter presenter) {
		mPresenter = presenter;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Logger.d("fragment onDestory");
	}
}
