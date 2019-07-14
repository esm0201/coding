package com.ldm.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edText;
    Button btnShowText;
    Button btnOpenPage;
    RadioButton radioOreo,radioPie;
    RadioGroup radioGroup;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_7);

        edText = findViewById(R.id.editText);
        btnShowText = findViewById(R.id.btnShowText);
        btnOpenPage = findViewById(R.id.btnOpenPage);
        radioGroup = findViewById(R.id.radioGroup);
        radioOreo =findViewById(R.id.radioOreo);
        radioPie = findViewById(R.id.radioPie);
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.android);

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
    }
}
