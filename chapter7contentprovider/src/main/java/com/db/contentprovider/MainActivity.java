package com.db.contentprovider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.db.contentprovider.permission.PermissionActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_permission_activity).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_permission_activity:
                PermissionActivity.startPermissionActivity(this);
                break;
        }
    }
}
