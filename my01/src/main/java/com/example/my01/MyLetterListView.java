package com.example.my01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by lenvov on 2017/11/13.
 */

public class MyLetterListView  extends ListView{

    String[] b = {"A","B","C","D","E","F"};
    int choose = -1;
    Paint paint = new Paint();
    boolean showbkg = false;


    public MyLetterListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLetterListView(Context context) {
        super(context);
    }

    public MyLetterListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint = new Paint();// new一个画笔
        paint.setColor(Color.RED);// 设置画笔颜色
        paint.setStyle(Paint.Style.FILL);// 设置画笔填充
        canvas.drawCircle(50, 150, 60, paint);// 用画笔在画布上添加一个圆，不只可以添加圆，还可以添加矩形等！
        paint.setColor(Color.WHITE);// 设置画笔颜色
        canvas.drawText("A", 50, 150, paint);// 用画笔在画布上添加文字，中间两个参数对应的是坐标。


        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(50, 300, 60, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("B", 50, 300, paint);

        //paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(50, 450, 60, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("C", 50, 450, paint);

        //paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(50, 600, 60, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("D", 50, 600, paint);

        //paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(50, 750, 60, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText("E", 50, 750, paint);

        //paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("aaaaaaaaaaaaaaaaaaaaaaa",200,150,paint);
        paint.setColor(Color.BLACK);

        //paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("bbbbbbbbbbbbbbbbbbbbbbb",200,300,paint);
        paint.setColor(Color.BLACK);

        //paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("ccccccccccccccccccccccc",200,450,paint);
        paint.setColor(Color.BLACK);

        //paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("ddddddddddddddddddddddd",200,600,paint);
        paint.setColor(Color.BLACK);

        //paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("eeeeeeeeeeeeeeeeeeeeeee",200,750,paint);
        paint.setColor(Color.BLACK);


        //paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,810,1000,810,paint);

//        paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,660,1000,660,paint);

//        paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,510,1000,510,paint);

//        paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,360,1000,360,paint);

//        paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,210,1000,210,paint);


    }


}
