package com.monkeyliu.tvshow.data.source;

import com.monkeyliu.tvshow.data.bean.TvIntro;

import java.util.List;

import rx.Observable;

/**
 * @author monkey
 * @date 2016/6/13 0013.
 */
public interface TVDataStore {
	Observable<List<TvIntro>> tvIntroList(int pageId);
}
