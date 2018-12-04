package com.db.chapter4fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @描述：     @新建AnotherRightFragment
 * @作者：     @Bin
 * @创建时间： @2018/11/28 15:56
 */
public class AnotherRightFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.another_right_fragment,container,false);
    }
}
