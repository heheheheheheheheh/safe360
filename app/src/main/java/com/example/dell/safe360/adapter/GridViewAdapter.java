package com.example.dell.safe360.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.safe360.R;
import com.example.dell.safe360.bean.ItemMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @version ${Rev}
 * @auther liucz
 * @time 2017/2/23 14:59
 * @des ${TODO}
 * @updateAuther ${Auther}
 * @updateDate ${Date} 14:59
 * @updateDes ${TODO}
 * Created by dell on 2017/2/23.
 */

public class GridViewAdapter extends BaseAdapter {
    private ArrayList<ItemMain> mItemShows;
    private Context mContext;

    public GridViewAdapter(Context context, List<ItemMain> itemShows) {
        mItemShows = (ArrayList) itemShows;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItemShows.size();
    }

    @Override
    public ItemMain getItem(int i) {
        return mItemShows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHold viewHold;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_main, null);
            viewHold = new ViewHold(convertView);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        ItemMain itemMain = getItem(position);
        viewHold.tv_item_main_title.setText(itemMain.title);
        viewHold.tv_item_main_content.setText(itemMain.content);
        viewHold.iv_item_main_icon.setImageResource(itemMain.icon);
        return convertView;
    }

    class ViewHold {
        public TextView tv_item_main_title;
        public TextView tv_item_main_content;
        public ImageView iv_item_main_icon;

        public ViewHold(View convertView) {
            tv_item_main_title = (TextView) convertView.findViewById(R.id.tv_item_main_title);
            tv_item_main_content = (TextView) convertView.findViewById(R.id.tv_item_main_content);
            iv_item_main_icon = (ImageView) convertView.findViewById(R.id.iv_item_main_icon);
        }
    }
}
