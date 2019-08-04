package com.ldm.graphicshape;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
}

class MyView extends View{
    public MyView(Context context){
        super(context);
        this.setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);

        canvas.drawColor(Color.rgb(255,200,255));

        canvas.drawRoundRect(new RectF(30,50,330,550),15,15,paint);

        paint.setColor(Color.RED);
        canvas.drawOval(new RectF(450,50,750,550),paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(new RectF(30,600,330,1100),360,1000,true,paint);


        float[] pts={30,1250,300,1350,300,1350,60,1450,60,1450,360,1500,360,1500,canvas.getMaximumBitmapWidth(),50};
        paint.setStrokeWidth(20);
        canvas.drawLines(pts,paint);
    }
}