package com.ldm.project4_2;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chBoxStart;
    Button btnSelect,btnReset;
    RadioGroup radioGroup;
    RadioButton radioDog,radioCat,radioRabbit;
    ImageView imageView;
    LinearLayout layout2;
    Switch switchStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Intent intent = new Intent(this,splash.class);
       // startActivity(intent);
        switchStart = findViewById(R.id.switchStart);
        layout2 = findViewById(R.id.layout2);
        btnSelect = findViewById(R.id.btnSelect);
        radioDog = findViewById(R.id.radioDog);
        radioCat = findViewById(R.id.radioCat);
        radioRabbit = findViewById(R.id.radioRabbit);
        imageView = findViewById(R.id.imageView);
        btnReset = findViewById(R.id.btnReset);
        layout2.setVisibility(View.INVISIBLE);
        chBoxStart = findViewById(R.id.chBoxStart);

        chBoxStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chBoxStart.isChecked()) {
                    layout2.setVisibility(View.VISIBLE);
                    switchStart.setChecked(true);
                }
                else {
                    layout2.setVisibility(View.INVISIBLE);
                    switchStart.setChecked(false);
                }
            }
        });

        switchStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchStart.isChecked()) {
                    layout2.setVisibility(View.VISIBLE);
                    chBoxStart.setChecked(true);
                }
                else {
                    layout2.setVisibility(View.INVISIBLE);
                    chBoxStart.setChecked(false);
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioDog.isChecked())
                    imageView.setImageResource(R.drawable.dog);
                else if(radioCat.isChecked())
                    imageView.setImageResource(R.drawable.cat);
                if(radioRabbit.isChecked())
                    imageView.setImageResource(R.drawable.rabbit);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }
}
