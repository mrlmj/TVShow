package com.monkeyliu.tvshow.data.source;

import com.monkeyliu.tvshow.data.bean.TvIntro;
import com.monkeyliu.tvshow.data.source.remote.TVRemoteDataStore;

import java.util.List;

import rx.Observable;

/**
 * @author monkey
 * @date 2016/6/13 0013.
 */
public class TVRepository implements TVDataStore {
	
	TVDataStore mRemoteDataSource;
	
	public TVRepository(){
		mRemoteDataSource = new TVRemoteDataStore();
	}
	
	@Override
	public Observable<List<TvIntro>> tvIntroList(int pageId) {
		return mRemoteDataSource.tvIntroList(pageId);
	}
}
