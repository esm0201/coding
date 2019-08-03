package com.ldm.customlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDatePre extends LinearLayout {
    private ImageView img;
    private TextView name,tel;

    public CustomDatePre(Context context){
        super(context);
        init(context);
    }

    public CustomDatePre(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("<<LDMCHECK>>","onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.d("<<LDMCHECK>>","onLayout");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("<<LDMCHECK>>","onAttachedToWindow");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("<<LDMCHECK>>","onSizeChanged");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_layout,this,true);
        img = findViewById(R.id.imageFace);
        name = findViewById(R.id.name);
        tel = findViewById(R.id.tel);
    }
    private void init(Context context, AttributeSet attr){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_layout,this,true);
        img = findViewById(R.id.imageFace);
        name = findViewById(R.id.name);
        tel = findViewById(R.id.tel);
    }

    public void setCustView(CustomModel data){
        img.setImageResource(data.getImgPath());
        name.setText(data.getName());
        tel.setText(data.getTel());
    }
}
