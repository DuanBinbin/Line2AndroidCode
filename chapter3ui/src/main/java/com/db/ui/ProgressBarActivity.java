package com.db.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.db.funcbasic.BaseActivity;

public class ProgressBarActivity extends BaseActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        findViewById(R.id.btn_show_progress_bar).setOnClickListener(this);
        findViewById(R.id.btn_adjust_progress_bar).setOnClickListener(this);
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_progress_bar:
                //设置可见属性
                if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_adjust_progress_bar:
                //设置进度
                int progress = progressBar.getProgress();
                progress += 10;
                progressBar.setProgress(progress);
                break;
                default:
        }
    }

    public static void startProgressBarActivity(Context context){
        Intent intent = new Intent(context,ProgressBarActivity.class);
        context.startActivity(intent);
    }
}
