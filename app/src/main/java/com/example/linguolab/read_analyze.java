package com.example.linguolab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class read_analyze extends AppCompatActivity {
    String[] q=new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_analyze);
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("linq")!= null)
        {
            String linq=bundle.getString("linq");
            String sylka=linq;
            int ssylka = getResources().getIdentifier(sylka, "array", getPackageName());
            String[] info = getResources().getStringArray(ssylka);
            Log.e("god",info[0]);
            Log.e("avtor",info[1]);
            Log.e("tekst",info[2]);
            Log.e("analyz",info[3]);
            q[0]=info[0];
            q[1]=info[1];
            q[2]=info[2];
            q[3]=info[3];
        }else{
            Toast.makeText(read_analyze.this,"Plz, go back to menu and re open this page",Toast.LENGTH_LONG).show();
            Log.e("ZZZ","WTF");
        }

        TextView q10=findViewById(R.id.readq10);
        TextView q11=findViewById(R.id.readq11);
        TextView q12=findViewById(R.id.readq12);
        q10.setText(q[0]+" | "+q[1]);
        q11.setText(q[2]);
        q12.setText(q[3]);
    }
}