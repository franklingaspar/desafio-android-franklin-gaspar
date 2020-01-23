package com.desafio_android_franklin_gaspar.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.desafio_android_franklin_gaspar.R;
import com.desafio_android_franklin_gaspar.model.to.Preco;
import com.desafio_android_franklin_gaspar.model.to.ResultadoHQ;
import com.desafio_android_franklin_gaspar.model.to.ResultadoPersonagem;
import com.desafio_android_franklin_gaspar.util.MProgressBarDialog;
import com.desafio_android_franklin_gaspar.viewModel.HQViewModel;

import java.util.List;
import java.util.Objects;

import static com.desafio_android_franklin_gaspar.util.PopulateView.populateImagem;
import static com.desafio_android_franklin_gaspar.util.PopulateView.populateTextView;

public class HQDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView titulo, descricao, preco;
    private ProgressBar progressBar;
    private HQViewModel hqViewModel;
    private float precoFinal = 0;
    private MProgressBarDialog progressBarDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hqdetail);
        progressBarDialog = new MProgressBarDialog(this);

        ResultadoPersonagem personagem = Objects.requireNonNull(getIntent().getExtras()).getParcelable("HQDETAIL");

        Toolbar toolbar = findViewById(R.id.toolbar_HQDetail);
        setSupportActionBar(toolbar);
        if (Objects.requireNonNull(personagem).getName() != null && !personagem.getName().equals(""))
            Objects.requireNonNull(getSupportActionBar()).setTitle(personagem.getName());
        else
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);

        imageView = findViewById(R.id.image_hq);
        titulo = findViewById(R.id.title_hq);
        descricao = findViewById(R.id.descricao_hq);
        preco = findViewById(R.id.preco_hq);
        progressBar = findViewById(R.id.progress_hq);

        hqViewModel = ViewModelProviders.of(this).get(HQViewModel.class);
        hqViewModel.init(Objects.requireNonNull(personagem).getId());

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBarDialog.show();
        hqViewModel.getHQ().observe(this, results -> {
            ResultadoHQ resultadoHQ = compararPreco(results);
            if (resultadoHQ != null)
                populateViews(resultadoHQ);
        });
    }

    private void populateViews(ResultadoHQ resultadoHQ) {
        populateImagem(resultadoHQ, imageView, progressBar, this);
        populateTextView(String.format("Titulo: %s", resultadoHQ.getTitle()), titulo);
        populateTextView(resultadoHQ.getDescription(), descricao);
        populateTextView(String.format("R$ %s", String.valueOf(precoFinal)), preco);
        progressBarDialog.dismiss();
    }

    private ResultadoHQ compararPreco(List<ResultadoHQ> results) {
        ResultadoHQ resultadoHQ = null;
        for (ResultadoHQ resultadoHQTemp : results){
            for (Preco precoTemp: resultadoHQTemp.getPrices()){
                if (precoTemp.getPrice() > precoFinal){
                    precoFinal = precoTemp.getPrice();
                    resultadoHQ = resultadoHQTemp;
                }
            }
        }
        return resultadoHQ;
    }
}
