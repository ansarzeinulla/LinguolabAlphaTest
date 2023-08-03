package com.example.linguolab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class listen_original extends AppCompatActivity {
    String[] q=new String[5];
    MediaPlayer mediaPlayer;
    int paused;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_original);
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
            q[3]=info[3];//url of audio part1
            q[4]=info[4];//url of audio part2
        }else{
            Toast.makeText(listen_original.this,"Plz, go back to menu and re open this page",Toast.LENGTH_LONG).show();
            Log.e("ZZZ","WTF");
        }
        //mediaPlayer = MediaPlayer.create(this, Uri.parse("https://firebasestorage.googleapis.com/v0/b/linguolab-kz.appspot.com/o/linaudio1.mp3?alt=media&token=9300c128-0aac-485c-8cd8-5fb48dc8cf7d"));
        mediaPlayer = MediaPlayer.create(this, Uri.parse(q[3]+"&"+q[4]));
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        Button listenorgbutton = findViewById(R.id.listenorgbutton);
        listenorgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
//            {
////                try {
//                    String uurl = q[3] + "&" + q[4];
//                    Log.e("WWWW", uurl);
//
//                    //mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/linguolab-kz.appspot.com/o/linaudio1.mp3?alt=media&token=9300c128-0aac-485c-8cd8-5fb48dc8cf7d");
//                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                        @Override
//                        public void onPrepared(MediaPlayer mediaPlayer) {
//                            if (mediaPlayer == null) {
//                                mediaPlayer.start();
//                            } else if (!mediaPlayer.isPlaying()) {
//                                mediaPlayer.seekTo(paused);
//                                mediaPlayer.start();
//                            }
//                        }
//                    });
//
//                    //mediaPlayer.prepare();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//                //
//                int aq = 0;
////
////                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
////                try {
////                    String uurl=q[3]+"&"+q[4];
////                    Log.e("WWWW",uurl);
////                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/linguolab-kz.appspot.com/o/linaudio1.mp3?alt=media&token=9300c128-0aac-485c-8cd8-5fb48dc8cf7d");
////                    mediaPlayer.prepareAsync();
////                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
////                        @Override
////                        public void onPrepared(MediaPlayer mp) {
////                            if(mediaPlayer==null){
////                                mediaPlayer.start();
////                            }else if(!mediaPlayer.isPlaying()){
////                                mediaPlayer.seekTo(paused);
////                                mediaPlayer.start();
////                            }
////                        }
////                    });
////                }catch (IOException e) {
////                    e.printStackTrace();
////                }
////
//
//
//            }
            {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()) {
                    Toast.makeText(listen_original.this,"Playing...",Toast.LENGTH_LONG).show();
                    mediaPlayer.start();
                } else {
                    Toast.makeText(listen_original.this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();
                }

            }
        });
                Button listenorgbutton2 = findViewById(R.id.listenorgbutton2);
//                listenorgbutton2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mediaPlayer.release();
//                        mediaPlayer = null;
//                    }
//                });
                Button listenorgbutton3 = findViewById(R.id.listenorgbutton3);
                listenorgbutton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.pause();
                        paused = mediaPlayer.getCurrentPosition();
                    }
                });

            }
        }
