package com.example.dogprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


public class SoundDogs extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound0, sound1, sound2, sound3, sound4;
    private int sound3StreamId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_dogs);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        sound0 = soundPool.load(this, R.raw.sound0, 1);
        sound1 = soundPool.load(this, R.raw.sound1, 1);
        sound2 = soundPool.load(this, R.raw.sound2, 1);
        sound3 = soundPool.load(this, R.raw.sound3, 1);
        sound4 = soundPool.load(this, R.raw.sound4, 1);
    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.bt_sound0:
                soundPool.play(sound0, 1, 1, 0, 1, 1);
                //soundPool.pause(sound3StreamId);
                break;
            case R.id.bt_sound1:
                soundPool.play(sound1, 1, 1, 0, 1, 1);
                break;
            case R.id.bt_sound2:
                soundPool.play(sound2, 1, 1, 0, 1, 1);
                break;
            case R.id.bt_sound3:
                soundPool.play(sound3, 1, 1, 0, 1, 1);
                break;
            case R.id.bt_sound4:
                soundPool.play(sound4, 1, 1, 0, 1, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

}