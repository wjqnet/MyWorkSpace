package com.example.wjq.app;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

//wjq
import com.example.wjq.app.entityclass.BaseActivity;
import com.example.wjq.app.entityclass.Fruit;
import com.example.wjq.app.adapter.FruitAdapter;
import com.example.wjq.app.msg.MsgActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final int TO_RECEIVEDATA_ACTIVITY = 1;

    private  List<Fruit> fruitList = new ArrayList<Fruit>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("WUJIAQIN", "onCreate:1111111111111111111 ");

        //1、页面跳转（登录）
        final Button btn_intent = (Button) findViewById(R.id.btn_login);
        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        //2、listView初始化
        initItems(); // 初始化水果数据

        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Fruit fruit = fruitList.get(position);
                if ("baidu".equalsIgnoreCase(fruit.getItemId())){
                    Intent baiduIntent = new Intent(Intent.ACTION_VIEW);
                    baiduIntent.setData(Uri.parse("http://www.baidu.com"));
                    startActivity(baiduIntent);
                }else if ("tel".equalsIgnoreCase(fruit.getItemId())){
                    Intent telIntent = new Intent(Intent.ACTION_DIAL);
                    telIntent.setData(Uri.parse("tel:13850112963"));
                    startActivity(telIntent);
                }else if ("invokeAndPassData".equalsIgnoreCase(fruit.getItemId())){
                    Intent intent = new Intent(MainActivity.this,ReceiveDataActivity.class);
                    String sValue = "{a: 'Hello', b: 'World'}";
                    intent.putExtra("extra_data",sValue);
                    Bundle bundle = new Bundle();
                    bundle.putString("data_key","data_value1");
                    intent.putExtra("BundleObject",bundle);
                    //startActivity(intent);//不要返回值
                    startActivityForResult(intent,TO_RECEIVEDATA_ACTIVITY);
                }else if ("Widget".equalsIgnoreCase(fruit.getItemId())){
                    actionStar(MainActivity.this,UIActivity.class,"1","2");
                }else if ("includeXML".equalsIgnoreCase(fruit.getItemId())){
                actionStar(MainActivity.this,TitleMainActivity.class,"1","2");
                }else if ("qqmsg".equalsIgnoreCase(fruit.getItemId())){
                    actionStar(MainActivity.this,MsgActivity.class,"1","2");
                }
                else {
                    Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }



    //右上角菜单 begin
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"增加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"删除", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    //右上角菜单 end

    private void initItems() {
        String[][] aryItem = {
                { "打开baidu", String.valueOf(R.drawable.baidu_pic),"baidu" },
                { "tel拨号", String.valueOf(R.drawable.apple_pic),"tel"},
                { "调用另一个页面并相互传递数据", String.valueOf(R.drawable.banana_pic),"invokeAndPassData"},
                { "控件", String.valueOf(R.drawable.orange_pic),"Widget"},
                { "统一头部布局", String.valueOf(R.drawable.watermelon_pic),"includeXML"},
                { "QQ消息发送", String.valueOf(R.drawable.pear_pic),"qqmsg"}
        };
        for (int i = 0; i < aryItem.length; i++) {
            Fruit baidu = new Fruit(aryItem[i][0], Integer.parseInt(aryItem[i][1]),aryItem[i][2]);
            fruitList.add(baidu);






            //拨号
            /* Fruit telephone = new Fruit("tel拨号", R.drawable.apple_pic,"tel");
            fruitList.add(telephone);

           Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);*/
        }
    }



    //重写onActivityResult方法，接收调用页面返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TO_RECEIVEDATA_ACTIVITY :
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("返回值为：",returnedData);
//                    Toast.makeText(this,returnedData, Toast.LENGTH_LONG).show();
                    ListView listView = (ListView) findViewById(R.id.list_view);
                    //View view = (View) listView.getChildAt(1);
                    FruitAdapter adapter= (FruitAdapter) listView.getAdapter();
                    Fruit fruit = (Fruit) adapter.getItem(2);
                    fruit.setName(fruit.getName().toString()+returnedData);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this,fruit.getName(), Toast.LENGTH_LONG).show();
//                    for (int i = 0; i <listView.getChildCount() ; i++) {  }
                }
                break;
            default:
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.fruitList.clear();
    }


    //保存临时数据，可以在oncreate方法里重新取得。
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("value_key","value_value");

    }


} //end
