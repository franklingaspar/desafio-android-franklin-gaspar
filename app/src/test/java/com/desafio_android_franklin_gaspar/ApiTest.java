package com.desafio_android_franklin_gaspar;

import com.desafio_android_franklin_gaspar.api.APIService;
import com.desafio_android_franklin_gaspar.model.to.RespostaHQ;
import com.desafio_android_franklin_gaspar.model.to.RespostaPersonagem;

import org.junit.Assert;
import org.junit.Test;



public class ApiTest {

    @Test
    public void getPersonagens(){
        RespostaPersonagem respostaPersonagem = APIService.getPersonagens();
        Assert.assertEquals(java.util.Optional.ofNullable(respostaPersonagem.getCode()),java.util.Optional.ofNullable(200));
    }

    @Test
    public void getHQ(){
        RespostaHQ respostaHQ = APIService.getKQ(1011334);
        Assert.assertEquals(java.util.Optional.ofNullable(respostaHQ.getCode()),java.util.Optional.ofNullable(200));
    }

}
