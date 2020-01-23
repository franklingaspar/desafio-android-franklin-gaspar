package com.desafio_android_franklin_gaspar.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


import com.desafio_android_franklin_gaspar.R;

import java.util.Objects;


public class MProgressBarDialog {

    private AlertDialog alertDialog;

    public MProgressBarDialog(Fragment fragment){
        LayoutInflater inflater = Objects.requireNonNull(fragment.getActivity()).getLayoutInflater();
        @SuppressLint("InflateParams") View alertLayout = inflater.inflate(R.layout.alert_dialog_simple, null);
        AlertDialog.Builder mensagem = new AlertDialog.Builder(fragment.getActivity());
        ProgressBar progressBar = alertLayout.findViewById(R.id.progress_id);
        progressBar.setVisibility(View.VISIBLE);
        mensagem.setView(alertLayout);
        alertDialog = mensagem.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_SEARCH && event.getRepeatCount() == 0) {
                return true; // Pretend we processed it
            }
            return false;
        });
        Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();
    }

    public MProgressBarDialog(Activity activity){
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        @SuppressLint("InflateParams") View alertLayout = inflater.inflate(R.layout.alert_dialog_simple, null);
        AlertDialog.Builder mensagem = new AlertDialog.Builder(activity);
        ProgressBar progressBar = alertLayout.findViewById(R.id.progress_id);
        progressBar.setVisibility(View.VISIBLE);
        mensagem.setView(alertLayout);
        alertDialog = mensagem.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_SEARCH && event.getRepeatCount() == 0) {
                return true; // Pretend we processed it
            }
            return false;
        });
        Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();
    }

    public void show(){
        alertDialog.show();
    }

    public void dismiss() {
        alertDialog.dismiss();
    }
}
