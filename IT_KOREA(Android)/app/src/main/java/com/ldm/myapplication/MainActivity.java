package com.ldm.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText edText;
    Button btnShowText, btnCurrentTime;
    Button btnOpenPage;
    RadioButton radioOreo,radioPie;
    RadioGroup radioGroup;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_7);

        edText = findViewById(R.id.editText);
        btnCurrentTime = findViewById(R.id.btnCurrentTime);
        btnShowText = findViewById(R.id.btnShowText);
        btnOpenPage = findViewById(R.id.btnOpenPage);
        radioGroup = findViewById(R.id.radioGroup);
        radioOreo =findViewById(R.id.radioOreo);
        radioPie = findViewById(R.id.radioPie);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.android);


        btnCurrentTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date now = new Date();
                SimpleDateFormat sFormat = new SimpleDateFormat("a HH:MM:SS");
                Toast.makeText(getApplicationContext(), sFormat.format(now), Toast.LENGTH_SHORT).show();
            }
        });
        btnShowText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), edText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnOpenPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edText.getText().toString();
                Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(intent);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioOreo) {
                    imageView.setImageResource(R.drawable.oreo);
                    Log.d("MainActicity","BtnRadio checked");
                }
                else if(checkedId==R.id.radioPie)
                    imageView.setImageResource(R.drawable.pie);
            }
        });
/*
        radioOreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.oreo);
            }
        });

        radioPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.pie);
            }
        });
*/
    }
}
