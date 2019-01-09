package com.db.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
    }

    /**
     * 开始PopupWindowActivity
     * @param context
     */
    public static void startPopupWindowAcitvity(Context context){
        Intent intent = new Intent(context,PopupWindowActivity.class);
        context.startActivity(intent);
    }
}
