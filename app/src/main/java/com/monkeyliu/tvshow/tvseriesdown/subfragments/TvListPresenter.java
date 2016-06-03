package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import com.monkeyliu.tvshow.data.bean.Drama;

import java.util.ArrayList;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListPresenter implements TvListContract.Presenter {
	
	private TvListContract.View mView;
	
	public TvListPresenter(TvListContract.View view){
		mView = view;
		mView.setPresenter(this);
	}
	
	@Override
	public void reloadData() {
		mView.setLoadingIndicator(true);
		ArrayList<Drama> data = new ArrayList<>();
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
			data.add(new Drama("liu","123"));
		mView.setLoadingIndicator(false);
		mView.fillData(data);
	}

	@Override
	public void loadMoreData() {

	}
}
