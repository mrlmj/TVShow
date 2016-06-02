package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;

import com.monkeyliu.tvshow.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListAdapter extends RecyclerView.Adapter<TvListAdapter.ViewHolder> {
	
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private ArrayList<String> mTextList;
	
	public TvListAdapter(Context context, ArrayList<String> textList){
		mContext = context;
		mLayoutInflater = LayoutInflater.from(mContext);
		mTextList = textList;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(mLayoutInflater.inflate(R.layout.item_tvlist, parent, false));
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mTextview.setText(mTextList.get(position));
	}

	@Override
	public int getItemCount() {
		return mTextList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		
		@Bind(R.id.textview_content)
		TextView mTextview;
		
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
