package com.ldm.a0811multipage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MultiPageActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.button1:
                System.out.println("dqw");
                intent = new Intent(getApplicationContext(),introActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(getApplicationContext(),SetupActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(getApplicationContext(),StartActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                finish();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("<<LDMCHECK>>","MultiPageActivity_onStart()실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("<<LDMCHECK>>","MultiPageActivity_onResume()실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("<<LDMCHECK>>","MultiPageActivity_onPause()실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("<<LDMCHECK>>","MultiPageActivity_onStop()실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("<<LDMCHECK>>","MultiPageActivity_onDestroy()실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("<<LDMCHECK>>","MultiPageActivity_1onRestart()실행");
    }
}