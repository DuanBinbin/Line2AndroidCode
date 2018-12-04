package com.db.contentprovider.permission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.db.contentprovider.R;

public class PermissionActivity extends Activity implements View.OnClickListener {

    private static final String TAG = PermissionActivity.class.getSimpleName();
    public static final int REQUEST_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        findViewById(R.id.btn_make_call).setOnClickListener(this);
    }

    public static void startPermissionActivity(Context context) {
        Log.v(TAG, "startPermissionActivity");
        Intent intent = new Intent(context, PermissionActivity.class);
        context.startActivity(intent);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_make_call:
                makeCall();
                break;
        }
    }

    /**
     * 拨打电话
     */
    private void makeCall() {
        try {
            Log.v(TAG, "makeCall()");
            final Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            PermissionHolder.requestPermissions(this, REQUEST_PERMISSIONS, getPermissions(), new PermissionHolder.OnPermissionListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onPermissionGranted() {
                    Log.d(TAG,"已授权");
                    startActivity(intent);
                }

                @Override
                public void onPermissionDenied(String[] deniedPermissions) {
                    Log.e(TAG,"未授权");
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected String[] getPermissions() {
        return new String[]{
                Manifest.permission.CALL_PHONE,
        };
    }
}
