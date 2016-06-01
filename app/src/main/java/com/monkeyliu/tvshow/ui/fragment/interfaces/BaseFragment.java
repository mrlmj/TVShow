package com.monkeyliu.tvshow.ui.fragment.interfaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by monkey on 2016/6/1.
 */
public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(),container,false);
        ButterKnife.bind(this,rootView);
        initViews();
        return rootView;
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();
}
