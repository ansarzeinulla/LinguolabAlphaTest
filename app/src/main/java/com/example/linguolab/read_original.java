package com.example.linguolab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class read_original extends AppCompatActivity {
String[] q=new String[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_original);
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
            q[0]=info[0];
            q[1]=info[1];
            q[2]=info[2];

        }else{
            Toast.makeText(read_original.this,"Plz, go back to menu and re open this page",Toast.LENGTH_LONG).show();
            Log.e("ZZZ","WTF");
        }

        TextView q1=findViewById(R.id.readq1);
        TextView q2=findViewById(R.id.readq2);
        q1.setText(q[0]+" | "+q[1]);
        q2.setText(q[2]);
    }
}