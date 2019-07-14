package com.ldm.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//더하기 = 1, 빼기 = 2, 곱하기 = 3, 모듈러 = 4, 나누기 = 5


public class MainActivity extends AppCompatActivity {

    static int ans = 0;
    static int temp = 0;
    static String sick = "";
    int operator = 0;
    boolean index = false;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPlus,btnMinus,btnMultiple,btnDivide,btnEqual,btnBack;
    TextView textView,textSick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        textView = findViewById(R.id.textView);
        textSick = findViewById(R.id.textSick);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiple = findViewById(R.id.btnMultiple);
        btnDivide = findViewById(R.id.btnDivide);
        btnEqual = findViewById(R.id.btnEqual);
        btnBack = findViewById(R.id.btnBack);

        Button.OnClickListener onClickListener = new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn0:
                        index = true;sick+= "0";
                        temp*=10;
                        show(temp);
                        break;
                    case R.id.btn1:
                        index = true; sick+= "1";
                        temp*=10;
                        temp+=1;
                        show(temp);
                        break;
                    case R.id.btn2:
                        index = true;sick+= "2";
                        temp*=10;
                        temp+=2;
                        show(temp);
                        break;
                    case R.id.btn3:
                        index = true;sick+= "3";
                        temp*=10;
                        temp+=3;
                        show(temp);
                        break;
                    case R.id.btn4:
                        index = true;sick+= "4";
                        temp*=10;
                        temp+=4;
                        show(temp);
                        break;
                    case R.id.btn5:
                        index = true;sick+= "5";
                        temp*=10;
                        temp+=5;
                        show(temp);
                        break;
                    case R.id.btn6:
                        index = true;sick+= "6";
                        temp*=10;
                        temp+=6;
                        show(temp);
                        break;
                    case R.id.btn7:
                        index = true; sick+= "7";
                        temp*=10;
                        temp+=7;
                        show(temp);
                        break;
                    case R.id.btn8:
                        index = true;sick+= "8";
                        temp*=10;
                        temp+=8;
                        show(temp);
                        break;
                    case R.id.btn9:
                        index = true; sick+= "9";
                        temp*=10;
                        temp+=9;
                        show(temp);
                        break;
                    case R.id.btnBack:
                        temp/=10;
                        show(temp);
                        break;
                    case R.id.btnPlus:
                        cal();
                        operator = 1;
                        if(index)sick+="+";
                        else
                            sick = sick.substring(0,sick.length()-1)+"+";
                        index = false;
                        break;
                    case R.id.btnMinus:
                        cal();
                        operator = 2;
                        if(index)sick+="-";
                        else
                            sick = sick.substring(0,sick.length()-1)+"-";
                        index = false;
                        break;
                    case R.id.btnMultiple:
                        cal();
                        operator = 3;
                        if(index)sick+="*";
                        else
                            sick = sick.substring(0,sick.length()-1)+"*";
                        index = false;
                        break;
                    case R.id.btnDivide:
                        Toast.makeText(getApplicationContext(), String.valueOf(operator), Toast.LENGTH_SHORT).show();
                        cal();
                        operator = 4;
                        if(index)sick+="/";
                        else
                            sick = sick.substring(0,sick.length()-1)+"/";
                        index = false;
                        break;
                    case R.id.btnEqual:
                        cal();
                        operator = 0;
                        show(ans);
                        temp = 0;
                        if(index)sick+="=";
                        else
                            sick = sick.substring(0,sick.length()-1)+"=";
                        index = false;
                        break;
                }
                textSick.setText(sick);
            }
        };

        btn0.setOnClickListener(onClickListener);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btnPlus.setOnClickListener(onClickListener);
        btnMinus.setOnClickListener(onClickListener);
        btnMultiple.setOnClickListener(onClickListener);
        btnDivide.setOnClickListener(onClickListener);
        btnEqual.setOnClickListener(onClickListener);
        btnBack.setOnClickListener(onClickListener);
    }

    void cal()
    {
        if(operator==0)
            ans = temp;
        else if(operator==1)
            ans +=temp;
        else if(operator==2)
            ans -=temp;
        else if(operator==3)
            ans *=temp;
        else if(operator==4)
                ans /=temp;
        temp = 0;
        show(ans);
    }

    void show(int num)
    {
        textView.setText(String.valueOf(num));
    }

}
