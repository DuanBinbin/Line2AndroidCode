package com.db.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.db.funcbasic.BaseActivity;

public class ImageViewActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        findViewById(R.id.btn_show_image_view).setOnClickListener(this);
        imageView = findViewById(R.id.image_view);
    }

    public static void startImageViewActivity(Context context){
        Intent intent = new Intent(context,ImageViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_image_view:
                imageView.setImageResource(R.drawable.girl);
                break;
                default:
        }
    }
}
