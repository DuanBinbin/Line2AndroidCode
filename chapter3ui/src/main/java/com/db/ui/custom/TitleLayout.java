package com.db.ui.custom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.db.ui.R;

/**
 * @描述：     @自定义控件
 * @作者：     @Bin
 * @创建时间： @2018/11/7 15:22
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener{

    public TitleLayout(Context context, AttributeSet attributes){
        super(context,  attributes);
        //from()方法可以构建出一个LayoutInflater对象
        //inflate()方法可以动态加载一个布局文件，第一个参数决定要加载的布局文件的id,第二个参数
        //给加载好的布局再添加一个父布局
        LayoutInflater.from(context).inflate(R.layout.ui_custom_layout_title,this);

        findViewById(R.id.btn_title_back).setOnClickListener(this);
        findViewById(R.id.btn_title_edit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_title_back:
                finishActivity();
                break;
            case R.id.btn_title_edit:
                showEdit();
                break;
                default:
                    break;
        }
    }

    /**
     * 结束Activity
     */
    private void finishActivity(){
        ((Activity)getContext()).finish();
    }

    /**
     * 显示Edit
     */
    private void showEdit(){
        Toast.makeText(getContext(),"You clicked Edit button",Toast.LENGTH_SHORT).show();
    }
}
