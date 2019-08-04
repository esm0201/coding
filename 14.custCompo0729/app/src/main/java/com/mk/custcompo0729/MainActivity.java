package com.mk.custcompo0729;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CustomDataPre[] presenter = new CustomDataPre[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //presenter[0] = findViewById(R.id.custMyView);
       // presenter[0].setCustView(new CustomModel(R.drawable.ic_contact_mail_black_24dp,"이동명","010-1234-5678"));

//        presenter[1] = findViewById(R.id.custMyView);
//        presenter[1].setCustView(new CustomModel(R.drawable.ic,"홍길동","010-4567-5678"));
    }
}