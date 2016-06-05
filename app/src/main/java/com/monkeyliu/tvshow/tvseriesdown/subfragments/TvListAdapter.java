package com.monkeyliu.tvshow.tvseriesdown.subfragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import com.monkeyliu.tvshow.R;
import com.monkeyliu.tvshow.data.bean.TvIntro;
import com.squareup.picasso.Picasso;

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
	private List<TvIntro> mDramaList;
	
	public TvListAdapter(Context context, ArrayList<TvIntro> textList){
		mContext = context;
		mLayoutInflater = LayoutInflater.from(mContext);
		mDramaList = textList;
	}
	
	public void fillDataWithClear(List<TvIntro> dramaList){
		mDramaList.clear();
		mDramaList = dramaList;
		notifyDataSetChanged();
	}
	
	public void appendMoreData(List<TvIntro> dramasList){
		mDramaList.addAll(dramasList);
		notifyDataSetChanged();
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(mLayoutInflater.inflate(R.layout.item_tvlist, parent, false));
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.mTvnameTextView.setText(mDramaList.get(position).getTv_name());
		Picasso.with(mContext).load(mDramaList.get(position).getTv_imageurl()).into(holder.mTvimgImageView);
		holder.mTvintroTextView.setText(mDramaList.get(position).getTv_intro());
	}

	@Override
	public int getItemCount() {
		return mDramaList.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		
		@Bind(R.id.tvname_textview)
		TextView mTvnameTextView;
		@Bind(R.id.tvimg_imageview)
		ImageView mTvimgImageView;
		@Bind(R.id.tvintro_textview)
		TextView mTvintroTextView;
		
		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
