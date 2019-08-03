package com.ldm.custcomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VolumnControlView extends AppCompatImageView implements View.OnTouchListener {
    private double angle = 0.0;
    private KnobListener listener;
    float x,y;
    float mx,my;

    public interface KnobListener{
        public void onChanged(double angle);
    }

    public void setKnobListener(KnobListener listener) {
        this.listener = listener;
    }

    public VolumnControlView(Context context) {
        super(context);
        this.setImageResource(R.drawable.knob);
        this.setOnTouchListener(this);
    }
    public VolumnControlView(Context context, AttributeSet attrs) {
        super(context,attrs);
        this.setImageResource(R.drawable.knob);
        this.setOnTouchListener(this);
    }

    private double getAngle(float x, float y){
        mx = x-(getWidth()/2.0f);
        my = (getHeight()/2.0f)-y;

        double degree = Math.atan2(mx,my)*180.0/Math.PI;
        return degree;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        x = event.getX(0);
        y = event.getY(0);
        angle = getAngle(x,y);
        invalidate();
        listener.onChanged(angle);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        canvas.save();
        canvas.rotate((float)angle,getWidth()/2,getHeight()/2);
        super.onDraw(canvas);
        canvas.restore();
    }
}
