package com.desafio_android_franklin_gaspar.model;

import androidx.lifecycle.MutableLiveData;

import com.desafio_android_franklin_gaspar.api.APIService;
import com.desafio_android_franklin_gaspar.model.to.RespostaHQ;
import com.desafio_android_franklin_gaspar.model.to.ResultadoHQ;

import java.util.ArrayList;
import java.util.List;

public class GestorDeHQ {

    private static GestorDeHQ instance;

    public static GestorDeHQ getInstance(){
        if (instance == null){
            instance = new GestorDeHQ();
        }

        return instance;
    }

    public MutableLiveData<List<ResultadoHQ>> getHQ(Integer id){
        MutableLiveData<List<ResultadoHQ>> data = new MutableLiveData<>();
        data.setValue(new ArrayList<>());
        new Thread(() -> {
            RespostaHQ respostaHQ = APIService.getKQ(id);
            data.postValue(respostaHQ.getData().getResults());
        }).start();

        return data;
    }
}
