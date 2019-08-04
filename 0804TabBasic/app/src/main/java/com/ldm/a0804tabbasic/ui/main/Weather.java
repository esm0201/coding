package com.ldm.a0804tabbasic.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldm.a0804tabbasic.R;

public class Weather extends Fragment {
    public Weather(){}

    public static Weather newInstance(){
        Weather fragment = new Weather();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather,container,false);
        return rootView;
    }
}
