package com.desafio_android_franklin_gaspar.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.desafio_android_franklin_gaspar.R;
import com.desafio_android_franklin_gaspar.model.to.ResultadoPersonagem;
import com.desafio_android_franklin_gaspar.util.MProgressBarDialog;
import com.desafio_android_franklin_gaspar.util.PopulateView;
import com.desafio_android_franklin_gaspar.view.HQActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder>{

    private List<ResultadoPersonagem> listaDePersonagens;
    private Context context;

    public MainAdapter(Context context, List<ResultadoPersonagem> listaDePersonagens){
        this.listaDePersonagens = listaDePersonagens;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_personagem, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final ResultadoPersonagem personagem = getItem(position);

        ProgressBar progressBar = holder.progressBar;
        progressBar.setVisibility(View.VISIBLE);

        PopulateView.populateImagem(personagem, holder.imageViewDoPersonagem, progressBar, context);
        PopulateView.populateTextView(personagem.getName(), holder.nomeDoPersongem);

        holder.layout.setOnClickListener(v -> {
            Intent intent = new Intent(context, HQActivity.class);
            intent.putExtra("PERSONAGEM", personagem);
            context.startActivity(intent);
        });
    }

    private ResultadoPersonagem getItem(int positon){
        return listaDePersonagens.get(positon);
    }

    @Override
    public int getItemCount() {
        return listaDePersonagens.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private ImageView imageViewDoPersonagem;
        private TextView nomeDoPersongem;
        private ProgressBar progressBar;
        private ConstraintLayout layout;

        Holder(@NonNull View itemView) {
            super(itemView);

            progressBar = itemView.findViewById(R.id.progress_personagens_item);
            imageViewDoPersonagem = itemView.findViewById(R.id.image_personagem_main);
            nomeDoPersongem = itemView.findViewById(R.id.nome_personagem_main);
            layout = itemView.findViewById(R.id.layout_item_personagem);
        }
    }

    public void setUpdate(List<ResultadoPersonagem> listaDePersonagens){
        this.listaDePersonagens = listaDePersonagens;
        notifyDataSetChanged();
    }
}
