package com.example.wjq.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);
        Intent intent = getIntent();
        String recDate = intent.getStringExtra("extra_data");
        TextView tv = (TextView) findViewById(R.id.tv_receiveData);
        tv.setText("取得其它页面传递的值为="+recDate);


        Button btnback = (Button) findViewById(R.id.btn_Back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sData = (TextView) findViewById(R.id.edtBackValue);
                Intent intent = new Intent();
                intent.putExtra("data_return",sData.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    /**
     * 通过重写onBackPressed方法，把要返回让信息在这里封装，这样即使在此页面按返回键，其他页面也能在其onActivityResult方法里取到值
     */
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = getIntent();
        intent.putExtra("data_return","直接按返回键返回的值！");
        setResult(RESULT_OK,intent);
        finish();
    }


    /**
     * 在被调用页面提供调用方法，供其它页面直接使用此方法。
     * 调用页面的写法为：ReceiveDataActivity。actionStar(调用页面类.this,"参数值1","参数值2")
     */

    public static void actionStar(Context context,String data1,String data2){
        Intent intent = new Intent(context,ReceiveDataActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);
    }




}
