package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;

import com.monkeyliu.tvshow.R;
import com.monkeyliu.tvshow.data.bean.Drama;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author monkey
 * @date 2016/6/2 0002.
 */
public class TvListAdapter extends RecyclerView.Adapter<TvListAdapter.ViewHolder> {
	
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private ArrayList<Drama> mDramaList;
	
	public TvListAdapter(Context context, ArrayList<Drama> textList){
		mContext = context;
		mLayoutInflater = LayoutInflater.from(mContext);
		mDramaList = textList;
	}
	
	public void fillDataWithClear(ArrayList<Drama> dramaList){
		mDramaList.clear();
		mDramaList = dramaList;
		notifyDataSetChanged();
	}
	
	public void appendMoreData(ArrayList<Drama> dramasList){
		mDramaList.addAll(dramasList);
		notifyDataSetChanged();
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(mLayoutInflater.inflate(R.layout.item_tvlist, parent, false));
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mNameTextview.setText(mDramaList.get(position).getName());
		holder.mUrlTextView.setText(mDramaList.get(position).getUrl());
	}

	@Override
	public int getItemCount() {
		return mDramaList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		
		@Bind(R.id.textview_name)
		TextView mNameTextview;
		@Bind(R.id.textview_url)
		TextView mUrlTextView;
		
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
