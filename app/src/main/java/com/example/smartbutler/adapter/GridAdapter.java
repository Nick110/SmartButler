package com.example.smartbutler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.smartbutler.R;
import com.example.smartbutler.entity.GirlData;
import com.example.smartbutler.utils.L;
import com.example.smartbutler.utils.PicassoUtils;
import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by 杨少侠 on 2018/6/12.
 */

public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private List<GirlData> mList;
    private LayoutInflater inflater;
    private GirlData data;
    private WindowManager wm;
    //屏幕宽
    private int width;

    public GridAdapter(Context mContext, List<GirlData> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.girl_item,null);
            viewHolder.imageView = convertView.findViewById(R.id.imageview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        data = mList.get(position);
        //解析图片
        String url = data.getImgUrl();

        Picasso.with(mContext).load(url).into(viewHolder.imageView);
//        PicassoUtils.loadImageViewSize(mContext,url,width/2,500, viewHolder.imageView);

        return convertView;
    }

    class ViewHolder{
        private ImageView imageView;
    }
}