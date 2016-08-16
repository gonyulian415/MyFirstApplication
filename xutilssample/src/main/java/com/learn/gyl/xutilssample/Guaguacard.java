package com.learn.gyl.xutilssample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 2016/8/3.
 */
public class Guaguacard extends View{
    private Paint paint = new Paint();   //画笔1
    private Paint paint2 = new Paint();
    private Path path;//描绘路径
    private Canvas canvas;//画布
    private int mLastX;//最终横坐标
    private int mLastY;//最终纵坐标
    private Bitmap bitmap;//bmp图片,背景图
    private Bitmap bitmap2;//奖图
    private Rect rect = new Rect();
    public Guaguacard(Context context) {
        this(context,null);
    }

    public Guaguacard(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public Guaguacard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.drawBitmap(bitmap2,getWidth()/3,getHeight()/2,null);
        //drawPath();
        canvas.drawBitmap(bitmap, 0, 0, null);
        drawPath();
    }

    private void drawPath() {
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(50);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawPath(path, paint2);
    }
    private void setBackPaint(){
        paint2.setColor(Color.parseColor("#c0c0c0"));
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeJoin(Paint.Join.ROUND); // 圆角
        paint2.setStrokeCap(Paint.Cap.ROUND); // 圆角
        paint2.setStrokeWidth(20);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.al_);
        //bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mimi).copy(Bitmap.Config.ARGB_8888,true);
        //bitmap = BitmapFactory.decodeStream()
        canvas = new Canvas(bitmap);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);//抗锯齿,平滑
        paint.setDither(true);//抖动
        paint.setStyle(Paint.Style.STROKE);//划
        paint.setStrokeJoin(Paint.Join.ROUND);//圆角
        paint.setStrokeCap(Paint.Cap.ROUND);//圆角
        paint.setStrokeWidth(20);//画笔宽度
        //画遮盖
        paint2.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(0, 0, width, height), 30, 30, paint2);
        canvas.drawColor(Color.parseColor("#000000"));
    }

    private void init() {
        path = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                path.moveTo(mLastX,mLastY);
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = Math.abs(x - mLastX);
                int dy = Math.abs(y - mLastY);
                if (dx > 3 || dy > 3){
                    path.lineTo(x,y);
                }
                mLastX = x;
                mLastY = y;
                break;
        }
        invalidate();
        return true;
    }
}
