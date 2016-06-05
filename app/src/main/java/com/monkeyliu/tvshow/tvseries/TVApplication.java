package com.monkeyliu.tvshow.tvseries;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;

import cn.bmob.v3.Bmob;

/**
 * @author monkey
 * @date 2016/6/3 0003.
 */
public class TVApplication extends Application{

	public static Context sContext;

	private static String APP_ID = "d896be33b09768a49e1784774284424f";

	@Override
	public void onCreate() {
		super.onCreate();
		sContext = this;
		Logger.init("monkey");
		Bmob.initialize(this, APP_ID);
	}
}
