package com.db.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.db.funcbasic.BaseActivity;

public class AlertDialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        findViewById(R.id.btn_show_alert_dialog).setOnClickListener(this);
        findViewById(R.id.btn_show_progress_dialog).setOnClickListener(this);
    }

    public static void startAlertDialogActivity(Context context){
        Intent intent = new Intent(context,AlertDialogActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_alert_dialog:
                showAlertDialog();
                break;
            case R.id.btn_show_progress_dialog:
                showProgressDialog();
                break;
                default:
        }
    }

    /**
     * 显示AlertDialog
     */
    private void showAlertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("This is Dialog");
        dialog.setMessage("Something is fun");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You choose Ok",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"You choose Cancel",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    /**
     * 显示ProgressDialog
     */
    private void showProgressDialog(){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("This is ProgressDialog");
        progressDialog.setMessage("Loading...");
        //传入true，表示ProgressDialog可以通过Back键取消掉，反之，false不可以，必须通过dismiss()来关闭
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}
