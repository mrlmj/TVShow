package com.monkeyliu.tvshow.data.net;

import com.monkeyliu.tvshow.data.bean.TvIntro;

import java.util.List;

import rx.Observable;

/**
 * @author monkey
 * @date 2016/6/13 0013.
 */
public interface RestApi {
	
	String BASE_URL = "xxx";
	
	Observable<List<TvIntro>> getTvIntroes(int page);
}
