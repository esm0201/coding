package com.ldm.a0818activityreslist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static int count = 1;
    static final int NETWORK_SETTING_REQUEST = 1000;
    CustomList adapter;
    ListView list;
    ArrayList<SettingData> mListSetting = new ArrayList<>();

    public class SettingData{
        String name;
        String ip;
        String port;

        public SettingData(String name, String ip,String port){
            this.name = name;
            this.ip = ip;
            this.port = port;
        }

        public String getName() {return name; }
        public String getIp() {return ip; }
        public String getPort() {return port; }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomList(this);
        list = findViewById(R.id.list);
       list.setAdapter(adapter);
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
               SettingData item = (SettingData)parent.getItemAtPosition(position);
               Toast.makeText(getBaseContext(),item.getName(),Toast.LENGTH_SHORT).show();
               connectNetwork(item.getName());
           }
       });

       list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long ld) {
               String item = parent.getItemAtPosition(position).toString();
               deleteItem(item,position);
               return true;
           }
       });


    }
    public void deleteItem(String data, final int pos){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("선택한 목록을 삭제하시겠습니까?");
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListSetting.remove(pos);
                adapter.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void connectNetwork(String data){
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_dlg_layout,null);
        TextView customTitle = view.findViewById(R.id.custonTitle);
        customTitle.setText("["+data+"]"+"설정한 네트웍 정보로 접속하시겠습니까?");
        customTitle.setTextColor(Color.BLACK);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
