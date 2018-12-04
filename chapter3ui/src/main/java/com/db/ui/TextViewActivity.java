package com.db.ui;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;

import com.db.funcbasic.BaseActivity;

import java.util.HashMap;

public class TextViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        testBooleanDefaultValue();
    }

    /**
     * 启动TextViewActivity
     * @param context
     */
    public static void startTextViewActivity(Context context){
        Intent intent = new Intent(context,TextViewActivity.class);
        context.startActivity(intent);
    }

    private void testBooleanDefaultValue(){
        final HashMap<String,String> map = new HashMap<>();
        Log.d("TextViewActivity","map default = " + Boolean.parseBoolean(map.get("Hello")));
    }
}
