package com.ldm.custcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.ldm.custcomponent.VolumnControlView view = findViewById(R.id.volume);
        view.setKnobListener(new com.ldm.custcomponent.VolumnControlView.KnobListener(){
            @Override
            public void onChanged(double angle){
                Log.d("<<LDNCHECK>>","angle: "+angle);
            }
        });
    }
}
