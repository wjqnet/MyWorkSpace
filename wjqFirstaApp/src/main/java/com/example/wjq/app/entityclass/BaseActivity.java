package com.example.wjq.app.entityclass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.wjq.app.ReceiveDataActivity;

import java.security.PublicKey;

/**&
 * Created by 王瑞青 on 2017/4/13.
 * 在任何一个Activity都可以通过调用ActivityCollector.finish_All_Activity销毁整个应用程序。
 */

public class BaseActivity extends AppCompatActivity {
    public static final String TAG = "WJQ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"aaaaaaaaaaaaaaaaa"+getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }


    /**
     * 在被调用页面提供调用方法，供其它页面直接使用此方法。
     * 调用页面的写法为：ReceiveDataActivity.actionStar(调用页面类.this,"参数值1","参数值2")
     */

    public static void actionStar(Context context,Class secondActivit , String data1, String data2){
        Intent intent = new Intent(context,secondActivit);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }

}
