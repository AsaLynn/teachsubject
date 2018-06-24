package com.example.think.mytest.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.think.mytest.R;
import com.example.think.mytest.utils.Utils;

/**
 * Created by think on 2017/10/31.
 */
/*
创建自定义view
1,继承view
2,重新构造方法
3,自定义属性
4,解析属性
5,重写ondraw方法

 */
public class RainbowBar extends View {

    //控件颜色
    int barColor = Color.parseColor("#1E88E5");
    //控件中的单个条横向长度
    int hSpace ;
    //控件高度
    int vSpace ;
    //单条之间的间隙
    int space;
    //起始坐标
    float startX = 0;
    float delta = 10f;
    Paint mPaint;

    //代码中使用
    public RainbowBar(Context context) {
        this(context,null);
    }

    //xml布局中使用
    public RainbowBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    //xml布局文件中使用,增加style属性设置
    public RainbowBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        hSpace =Utils.dp2px(this.getContext(),80);
        vSpace =Utils.dp2px(this.getContext(),4);
        space =Utils.dp2px(this.getContext(),20);

        TypedArray t = context.obtainStyledAttributes(attrs,
                R.styleable.RainbowBar, 0, 0);
        hSpace = t.getDimensionPixelSize(R.styleable.RainbowBar_rainbowbar_hspace, hSpace);
        vSpace = t.getDimensionPixelOffset(R.styleable.RainbowBar_rainbowbar_vspace, vSpace);
        barColor = t.getColor(R.styleable.RainbowBar_rainbowbar_color, barColor);
        t.recycle();   // we should always recycle after used

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(barColor);
        mPaint.setStrokeWidth(vSpace);
    }

    //因为我们这里不用关注measrue和layout过程，直接重写onDraw方法即可

    @Override
    protected void onDraw(Canvas canvas) {
        //控件总宽度
        float sw = this.getMeasuredWidth();
        if (startX >= sw + (hSpace + space) - (sw % (hSpace + space))) {
            startX = 0;
        } else {
            startX += delta;
        }
        float start = startX;
        while (start < sw) {
            //drawLine(float startX, float startY, float stopX, float stopY,Paint paint)
            canvas.drawLine(start, 5, start + hSpace, 5, mPaint);
            start += (hSpace + space);
        }
        start = startX - space - hSpace;
        while (start >= -hSpace) {
            canvas.drawLine(start, 5, start + hSpace, 5, mPaint);
            start -= (hSpace + space);
        }

        //invalidate();
    }

    /*
    其实就是调用canvas的drawLine方法，然后每次将draw的起点向前推进，在方法的结尾，
    我们调用了invalidate方法，上面我们已经说明了，这个方法会让View重新调用onDraw方法，
    所以就达到我们的进度条一直在向前绘制的效果。
     */
}
