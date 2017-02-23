package com.example.dell.safe360.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.safe360.R;

/**
 * @version ${Rev}
 * @auther liucz
 * @time 2017/2/23 17:03
 * @des ${TODO}
 * @updateAuther ${Auther}
 * @updateDate ${Date} 17:03
 * @updateDes ${TODO}
 * Created by dell on 2017/2/23.
 */

public class SettingItemButton extends RelativeLayout {
    private AttributeSet attrs;
    private Context mContext;
    private TextView mTv_setting_item_layout_title;
    private ImageView mIv_setting_item_layout_flag;
    private boolean isOpen;

    public SettingItemButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        this.attrs = attrs;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.setting_item_layout, null);
        addView(view);
        mTv_setting_item_layout_title = (TextView) view.findViewById(R.id.tv_setting_item_layout_title);
        mIv_setting_item_layout_flag = (ImageView) view.findViewById(R.id.iv_setting_item_layout_flag);
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.SettingItemButton);
        String title = typedArray.getString(R.styleable.SettingItemButton_sib_title);
        boolean isOpen = typedArray.getBoolean(R.styleable.SettingItemButton_open_status, false);
        typedArray.recycle();
        //设置当前控件名称
        if (title != null) {
            //设置当前显示的名称
            mTv_setting_item_layout_title.setText(title);
        }

        //根据当前的状态去动态显示按钮状态
        if (isOpen) {
            //打开的状态
            mIv_setting_item_layout_flag.setImageResource(R.drawable.on);
        } else {
            //关闭的状态
            mIv_setting_item_layout_flag.setImageResource(R.drawable.off);
        }
    }

    //设置当前显示的状态图片

    /**
     * @param flag当前的状态
     */
    public void setFlagImage(boolean flag) {
        if (flag) {
            //打开的状态
            mIv_setting_item_layout_flag.setImageResource(R.drawable.on);

        } else {
            //关闭的状态
            mIv_setting_item_layout_flag.setImageResource(R.drawable.off);
        }
        //更改当前的状态
        isOpen = flag;
    }

    //更改当前的状态
    public boolean toggle() {
        /**
         * 如果你是打开,点击后就关闭
         * 如果你是关闭的,我点击就是打开
         */
        if (isOpen) {
            //关闭
            isOpen = false;
        } else {
            //打开
            isOpen = true;
        }
        //更改当前的状态显示
        setFlagImage(isOpen);
        return isOpen;
    }
}
