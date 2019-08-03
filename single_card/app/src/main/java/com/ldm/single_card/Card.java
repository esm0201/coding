package com.ldm.single_card;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Card extends LinearLayout {
    String strTitle;
    String strDesc;
    String strNavi;
    int imgSrc;

    TextView viewTitle, viewDesc, viewNavi;
    ImageView imgView;

    public Card(Context context, AttributeSet attr){
        super(context,attr);

        TypedArray attributes = context.obtainStyledAttributes(attr,R.styleable.card);
        strTitle = attributes.getString(R.styleable.card_title);
        strDesc = attributes.getString(R.styleable.card_description);
        strNavi = attributes.getString(R.styleable.card_navigation_text);

        Drawable drawable = attributes.getDrawable(R.styleable.card_src);
        attributes.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.single_card,this,true);

        imgView = findViewById(R.id.card_image);
        imgView.setImageDrawable(drawable);

        viewTitle = findViewById(R.id.title);
        viewTitle.setText(strTitle);

        viewDesc = findViewById(R.id.description);
        viewDesc.setText(strDesc);

        viewNavi = findViewById(R.id.navigate);
        viewNavi.setText(strNavi);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("<<LDMCHECK>>","onAttachedToWindow");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("<<LDMCHECK>>","onMeasure ");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.d("<<LDMCHECK>>","onLayout");
    }

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
        viewTitle.setText(strTitle);
    }

    public String getStrDesc() {
        return strDesc;
    }

    public void setStrDesc(String strDesc) {
        this.strDesc = strDesc;
        viewDesc.setText(strDesc);
    }

    public String getStrNavi() {
        return strNavi;
    }

    public void setStrNavi(String strNavi) {
        this.strNavi = strNavi;
        viewNavi.setText(strNavi);
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
        imgView.setImageResource(imgSrc);
    }

    public TextView getViewTitle() {
        return viewTitle;
    }

    public void setViewTitle(TextView viewTitle) {
        this.viewTitle = viewTitle;
    }

    public TextView getViewDesc() {
        return viewDesc;
    }

    public void setViewDesc(TextView viewDesc) {
        this.viewDesc = viewDesc;
    }

    public TextView getViewNavi() {
        return viewNavi;
    }

    public void setViewNavi(TextView viewNavi) {
        this.viewNavi = viewNavi;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public void setImgView(ImageView imgView) {
        this.imgView = imgView;
    }
}
