package com.ldm.a0804tabbasic.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldm.a0804tabbasic.R;

public class Noti extends Fragment {
    public Noti(){

    }

    public static Noti newInstance(){
        Noti fragment = new Noti();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_noti,container,false);
        return rootView;
    }
}
