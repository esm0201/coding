package com.ldm.a0817signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    EditText editText_ID,editText_PW,editText_Name,editText_Birth;
    Button button_ok,button_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.d("LDMCHECK","여기 실행됨1");
        button_ok = findViewById(R.id.button_ok);
        button_cancel = findViewById(R.id.button_cancel);

        editText_ID = findViewById(R.id.editText_ID);
        editText_PW = findViewById(R.id.editText_PW);
        editText_Name = findViewById(R.id.editText_Name);
        editText_Birth = findViewById(R.id.editText_Birth);
        Log.d("LDMCHECK","여기 실행됨2");

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_ID",editText_ID.getText().toString());
                intent.putExtra("INPUT_PW",editText_PW.getText().toString());
                intent.putExtra("INPUT_NAME",editText_Name.getText().toString());
                intent.putExtra("INPUT_BIRTH",editText_Birth.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });
        final DatePicker dialog = new DatePicker(this, listener, 1990, 6, 22);
        editText_Birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }


    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

        @Override

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            editText_Birth.setText(year+"/"+monthOfYear+"/"+dayOfMonth);
        }

    };
}

