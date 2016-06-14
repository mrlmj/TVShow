package com.monkeyliu.tvshow.data.usecase;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * @author monkey
 * @date 2016/6/14 0014.
 */
public abstract class UseCase {
	
	private Subscription mSubscription = Subscriptions.empty();
	
	protected abstract Observable buildUseCaseObservable();
	
	public void execute(Subscriber usecaseSubscriber){
		this.mSubscription = buildUseCaseObservable()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(usecaseSubscriber);
	}
	
	public void unsubscribe(){
		if(!mSubscription.isUnsubscribed()){
			mSubscription.unsubscribe();
		}
	}
}
