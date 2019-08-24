package com.ldm.a0824pretest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefs";
    TextView name;
    EditText value;
    String imageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textView01);
        value = findViewById(R.id.editText01);

        //프리퍼런스를 복원한다.
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        imageName = settings.getString("imageName","");
        value.setText(imageName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LDMCHECK","onstop.....");
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        imageName = value.getText().toString();
        editor.putString("imageName",imageName);
        editor.commit();

        /*
        //키값 삭제
        editor.remove("image");
        editor.commit();
        //모든 키값 삭제
        editor.clear();
        editor.commit();
         */
    }
}