package com.desafio_android_franklin_gaspar.util;

import android.widget.ProgressBar;

import com.squareup.picasso.Callback;

/**
 * Created by elbio on 13/03/2018.
 */

public class ImageLoadedCallback implements Callback {
    protected ProgressBar progressBar;

    protected ImageLoadedCallback(ProgressBar progBar){
        progressBar = progBar;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
