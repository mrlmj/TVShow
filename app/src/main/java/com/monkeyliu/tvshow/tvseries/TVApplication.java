package com.monkeyliu.tvshow.tvseries;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * @author monkey
 * @date 2016/6/3 0003.
 */
public class TVApplication extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		Logger.init("monkey");
	}
}
