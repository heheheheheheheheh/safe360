package com.example.dell.safe360.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewDebug.ExportedProperty;
import android.widget.TextView;

/**
 * 跑马灯的textView
 * @Description: TODO
 * @author heima_sy
 * @date 2016-1-1 上午11:06:08
 */
public class MarqueeTextView extends TextView {
    
    /*    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
           System.out.println("当前super(context, attrs, defStyle);");
        }*/
    
    private static final String TAG = null;
    
    /**
     * xml布局时调用
     * @param context
     * @param attrs
     */
    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        System.out.println("当前super super(context, attrs);");
    }
    
    /**
     * 在代码中初始化的
     * @param context
     */
    public MarqueeTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        System.out.println("当前super(context);");
    }
    
    /**
     * 当前控件的焦点,第一次xml加载 的时候
     */
    @Override
    @ExportedProperty(category = "focus")
    public boolean isFocused() {
        return true;//告诉我们的系统 ,我们一直有焦点的
    }
    
    //更改焦点时,有别的控件申请焦点的时候 
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        
        Log.i(TAG, "当前焦点更改了+" + focused);
        if (focused) {//有焦点
            super.onFocusChanged(focused, direction, previouslyFocusedRect);            
        }
    }
    
    //弹出对话框的时候
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
       if (hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);   
    }
    }
}
