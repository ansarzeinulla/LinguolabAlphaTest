package com.example.linguolab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
ConstraintLayout mainp, readfilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        showmain();
        Button mainToReadFilter=findViewById(R.id.mainToReadFilter);
        mainToReadFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainp.setVisibility(View.INVISIBLE);
                readfilter.setVisibility(View.VISIBLE);
            }
        });
        Button mreadfilterToMenu=findViewById(R.id.mreadfilterToMenu);
        mreadfilterToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showmain();
            }
        });
        Button mToReadList=findViewById(R.id.mToReadList);
        mToReadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SeekBar readseek=findViewById(R.id.seekBar);
                int a=readseek.getProgress();
                RadioButton mrRadio1=findViewById(R.id.mrRadio1);
                RadioButton mrRadio2=findViewById(R.id.mrRadio2);
                Boolean r1=mrRadio1.isChecked();
                Boolean r2=mrRadio2.isChecked();
                String janr="fairy";
                if(r1){janr="fairy";}
                else if(r2){janr="blog";}
                Switch mrswitch=findViewById(R.id.mrswitch);
                Boolean rswitch=mrswitch.isChecked();
                Integer rswitchINT=0;
                if(rswitch){rswitchINT=1;}
                Intent intent=new Intent(MainActivity.this,readinglist.class);
                intent.putExtra("level", String.valueOf(a));
                intent.putExtra("janr",janr);
                intent.putExtra("switch",String.valueOf(rswitchINT));
                startActivity(intent);
            }
        });



        Button mainToListenFiler=findViewById(R.id.mainToListFilter);
        mainToListenFiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,listenlist.class);
                intent.putExtra("level", "0");
                intent.putExtra("janr","news");
                intent.putExtra("switch","0");
                startActivity(intent);
            }
        });
    }
    public void init(){
        mainp=findViewById(R.id.mmainpage);
        readfilter=findViewById(R.id.mreadfilterpage);
    }//initialize 2 pages
    public void showmain(){
        mainp.setVisibility(View.VISIBLE);
        readfilter.setVisibility(View.INVISIBLE);
    }//makes only main visible


}