package com.android.incallui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import test.io.feeeei.circleseekbar.R;

public class InCallVolumeActivity extends Activity implements CircleSeekBar.OnSeekBarChangeListener {

    private int max = 7, cur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_process);

        getDefaultVolume();
        CircleSeekBar mSeekbar = (CircleSeekBar) findViewById(R.id.seekbar);
        mSeekbar.setMaxProcess(max);
        mSeekbar.setCurProcess(cur);
        mSeekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onChanged(CircleSeekBar seekbar, int curValue) {
        setCallVolume(curValue);
    }

    private void getDefaultVolume() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            max = audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);
            cur = audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
        }
    }

    private void setCallVolume(int value) {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, value, AudioManager.FLAG_PLAY_SOUND);
        }
    }

}
