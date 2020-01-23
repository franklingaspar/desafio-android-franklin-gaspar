package com.desafio_android_franklin_gaspar.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desafio_android_franklin_gaspar.model.GestorDeHQ;
import com.desafio_android_franklin_gaspar.model.to.ResultadoHQ;

import java.util.List;

public class HQViewModel extends ViewModel {

    private MutableLiveData<List<ResultadoHQ>> listaDeHQ;
    private GestorDeHQ gestorDeHQ = GestorDeHQ.getInstance();

    public void init(Integer id){
        if (listaDeHQ != null){
            return;
        }
        listaDeHQ = gestorDeHQ.getHQ(id);
    }

    public LiveData<List<ResultadoHQ>> getHQ(){
        return listaDeHQ;
    }
}
