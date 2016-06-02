package com.monkeyliu.tvshow.tvseries;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.monkeyliu.tvshow.BaseActivity;
import com.monkeyliu.tvshow.R;

import butterknife.Bind;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,MainContract.View{
	
	private MainContract.Presenter mPresenter;
	
	@Bind(R.id.toolbar)
	Toolbar mToolbar;

	@Bind(R.id.drawer_layout)
	DrawerLayout mDrawerLayout;
	
	@Bind(R.id.nav_view)
	NavigationView mNavView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new MainPresenter(getSupportFragmentManager(), R.id.content, this);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initViews() {
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		mDrawerLayout.setDrawerListener(toggle);
		toggle.syncState();

		mNavView.setNavigationItemSelectedListener(this);
		mNavView.getMenu().getItem(0).setChecked(true);
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		mPresenter.switchPage(item.getItemId());

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override
	public void setPresenter(MainContract.Presenter presenter) {
		mPresenter = presenter;
	}
}
