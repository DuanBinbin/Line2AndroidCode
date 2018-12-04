package com.db.contentprovider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.db.contentprovider.permission.PermissionHolder;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends Activity implements View.OnClickListener {

    private static final String TAG = ContactActivity.class.getSimpleName();

    ArrayAdapter<String> adapter;

    List<String> contactsList = new ArrayList<>();

    public static final int REQUEST_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView contactListView = findViewById(R.id.listView_contact);
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactsList);

        contactListView.setAdapter(adapter);

        findViewById(R.id.btn_read_contacts).setOnClickListener(this);

//        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)
//                != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(
//                    this,
//                    new String[]{Manifest.permission.READ_CONTACTS},
//                    1);
//        } else {
//            readContacts();
//        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    readContacts();
                } else {
                    Toast.makeText(
                            this,
                            "You denied the permission",
                            Toast.LENGTH_SHORT).show();
                }
                break;

                default:
        }
    }

    public static void startContactsActivity(Context context){
        Intent intent = new Intent(context,ContactActivity.class);
        context.startActivity(intent);
    }

    /**
     * 读取数据联系人
     */
    private void readContacts(){
        Cursor cursor = null;
        try {
            //查询联系人数据
            cursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);

            if(null != cursor){
                while (cursor.moveToNext()){
                    //获取联系人姓名
                    String displayName = cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                    //获取联系人手机号
                    String number = cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    contactsList.add(displayName + "\n" + number);
                }
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (null != cursor){
                cursor.close();
            }
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_read_contacts:

                PermissionHolder.requestPermissions(this, REQUEST_PERMISSIONS, getPermissions(), new PermissionHolder.OnPermissionListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onPermissionGranted() {
                        Log.d(TAG, "已授权");
                        readContacts();
                    }

                    @Override
                    public void onPermissionDenied(String[] deniedPermissions) {
                        Log.e(TAG, "未授权");
                    }
                });
                break;
                default:
        }
    }

    protected String[] getPermissions() {
        return new String[]{
                Manifest.permission.READ_CONTACTS
        };
    }
}
