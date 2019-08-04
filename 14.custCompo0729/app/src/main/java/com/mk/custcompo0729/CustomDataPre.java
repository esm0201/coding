package com.mk.custcompo0729;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDataPre extends LinearLayout {
    private ImageView img;
    private TextView name, tel;

    private Drawable attrimgsrc;
    private String attrname,attrtel;
    public CustomDataPre(Context context) {
        super(context);
        init(context);
    }

    public CustomDataPre(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    // View 추가
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("hack4ork", "onAttachedToWindow()");
    }

    // ViewGroup 또는 View의 크기와 위치를 계산.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("hack4ork", "onMeasure()");
    }

    // ViewGropu에서 하위View들에대한 크기와 위치를 할당.
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.d("hack4ork", "onLayout()");
    }

    // View의 크기가 변경되었을때 호출.
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("hack4ork", "onSizeChanged()");
    }

    // View를 그릴때 호출
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("hack4ork", "onDraw()");
    }

    // View 제거
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("hack4ork", "onDetachedFromWindow()");
    }

    private void init(Context context) {
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_layout, this, true);
        img = findViewById(R.id.imgFace);
        name = findViewById(R.id.name);
        tel = findViewById(R.id.tel);
    }

    private void init(Context context, AttributeSet attr) {

        TypedArray attributes = context.obtainStyledAttributes(attr,R.styleable.CustomDataPre);
        attrname = attributes.getString(R.styleable.CustomDataPre_attrName);
        attrtel = attributes.getString(R.styleable.CustomDataPre_attrTel);
        attrimgsrc = attributes.getDrawable(R.styleable.CustomDataPre_attrImgsrc);
        attributes.recycle();
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_layout, this, true);
        img = findViewById(R.id.imgFace);
        if(img!=null){
            setAttrimgsrc(attrimgsrc);
        }

        name = findViewById(R.id.name);
        tel = findViewById(R.id.tel);
    }

    public void setCustView(CustomModel data) {
        img.setImageResource(data.getImgPath());
        name.setText(data.getName());
        tel.setText(data.getTel());
    }

   public void setAttrimgsrc(Drawable attrimgsrc){
        this.attrimgsrc = attrimgsrc;
        img.setImageDrawable(attrimgsrc);
   }
}