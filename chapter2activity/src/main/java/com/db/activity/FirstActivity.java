package com.db.activity;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        // getIntent()获取用于启动FirstActivity的Intent
        Intent intent = getIntent();
        final String data = intent.getStringExtra("extra_data");
        if (!TextUtils.isEmpty(data)){
            Toast.makeText(getApplicationContext(),data,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_2:
                finishActivity();
                break;
            default:
                break;
        }
    }

    /**
     * 用户点击Back键返回MainActivity，该方法一定会执行
     */
    @Override
    public void onBackPressed() {
        finishActivity();
    }

    /**
     * 启动FirstActivity
     * @param context
     */
    public static void startFirstActivity(Context context){
        Intent intent = new Intent(context,FirstActivity.class);
        context.startActivity(intent);
    }

    /**
     * 结束当前Activity
     */
    private void finishActivity(){
        //该Intent只是用来传递数据，没有指定任何的“意图”
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello MainActivity");
        //专门用于向上一个活动返回数据，
        //setResult(),第一个参数用于向上一个活动返回处理结果，一般只用RESULT_OK或RESULT_CANCELED,
        //第二个参数用于把带数据的Intent传递回去
        setResult(RESULT_OK,intent);
        finish();
    }
}
