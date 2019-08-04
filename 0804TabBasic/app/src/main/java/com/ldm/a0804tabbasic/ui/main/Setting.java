package com.ldm.a0804tabbasic.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ldm.a0804tabbasic.R;

public class Setting extends Fragment {

    Button wifiBtn,cameraBtn;
    Context settingContext;
    static int N = 10;
    public Setting(){}

    public static Setting newInstance(){
        Setting fragment = new Setting();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting,container,false);
        settingContext = container.getContext();
        wifiBtn = rootView.findViewById(R.id.btnWifi);
        wifiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(settingContext, "wifi설정"+N, Toast.LENGTH_SHORT).show();
                Log.d("LDMCHECK","wifi설정...");
            }
        });

        cameraBtn = rootView.findViewById(R.id.btnCamera);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                N++;
                Toast.makeText(settingContext, "버튼설정", Toast.LENGTH_SHORT).show();
                Log.d("LDMCHECK","wifi설정...");
            }
        });
        return rootView;
    }
}
