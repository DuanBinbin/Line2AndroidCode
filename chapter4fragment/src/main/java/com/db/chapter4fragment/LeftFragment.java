package com.db.chapter4fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @描述：     @加载left_fragment.xml
 * @作者：     @Bin
 * @创建时间： @2018/11/21 16:12
 */
public final class LeftFragment extends Fragment {

    /**
     * 当碎片和活动建立关联的时候调用
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * 为碎片创建视频（加载布局）时调用
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.left_fragment,container,false);
    }

    /**
     * 确保与碎片相关联的活动一定已经创建完毕的时候调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 当与碎片关联的视图被移除的时候调用
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 当碎片与活动解除关联的时候调用
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
