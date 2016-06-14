package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import com.monkeyliu.tvshow.data.bean.TvIntro;
import com.monkeyliu.tvshow.data.usecase.GetTvIntroes;
import com.monkeyliu.tvshow.tvseries.TVApplication;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import rx.Subscriber;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListPresenter implements TvListContract.Presenter {
	
	private TvListContract.View mView;
	
	private GetTvIntroes mGetTvIntroUsecase;
	
	public TvListPresenter(TvListContract.View view){
		mView = view;
		mView.setPresenter(this);
		mGetTvIntroUsecase = new GetTvIntroes();
	}
	
	@Override
	public void reloadData() {
		mView.setLoadingIndicator(true);
//		BmobQuery<TvIntro> query = new BmobQuery<>();
//		query.setLimit(10);
//		query.findObjects(TVApplication.sContext, new FindListener<TvIntro>() {
//			@Override
//			public void onSuccess(List<TvIntro> list) {
//				mView.fillData(list);
//				mView.setLoadingIndicator(false);
//			}
//
//			@Override
//			public void onError(int i, String s) {
//				Logger.d("load data error %s", s);
//				mView.showLoadingError(s);
//			}
//		});
		
		mGetTvIntroUsecase.setPageId(0);
		mGetTvIntroUsecase.execute(new Subscriber<List<TvIntro>>() {
			@Override
			public void onCompleted() {
				mView.setLoadingIndicator(false);
			}

			@Override
			public void onError(Throwable e) {
				mView.showLoadingError(e.toString());
			}

			@Override
			public void onNext(List<TvIntro> o) {
				mView.fillData(o);
			}
		});
	}
	

	@Override
	public void loadMoreData() {
		Logger.d("loadMoreData");
		mView.setLoadingMoreIndicator(true);
		BmobQuery<TvIntro> query = new BmobQuery<>();
		query.setLimit(10);
		query.findObjects(TVApplication.sContext, new FindListener<TvIntro>() {
			@Override
			public void onSuccess(List<TvIntro> list) {
				mView.appendData(list);
				mView.setLoadingMoreIndicator(false);
			}

			@Override
			public void onError(int i, String s) {
				Logger.d("load data error %s", s);
				mView.showLoadingError(s);
			}
		});
	}
}
