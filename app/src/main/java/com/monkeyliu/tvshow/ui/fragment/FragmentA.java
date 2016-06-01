package com.monkeyliu.tvshow.ui.fragment;

import android.graphics.Color;
import android.widget.TextView;

import com.monkeyliu.tvshow.R;
import com.monkeyliu.tvshow.presenter.FragmentAPresenter;
import com.monkeyliu.tvshow.ui.fragment.interfaces.BaseMvpFragment;
import com.monkeyliu.tvshow.ui.fragment.interfaces.IFragmentA;

import butterknife.Bind;

/**
 * Created by monkey on 2016/6/1.
 */
public class FragmentA extends BaseMvpFragment<IFragmentA,FragmentAPresenter> implements IFragmentA{
    @Bind(R.id.testview_a)
    TextView mTextViewA;

    @Override
    protected FragmentAPresenter initPresenter() {
        return new FragmentAPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.content_main;
    }

    @Override
    protected void initViews() {
        mTextViewA.setTextColor(Color.RED);
    }
}
