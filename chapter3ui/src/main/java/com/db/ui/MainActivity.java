package com.db.ui;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.db.funcbasic.BaseActivity;
import com.db.ui.layout.FrameLayoutActivity;
import com.db.ui.listview.ListViewActivity;
import com.db.ui.recyclerview.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_text_view_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_edit_text_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_image_view_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_progress_bar_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_alert_dialog_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_frame_layout_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_list_view_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_recycler_view_activity).setOnClickListener(this);

        //隐藏原来的ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start_text_view_activity:
                TextViewActivity.startTextViewActivity(this);
                break;
            case R.id.btn_start_edit_text_activity:
                EditTextActivity.startEditTextActivity(this);
                break;
            case R.id.btn_start_image_view_activity:
                ImageViewActivity.startImageViewActivity(this);
                break;
            case R.id.btn_start_progress_bar_activity:
                ProgressBarActivity.startProgressBarActivity(this);
                break;
            case R.id.btn_start_alert_dialog_activity:
                AlertDialogActivity.startAlertDialogActivity(this);
                break;
            case R.id.btn_start_frame_layout_activity:
                FrameLayoutActivity.startFrameLayoutActivity(this);
                break;
            case R.id.btn_start_list_view_activity:
                ListViewActivity.startListViewActivity(this);
                break;
            case R.id.btn_start_recycler_view_activity:
                RecyclerViewActivity.startRecyclerViewActivity(this);
                break;
            default:
                break;
        }
    }
}
