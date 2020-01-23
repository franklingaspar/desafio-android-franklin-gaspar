package com.desafio_android_franklin_gaspar.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.desafio_android_franklin_gaspar.R;
import com.desafio_android_franklin_gaspar.util.MProgressBarDialog;
import com.desafio_android_franklin_gaspar.view.adapter.MainAdapter;
import com.desafio_android_franklin_gaspar.viewModel.PersonagensViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonagensViewModel personagensViewModel;
    private MainAdapter mainAdapter;
    private MProgressBarDialog progressBarDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarDialog = new MProgressBarDialog(this);
        recyclerView = findViewById(R.id.recyclerView_main);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        personagensViewModel = ViewModelProviders.of(this).get(PersonagensViewModel.class);
        personagensViewModel.init();

        initRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBarDialog.show();
        personagensViewModel.getListaDePersonagens().observe(this, results ->{
            mainAdapter.setUpdate(results);
            if (results.size() > 0)
                progressBarDialog.dismiss();
        });
    }

    private void initRecyclerView() {
        mainAdapter = new MainAdapter(this, personagensViewModel.getListaDePersonagens().getValue());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }
}
