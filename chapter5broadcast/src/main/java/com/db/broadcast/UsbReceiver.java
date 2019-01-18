package com.db.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class UsbReceiver extends BroadcastReceiver {

    private static final String TAG = UsbReceiver.class.getSimpleName();

    public static final String ACTION_USB_STATE =
            "android.hardware.usb.action.USB_STATE";
    public static final String USB_CONNECTED = "connected";

    private static boolean temp = false;
    @Override
    public void onReceive(Context context, Intent intent) {
        final String intentAction = intent.getAction();
        Log.d(TAG,"onReceive() --> " + intentAction);


        switch (intentAction){
            case ACTION_USB_STATE:
                // TODO: 2019/1/18 没有解决ACTION_USB_STATE发送两边的问题 
                final boolean connected = intent.getExtras().getBoolean(USB_CONNECTED);
                Log.d(TAG,"01 --> Connect = " + connected);
                if (connected){
                    if (!temp){
                        temp = true;
                        Toast.makeText(BaseApplication.getContext(),"Connected = " + connected,LENGTH_SHORT).show();
                    }

                } else {
                    temp = false;
                }


                break;

            case UsbManager.ACTION_USB_ACCESSORY_ATTACHED:
                break;

            case UsbManager.ACTION_USB_ACCESSORY_DETACHED:
                break;

            case UsbManager.ACTION_USB_DEVICE_ATTACHED:
                break;

            case UsbManager.ACTION_USB_DEVICE_DETACHED:
                break;

            default:
                Toast.makeText(BaseApplication.getContext(),intentAction,LENGTH_SHORT).show();
                break;
        }
    }


}
