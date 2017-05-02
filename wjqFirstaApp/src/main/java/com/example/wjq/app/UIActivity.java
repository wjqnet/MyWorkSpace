/**
 * 测试各类控件。
 */

package com.example.wjq.app;

import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.wjq.app.entityclass.BaseActivity;

import java.io.File;

public class UIActivity extends BaseActivity implements View.OnClickListener{

    private ProgressBar progressBar;
    private ImageView imageView;
    private EditText edTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        Button bt1 = (Button) findViewById(R.id.btn1);
        bt1.setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imageView = (ImageView) findViewById(R.id.imageView);
        edTxt = (EditText) findViewById(R.id.edTxt);

        //方式三
        Button btn3 = (Button) findViewById(R.id.btnListen);
        btn3.setOnClickListener(listener1);

    }

    /**方式一
     * onclick接口实现方法
     * 1、public class UIActivity extends BaseActivity implements View.OnClickListener{
     * 2、button.setOnClickListener(this);
     * 3、public void onClick(View v) {
     * @param v
     */
    @Override
    public void onClick(View v) {
        File a  = new File(getExternalCacheDir(),"aaa");
        switch (v.getId()){

            case R.id.btn1:
                Log.d(TAG, "onClick: implements View.OnClickListener{");
                if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
//                    Toast.makeText(this,"显示进度条",Toast.LENGTH_SHORT).show();
                    edTxt.setText("显示进度条");
                }else{
                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(this,"隐藏进度条",Toast.LENGTH_SHORT).show();
                    edTxt.setText("隐藏进度条");
                }

                break;
            default:
                Toast.makeText(this,"cccccccccccccc",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    /**方式二
     * 在配置文件里增加Android:onClick="Btn2OnClick"
     * @param view
     */
    public void btn2OnClick(View view){
        edTxt.setText("像delphi一样直接写方法了!但在配置文件里增加Android:onClick=\"Btn2OnClick\"");
    };

    /**方式三
     */
    Button.OnClickListener listener1 = new Button.OnClickListener(){
      public void onClick(View v){
          edTxt.setText("只定义监听的方法名，实现方法在外部实现!");
      }
    };
}
