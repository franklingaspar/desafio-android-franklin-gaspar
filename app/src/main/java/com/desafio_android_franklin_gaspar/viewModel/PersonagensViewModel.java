package com.desafio_android_franklin_gaspar.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desafio_android_franklin_gaspar.model.GestorDePersonagens;
import com.desafio_android_franklin_gaspar.model.to.ResultadoPersonagem;

import java.util.List;

public class PersonagensViewModel extends ViewModel {

    private MutableLiveData<List<ResultadoPersonagem>> listaDePersonagens;

    public void init(){
        if (listaDePersonagens != null){
            return;
        }
        GestorDePersonagens gestorDePersonagens = GestorDePersonagens.getInstance();
        listaDePersonagens = gestorDePersonagens.getListaDePersonagens();
    }

    public LiveData<List<ResultadoPersonagem>> getListaDePersonagens(){
        return listaDePersonagens;
    }

}
