package com.example.wjq.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wjq.app.R;
import com.example.wjq.app.entityclass.Fruit;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    /**
     * 在listview每个子项被滚动到屏幕内的时候会被调用。
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);//为当前滚动到的子项加载布局resourceId即为自定义的R.layout.fruit_item
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById (R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById (R.id.fruit_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder {

        ImageView fruitImage;

        TextView fruitName;

    }

}
