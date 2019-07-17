package com.example.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

/**
 * Created by dell on 2019/7/15.
 */

public class MyAnimView extends View {

    public static final float RIDIUS = 50f;

    private Point curPoint;

    private Paint mPaint;

    public MyAnimView(Context context, AttributeSet attr){
        super(context, attr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas){
        if(curPoint == null){
            curPoint = new Point(RIDIUS, RIDIUS);
            drawCircle(canvas);
            startAnimation();
        }else{
            drawCircle(canvas);
        }
    }

    private void drawCircle( Canvas canvas){
        float x = curPoint.getX();
        float y = curPoint.getY();
        canvas.drawCircle(x, y, RIDIUS, mPaint);
    }

    private void startAnimation() {
        Point startPoint = new Point(getWidth()/2 - RIDIUS, RIDIUS);
        Point endPoint = new Point(getWidth()/2 - RIDIUS, getHeight() - RIDIUS);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                curPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setInterpolator(new BounceInterpolator());
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(anim2);
        animSet.setDuration(6000);
        animSet.start();
    }

    private String color;

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

}
