package com.ldm.a0817activityresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1000;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        text = findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                startActivityForResult(intent,GET_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==GET_STRING){
            if(resultCode==RESULT_OK){
                text.setText(data.getStringExtra("INPUT_TEXT"));
                int num = 0;
                Log.d("LDMCHECK","INPUT값 = "+data.getIntExtra("INPUT_INT",num));
            }
            else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this,"서브액티비티에서 취소됨",Toast.LENGTH_SHORT).show();

            }
        }
    }
}
