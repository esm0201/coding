package com.ldm.togglebtn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnToggle;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnToggle = findViewById(R.id.btnToggle);

        textView.setTextColor(Color.rgb(0,0,0));


        if(savedInstanceState != null){
            Log.d("LDMFIND","onCreate");
            savedInstanceState.getString("msg");
            savedInstanceState.putString("msg",textView.getText().toString());
            System.out.println(textView.getText().toString());
            saveInstance(savedInstanceState);
        }
    }
    protected void saveInstance(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("msg",textView.getText().toString());
    }
    public void onPowerOnOff(View v){
        boolean on = ((ToggleButton) v).isChecked();
        if(on==true){
            textView.setText("으아 눌러졌다");
            textView.setTextColor(Color.rgb(50,0,0));
            btnToggle.setBackgroundResource(R.drawable.power_on);
        }
        else{
            textView.setText("으아 으아");
            textView.setTextColor(Color.rgb(50,0,0));
            btnToggle.setBackgroundResource(R.drawable.power_off);
        }
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LDM","RESTORE");
        String str = savedInstanceState.getString("msg");
        textView.setText(str);
        if(str.equals("으아 눌러졌다")){
            textView.setTextColor(Color.rgb(50,0,0));
            btnToggle.setBackgroundResource(R.drawable.power_on);
        }
        else{
            textView.setTextColor(Color.rgb(50,0,0));
            btnToggle.setBackgroundResource(R.drawable.power_off);
        }
    }
}
