package com.example.frameanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by dell on 2019/7/13.
 */

public class FrameView extends ImageView {

    private AnimationDrawable anim;

    public FrameView(Context context) {
        super(context);
    }

    public FrameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FrameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAnim(AnimationDrawable anim){
        this.anim = anim;
    }

    public void setLocation(int top,int left){
        this.setFrame(left,top,left + 200,top + 200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try{
            //反射调用AnimationDrawable里的mCurFrame值
            Field field = AnimationDrawable.class
                    .getDeclaredField("mCurFrame");
            field.setAccessible(true);
            int curFrame = field.getInt(anim);// 获取anim动画的当前帧
            if (curFrame == anim.getNumberOfFrames() - 1)// 如果已经到了最后一帧
            {
                //让该View隐藏
                setVisibility(View.INVISIBLE);
            }
        }catch (Exception e){e.printStackTrace();}
        super.onDraw(canvas);
    }
}
