package com.monkeyliu.tvshow.data.net;

import com.monkeyliu.tvshow.data.bean.TvIntro;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author monkey
 * @date 2016/6/13 0013.
 */
public class RestApiImpl implements RestApi{
	
	TVCloudService mWebService;
	
	public RestApiImpl(){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.build();
		mWebService = retrofit.create(TVCloudService.class);
	}
	
	@Override
	public Observable<List<TvIntro>> getTvIntroes(int page) {
		return mWebService.getTvIntroes(page);
	}
	
	public interface TVCloudService{
		
		@GET("{page}")
		Observable<List<TvIntro>> getTvIntroes(@Path("page") int page);
	}
}
