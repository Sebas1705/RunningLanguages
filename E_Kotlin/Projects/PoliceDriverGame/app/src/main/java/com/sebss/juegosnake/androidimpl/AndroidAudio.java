package com.sebss.juegosnake.androidimpl;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import com.sebss.juegosnake.Audio;
import com.sebss.juegosnake.Musica;
import com.sebss.juegosnake.Sonido;


public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool.Builder()
                .setMaxStreams(20)
                .build();
    }

    @Override
    public Musica nuevaMusica(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            return new AndroidMusica(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("no se ha podido cargar archivo '" + filename + "'");
        }
    }

    @Override
    public Sonido nuevoSonido(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSonido(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido cargar archivo '" + filename + "'");
        }
    }
}

