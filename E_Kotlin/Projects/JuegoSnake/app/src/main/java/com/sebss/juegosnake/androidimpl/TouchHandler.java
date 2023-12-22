package com.sebss.juegosnake.androidimpl;

import java.util.List;

import android.view.View.OnTouchListener;

import com.sebss.juegosnake.Input.TouchEvent;


public interface TouchHandler extends OnTouchListener {
    boolean isTouchDown(int pointer);

    int getTouchX(int pointer);

    int getTouchY(int pointer);

    List<TouchEvent> getTouchEvents();
}

