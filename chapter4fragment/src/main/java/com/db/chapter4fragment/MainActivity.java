package com.db.chapter4fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.db.funcbasic.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_left_fragment).setOnClickListener(this);
//        replaceFragment(new RightFragment());

        //动态加载布局的技巧是利用Android限定符（Qualifiers)来实现的
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_left_fragment:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 替换Fragment
     * @param fragment
     */
    private void replaceFragment(Fragment fragment){
       FragmentManager fragmentManager = getSupportFragmentManager();
       FragmentTransaction transaction = fragmentManager.beginTransaction();
//       transaction.replace(R.id.right_frame_layout, fragment);
       //接受一个名字用于描述返回栈的状态，一般传入null即可
       transaction.addToBackStack(null);
       transaction.commit();
    }
}
