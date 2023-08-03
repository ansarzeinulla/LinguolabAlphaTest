package com.example.linguolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class listenlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listenlist);
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("level")!= null) {
            int level = Integer.valueOf(bundle.getString("level"));
            String janr = bundle.getString("janr");
            int rswitch = Integer.valueOf(bundle.getString("switch"));

            ListView listeninglistview=findViewById(R.id.listeninglistview);
            String sylka="l"+String.valueOf(level)+String.valueOf(rswitch)+janr;
            int ssylka = getResources().getIdentifier(sylka, "array", getPackageName()); //GETTING LIST BASED ON THE GOTTON VALUES

            List<String> listarray = Arrays.asList(getResources().getStringArray(ssylka));
            ArrayAdapter<String> arrayAdapter =
                    new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listarray);
            listeninglistview.setAdapter(arrayAdapter); // SETTING THE LIST INTO LISTVIEW
            listeninglistview.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
                {
//                    String selectedmovie=listarray.get(position);
                    Toast.makeText(getApplicationContext(), ": Q: "+listarray.get(position),   Toast.LENGTH_LONG).show();
                    String sylka2="l"+String.valueOf(level)+String.valueOf(rswitch)+"Q"+janr; //THE LINKS TO THE BOOKS ARE STORED HERE
                    int ssylka2 = getResources().getIdentifier(sylka2, "array", getPackageName());
                    String[] listarray2 = getResources().getStringArray(ssylka2); //LISTARRAY2[POSITION] IS THE CORRECT LINK

                    if(rswitch==0){// WITHOUT ANALYZE
                        Intent intent=new Intent(listenlist.this, listen_original.class);
                        intent.putExtra("linq",listarray2[position]);
                        startActivity(intent);
                    }else{//WITH ANALYZE
//                        Intent intent=new Intent(readinglist.this,read_analyze.class);
//                        intent.putExtra("linq",listarray2[position]);
//                        startActivity(intent);
                    }
                }
            });

        }else{
            Toast.makeText(listenlist.this,"Plz, go back to menu and re open this page",Toast.LENGTH_LONG).show();
            Log.e("ZZZ","WTF");//WTF ERROR
        }
    }
}