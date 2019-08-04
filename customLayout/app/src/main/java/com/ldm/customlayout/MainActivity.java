package com.ldm.customlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CustomDatePre presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // presenter = findViewById(R.id.custMyView);
       // presenter.setCustView(new CustomModel(R.drawable.ic_desktop_windows_black_24dp,"이동명","010-1234-5678"));
    }
}
