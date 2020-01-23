package com.desafio_android_franklin_gaspar.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.desafio_android_franklin_gaspar.R;
import com.desafio_android_franklin_gaspar.model.to.ResultadoHQ;
import com.desafio_android_franklin_gaspar.model.to.ResultadoPersonagem;
import com.squareup.picasso.Picasso;

public class PopulateView {


    public static void populateImagem(ResultadoPersonagem personagem, ImageView imageView, ProgressBar progressBar, Context context){

        if (personagem.getThumbnail().getPath() != null && !personagem.getThumbnail().getPath().equals("")){
            Picasso.with(context).load(personagem.getThumbnail().getPath()+"."+personagem.getThumbnail().getExtension()).into(imageView, new ImageLoadedCallback(progressBar){
                @Override
                public void onSuccess() {
                    if (this.progressBar != null) {
                        this.progressBar.setVisibility(View.GONE);
                    }
                }
            });
        } else {
            Picasso.with(context).load(R.drawable.marvel).into( imageView, new ImageLoadedCallback(progressBar){
                @Override
                public void onSuccess() {
                    if (this.progressBar != null) {
                        this.progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    public static void populateImagem(ResultadoHQ personagem, ImageView imageView, ProgressBar progressBar, Context context){

        if (personagem.getThumbnail().getPath() != null && !personagem.getThumbnail().getPath().equals("")){
            Picasso.with(context).load(personagem.getThumbnail().getPath()+"."+personagem.getThumbnail().getExtension()).into(imageView, new ImageLoadedCallback(progressBar){
                @Override
                public void onSuccess() {
                    if (this.progressBar != null) {
                        this.progressBar.setVisibility(View.GONE);
                    }
                }
            });
        } else {
            Picasso.with(context).load(R.drawable.marvel).into( imageView, new ImageLoadedCallback(progressBar){
                @Override
                public void onSuccess() {
                    if (this.progressBar != null) {
                        this.progressBar.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    public static void populateTextView(String string, TextView nomeDoPersongem){
        if (string != null && !string.equals(""))
            nomeDoPersongem.setText(string);
        else
            nomeDoPersongem.setText(R.string.sem_dados);

    }

}
