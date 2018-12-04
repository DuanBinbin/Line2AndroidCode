package com.db.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.db.funcbasic.BaseActivity;

public class EditTextActivity extends BaseActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        editText = findViewById(R.id.edit_text);
        findViewById(R.id.btn_show_edit_text).setOnClickListener(this);
    }

    public static void startEditTextActivity(Context context){
        Intent intent = new Intent(context,EditTextActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_edit_text:
                final String inputText = editText.getText().toString();
                if (!TextUtils.isEmpty(inputText)){
                    Toast.makeText(this,inputText,Toast.LENGTH_SHORT).show();
                }
                break;
                default:
                    break;
        }
    }
}
