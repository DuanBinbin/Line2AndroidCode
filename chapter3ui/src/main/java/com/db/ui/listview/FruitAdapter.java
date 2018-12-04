package com.db.ui.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.db.ui.R;

import java.util.List;

/**
 * @描述：     @自定义适配器,这个部分牵涉到ListView优化问题，重点理解
 * @作者：     @Bin
 * @创建时间： @2018/11/9 16:42
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);    //获取当前项的Fruit实例

        View view;
        ViewHolder viewHolder;
        if (null == convertView){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.fruitImage   = view.findViewById(R.id.fruit_image);
            viewHolder.fruitName    = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);    //将ViewHolder存储在View中
        } else {
            //对convertView进行重用，可以提高ListView的运行效率
            view        = convertView;
            viewHolder  = (ViewHolder) view.getTag();   // 重新获取ViewHolder
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

    /**
     * 用于对控件的实例进行缓存
     */
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
