package com.monkeyliu.tvshow.data.source.remote;

import com.monkeyliu.tvshow.data.bean.TvIntro;
import com.monkeyliu.tvshow.data.source.TVDataStore;

import java.util.List;

import rx.Observable;

/**
 * @author monkey
 * @date 2016/6/13 0013.
 */
public class TVRemoteDataStore implements TVDataStore {
	
	public TVRemoteDataStore(){
		
	}
	
	@Override
	public Observable<List<TvIntro>> tvIntroList(int pageId) {
		return null;
	}
}
