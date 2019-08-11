package com.ldm.a0811activityrank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Log.d("LDMCHECK","result.class 실행");
        Intent intent = getIntent();
        int voteResult[] = intent.getIntArrayExtra("카운트");
        String imageName[] = intent.getStringArrayExtra("ImageName");
        Log.d("LDMCHECK","result.class 실행2"+imageName.length);
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] =new RatingBar[imageName.length];
        Log.d("LDMCHECK","result.class 실행3");
        Integer tvID[] = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer RbarID[] = {R.id.ratingBar1,R.id.ratingBar2,R.id.ratingBar3,R.id.ratingBar4,R.id.ratingBar5,R.id.ratingBar6,R.id.ratingBar7,R.id.ratingBar8,R.id.ratingBar9};
        Log.d("LDMCHECK","result.class 실행4"+voteResult.length+"");
        for(int i = 0;i<voteResult.length;i++){
            tv[i] = findViewById(tvID[i]);
            Log.d("LDMCHECK","result.class 실행TT");
            rbar[i] = findViewById(RbarID[i]);
        }
        Log.d("LDMCHECK","result.class 실행5");
        for(int i = 0;i<voteResult.length;i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float)voteResult[i]);
        }
        Button btnReturn = findViewById(R.id.buttonReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
