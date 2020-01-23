package com.desafio_android_franklin_gaspar.model;

import androidx.lifecycle.MutableLiveData;

import com.desafio_android_franklin_gaspar.api.APIService;
import com.desafio_android_franklin_gaspar.model.to.RespostaPersonagem;
import com.desafio_android_franklin_gaspar.model.to.ResultadoPersonagem;

import java.util.ArrayList;
import java.util.List;

public class GestorDePersonagens {

    private static GestorDePersonagens instance;

    public static GestorDePersonagens getInstance(){
        if (instance == null){
            instance = new GestorDePersonagens();
        }

        return instance;
    }

    public MutableLiveData<List<ResultadoPersonagem>> getListaDePersonagens(){
        MutableLiveData<List<ResultadoPersonagem>> data = new MutableLiveData<>();
        data.setValue(new ArrayList<>());
        new Thread(() -> {
            RespostaPersonagem respostaPersonagem = APIService.getPersonagens();
            data.postValue(respostaPersonagem.getData().getResults());
        }).start();

        return data;
    }

}

