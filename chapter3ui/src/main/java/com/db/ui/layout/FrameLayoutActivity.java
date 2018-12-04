package com.db.ui.layout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.db.funcbasic.BaseActivity;
import com.db.ui.R;

public class FrameLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
    }

    public static void startFrameLayoutActivity(Context context){
        Intent intent = new Intent(context,FrameLayoutActivity.class);
        context.startActivity(intent);
    }
}
