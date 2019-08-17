package com.ldm.a0817signup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int LOGIN_CODE = 1158;
    TextView textViewID,textViewPW,textViewName,textViewBirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewID = findViewById(R.id.textView_ID);
        textViewPW= findViewById(R.id.textView_PW);
        textViewName= findViewById(R.id.textView_Name);
        textViewBirth= findViewById(R.id.textView_Birth);;
        Button button_Sign = findViewById(R.id.button_Sign);

        button_Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivityForResult(intent,LOGIN_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==LOGIN_CODE){
            if(resultCode==RESULT_OK){
                textViewID.setText(data.getStringExtra("INPUT_ID"));
                textViewPW.setText(data.getStringExtra("INPUT_PW"));
                textViewName.setText(data.getStringExtra("INPUT_NAME"));
                textViewBirth.setText(data.getStringExtra("INPUT_BIRTH"));
                Toast.makeText(this,"회원가입 성공!",Toast.LENGTH_SHORT).show();
            }
            else if(resultCode==RESULT_CANCELED){
                Toast.makeText(this,"회원가입 실패!",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
