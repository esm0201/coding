package com.ldm.a0818activityreslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Setting extends AppCompatActivity {

    EditText mName,mIP,mPort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mName = findViewById(R.id.setting_name);
        mIP = findViewById(R.id.setting_IP);
        mPort = findViewById(R.id.setting_port);
    }

    public void onSave(View v){
        Intent intent = new Intent();
        intent.putExtra("NETWORK_NAME",mName.getText().toString());
        intent.putExtra("NETWORK_IP",mIP.getText().toString());
        intent.putExtra("NETWORK_PORT",mPort.getText().toString());
        setResult(RESULT_OK);
        finish();
    }

    public void onCancel(View v)
    {
        finish();
    }
}
