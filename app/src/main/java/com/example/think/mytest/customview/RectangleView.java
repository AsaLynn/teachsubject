package com.example.think.mytest.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by think on 2017/11/2.
 * 自定义控件
 */

public class RectangleView extends View {

    public RectangleView(Context context) {
        this(context,null);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RectangleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
}
