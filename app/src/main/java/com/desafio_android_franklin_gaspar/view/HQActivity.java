package com.desafio_android_franklin_gaspar.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.desafio_android_franklin_gaspar.R;
import com.desafio_android_franklin_gaspar.model.to.ResultadoPersonagem;
import com.desafio_android_franklin_gaspar.util.MProgressBarDialog;
import com.desafio_android_franklin_gaspar.util.PopulateView;

import java.util.Objects;

public class HQActivity extends AppCompatActivity {

    private TextView nomeDoPersonagem, descricaoDoPersonagem;
    private ImageView imagemDoPersonagem;
    private ResultadoPersonagem personagem;
    private ProgressBar progressBar;
    private MProgressBarDialog progressBarDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hq);
        progressBarDialog = new MProgressBarDialog(this);

        personagem = Objects.requireNonNull(getIntent().getExtras()).getParcelable("PERSONAGEM");

        Toolbar toolbar = findViewById(R.id.toolbar_HQ);
        setSupportActionBar(toolbar);
        if (personagem.getName() != null && !personagem.getName().equals(""))
            Objects.requireNonNull(getSupportActionBar()).setTitle(personagem.getName());
        else
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);

        nomeDoPersonagem = findViewById(R.id.nome_personagem_hq);
        descricaoDoPersonagem = findViewById(R.id.descricao_personagem_qh);
        imagemDoPersonagem = findViewById(R.id.image_personagem_hq);
        progressBar = findViewById(R.id.progress_personagens_hq);

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBarDialog.show();
        PopulateView.populateImagem(personagem, imagemDoPersonagem, progressBar, this);
        PopulateView.populateTextView(String.format("Nome: %s", personagem.getName()), nomeDoPersonagem);
        PopulateView.populateTextView( personagem.getDescription(), descricaoDoPersonagem);
        progressBarDialog.dismiss();

    }

    public void goHQValue(View view) {

        Intent intent = new Intent(this, HQDetailActivity.class);
        intent.putExtra("HQDETAIL", personagem);
        startActivity(intent);
     }

}
