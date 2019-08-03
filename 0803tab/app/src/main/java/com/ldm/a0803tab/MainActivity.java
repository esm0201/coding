package com.ldm.a0803tab;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static String FILENAME = "sample.txt";
    EditText edit;
    TextView fileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editText01);
        fileView = findViewById(R.id.fileView);

        Button btnIntRead = (Button) findViewById(R.id.intRead);
        btnIntRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fis = openFileInput(FILENAME);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fileView.setText(new String(buffer));
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        Button btnIntWrite = (Button) findViewById(R.id.intWrite);
        btnIntWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(edit.getText().toString().getBytes());
                    fos.close();
                    Log.d("LDMCHECK","내부 메모리에 쓰기");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)==false){
            Toast.makeText(this,"외부 스토리지 실패",Toast.LENGTH_SHORT).show();
        }

        Button btnExtRead = (Button) findViewById(R.id.extRead);
        btnExtRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null),FILENAME);
                try{
                    InputStream is = new FileInputStream(file);
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    fileView.setText(new String(buffer));
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        Button btnExtWrite = (Button) findViewById(R.id.extWrite);
        btnExtWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null),FILENAME);
                try{
                    OutputStream os = new FileOutputStream(file);
                    os.write(edit.getText().toString().getBytes());
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        Button btnRawRead = (Button) findViewById(R.id.rawRead);
        btnRawRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    InputStream is = getResources().openRawResource(R.raw.sample);
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    fileView.setText(new String(buffer));
                    is.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
