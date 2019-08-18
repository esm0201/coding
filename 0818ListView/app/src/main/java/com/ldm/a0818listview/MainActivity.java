package com.ldm.a0818listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String fruit[] = {"사과","수박","바나나","오렌지","딸기","포도","복숭아","체리","멜론","참외","망고","감","배","파인애플"};
        String city[] = getResources().getStringArray(R.array.city);

        //이 친구는 xml data

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_checked,city);
        /*이 친구는 하드코딩 data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruit);
        */
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String)getListAdapter().getItem(position);
        Toast.makeText(this,item+"선택",Toast.LENGTH_SHORT).show();
    }
}
