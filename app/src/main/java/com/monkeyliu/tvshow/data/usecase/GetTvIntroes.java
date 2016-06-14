package com.monkeyliu.tvshow.data.usecase;

import com.monkeyliu.tvshow.data.source.TVRepository;

import rx.Observable;

/**
 * @author monkey
 * @date 2016/6/14 0014.
 */
public class GetTvIntroes extends UseCase{

	private int mPageId;
	private TVRepository mRepository;
	
	public GetTvIntroes(){
		this(0);
	}
	
	public GetTvIntroes(int pageId){
		this(pageId, new TVRepository());
	}
	
	public GetTvIntroes(int pageId, TVRepository repository){
		this.mPageId = pageId;
		this.mRepository = repository;
	}
	
	public void setPageId(int id){
		this.mPageId = id;
	}
	
	@Override
	protected Observable buildUseCaseObservable() {
		return mRepository.tvIntroList(mPageId);
	}
}
