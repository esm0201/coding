package com.ldm.bottomnavi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ConstraintLayout container;

    private View dialogView, toastView;
    private EditText editName, editEmail;
    private TextView toastText;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("알림메뉴")
                            .setMessage("메인홈으로 이동합니다.")
                            .setIcon(R.drawable.ic_home_black_24dp)
                            .setPositiveButton("확인",null)
                            .setNegativeButton("취소",null)
                            .show();
                    mTextMessage.setText("홈");
                    return true;
                case R.id.navigation_dashboard:
                    final String arr[] = new String[]{"네트워크  ON","사운드 ON", "절전모드 ON"};
                    final boolean check[] = new boolean[]{false,false,false};

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("환경설정")
                            .setIcon(R.drawable.ic_dashboard_black_24dp)
                            .setMultiChoiceItems(arr, check, new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                            Log.d(">>>LDM_TEST<<<","which : "+which);
                                            Log.d(">>>LDM_TEST<<<","isChecked : "+ isChecked);
                                        }
                                    })
                            .setPositiveButton("확인",null)
                            .show();

                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    Log.d(">>>LDM_TEST<<<","시작");
                    dialogView = View.inflate(getApplicationContext(),R.layout.dialog1,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("개인정보 입력");
                    dlg.setIcon(R.drawable.ic_local_printshop_black_24dp);
                    Log.d(">>>LDM_TEST<<<","전");
                    dlg.setView(dialogView);
                    Log.d(">>>LDM_TEST<<<","후");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editName = dialogView.findViewById(R.id.editText);
                            editEmail = dialogView.findViewById(R.id.editText2);
                            Log.d(">>>LDM_TEST<<<","이름: " + editName.getText().toString());
                            Log.d(">>>LDM_TEST<<<","이름: " + editEmail.getText().toString());
                        }
                    });
                    dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toast = new Toast(MainActivity.this);
                            toastView = View.inflate(MainActivity.this,R.layout.toast1,null);
                            toastText = toastView.findViewById(R.id.textViewToast);
                            toastText.setText("등록을 취소하였씁니다.");
                            toast.setView(toastView);
                            toast.show();
                        }
                    });
                    dlg.show();
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        container = findViewById(R.id.container);
        registerForContextMenu(container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.power_off:
                Log.d(">>>LDM_TEST<<<","OptionMenu 프로그램 종료!");
                finish();
                return true;
            case R.id.about:
                Log.d(">>>LDM_TEST<<<","OptionMenu 프로그램 정보!");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.power_off:
                Log.d(">>>LDM_TEST<<<","ContextMenu 메뉴 종료!");
                finish();
                return true;
            case R.id.about:
                Log.d(">>>LDM_TEST<<<","ContextMenu  프로그램 정보!");
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
