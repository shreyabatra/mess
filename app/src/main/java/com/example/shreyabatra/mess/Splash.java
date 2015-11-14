package com.example.shreyabatra.mess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by shreya batra on 14-11-2015.
 */
public class Splash extends Activity {

        MediaPlayer ourSong;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);
            final Context con = this;
            ourSong=MediaPlayer.create(Splash.this, R.raw.app_song);
            ourSong.start();
            final Thread t = new Thread() {

                public void run() {
                    super.run();
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    } finally {
                        Intent c = new Intent(con, MainActivity.class);
                        startActivity(c);
                    }
                }
            };

            t.start();


        }

        @Override
        protected void onPause() {
            super.onPause();
            ourSong.release();
            finish();
        }
    }



