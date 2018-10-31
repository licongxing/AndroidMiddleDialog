package com.example.middledialogdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView mBtn;
    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn =  findViewById(R.id.but_dialog);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                intent.putExtra("param","i am 中间按钮");
                startActivityForResult(intent,Constants.DIALOG_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case Constants.DIALOG_REQUEST_CODE:
                if(resultCode == Constants.DIALOG_CANCEL_CODE){
                    //取消逻辑处理
                    Log.d(TAG, "【onActivityResult】: 对话框的 cancel 被点击");
                }else{
                    //确定逻辑处理
                    Log.d(TAG, "【onActivityResult】: 对话框的 ok     被点击");
                }
                Log.d(TAG, "【onActivityResult】: 接受到的消息="+data.getStringExtra("data_return"));
            break;
        }
    }
}
