package com.example.viewmodeldemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @ProjectName: MVVMDemo
 * @Package: com.example.liviedatademo
 * @ClassName: MyView
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/3/25 18:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/25 18:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyView extends View {
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;

    PorterDuffXfermode srcInXfremod = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    PorterDuffXfermode dstAtopXfremod = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);

    private int totalNode = 4;
    private float diameter = 20F;
    private float linkLength = 56F;

    Context context;
    private Bitmap bitmap;
    private int arrivedNode = 3;
    private RectF rectF = new RectF(0, 0, 0, 0);

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.my_course_progress);
        paint1 = new Paint();
        paint1.setColor(Color.parseColor("#8CD893"));
        paint1.setAntiAlias(true);

        paint2 = new Paint();
        paint2.setColor(Color.parseColor("#ECEFF5"));
        paint2.setAntiAlias(true);

        paint3 = new Paint();
        paint3.setColor(Color.WHITE);
        paint3.setAntiAlias(true);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = measureWidth(getSuggestedMinimumWidth(), widthMeasureSpec);
        int height = measureHeight(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureHeight(int suggestedMinimumHeight, int heightMeasureSpec) {
        int height = suggestedMinimumHeight;

        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (specMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                height = (int) diameter;
                break;
            case MeasureSpec.EXACTLY:
                height = specSize;
                break;
        }
        return height;
    }

    private int measureWidth(int suggestedMinimumWidth, int widthMeasureSpec) {
        int width = suggestedMinimumWidth;

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        if (linkLength == 0F) {
            linkLength = (diameter * 34 / 20);
        }

        switch (specMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = (int) (diameter * totalNode + (totalNode - 1) * linkLength);
                break;
            case MeasureSpec.EXACTLY:
                width = specSize;
                break;
        }
        return width;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.GREEN);

        float x = 0F;
        float arcHeight = diameter * 8 / 20;
        float arcStartY = (diameter - arcHeight) / 2;

        float joint = 0.04F * diameter;

        int save = 0;
        for (int i = 0; i <= arrivedNode; i++) {
            if (i != 0) {
                canvas.drawRect(x - joint, arcStartY, x + linkLength + joint, arcStartY + arcHeight, paint1);
                x += linkLength;
            }

            save = canvas.saveLayer(x, 0F, x + diameter, getHeight(), paint1);
            paint3.setXfermode(srcInXfremod);
            canvas.drawCircle(x + diameter / 2, diameter / 2, diameter / 2, paint1);
            rectF.set(x, 0F, x + diameter, getHeight());
            canvas.drawBitmap(bitmap, null, rectF, paint3);
            canvas.restoreToCount(save);
            x += diameter;
        }


        if (arrivedNode == 0) {
            canvas.drawCircle(x + diameter / 2, diameter / 2, diameter / 2, paint2);
            x += diameter;
        }
//        for (i in arrivedNode until totalNode){
//        save = it.saveLayer(x - joint, arcStartY, x + linkLength + joint, arcStartY + arcHeight, noArrivedPaint)
//        noArrivedPaint.xfermode = dstAtopXfremod
//        it.drawCircle(x - diameter / 2, diameter / 2, diameter / 2, noArrivedPaint)
//        it.drawRect(x - joint, arcStartY, x + linkLength + joint, arcStartY + arcHeight, noArrivedPaint)
//        it.restoreToCount(save)
//        noArrivedPaint.xfermode = null
//        x += linkLength
//        it.drawCircle(x + diameter / 2, diameter / 2, diameter / 2, noArrivedPaint)
//        x += diameter
//    }
    }
}
