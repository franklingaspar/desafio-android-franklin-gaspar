package com.desafio_android_franklin_gaspar.api;

import android.util.Log;

import com.desafio_android_franklin_gaspar.model.to.RespostaHQ;
import com.desafio_android_franklin_gaspar.model.to.RespostaPersonagem;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Objects;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIService {

    private static final HttpUrl API_BASE_URL = HttpUrl.parse("https://gateway.marvel.com/v1/public/");

    private static final String TIME_STAMP_KEY = "ts";
    private static final String HASH_KEY = "hash";
    private static final String API_KEY = "apikey";
    private static OkHttpClient client = new OkHttpClient();
    private static RespostaPersonagem respostaPersonagem = null;
    private static  RespostaHQ respostaHQ = null;

    public static RespostaPersonagem getPersonagens(){
        Request request = buildRequestPersonagens();
        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.code() == 200){
                String json = Objects.requireNonNull(response.body()).string();
                Gson gson = new Gson();
                respostaPersonagem = gson.fromJson(json, RespostaPersonagem.class);
            }else {
                Log.e("Error", response.message());
            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", e.getMessage());
        }
        return respostaPersonagem;
    }

    public static RespostaHQ getKQ(Integer id){

        Request request = buildRequestHQ(String.valueOf(id));
        Response response;
        try {
            response =  client.newCall(request).execute();
            if (response.code() == 200){
                String json = Objects.requireNonNull(response.body()).string();
                Gson gson = new Gson();
                respostaHQ = gson.fromJson(json, RespostaHQ.class);
            }else {
                Log.e("Error", response.message());
            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", e.getMessage());
        }
        return respostaHQ;
    }

    private static Request buildRequestHQ(String id) {
        AuthAPI authAPI = new AuthAPI();
        HttpUrl url = Objects.requireNonNull(API_BASE_URL).newBuilder()
                .addEncodedPathSegments(Constants.LISTADEHQ.toString().replace("{haracterId}", id))
                .addQueryParameter(TIME_STAMP_KEY, authAPI.getTimeStamp())
                .addQueryParameter(API_KEY, authAPI.getPublicKey() )
                .addQueryParameter(HASH_KEY, authAPI.getMd5Key())
                .build();
        return new Request.Builder().url(url).build();
    }

    private static Request buildRequestPersonagens() {
        AuthAPI authAPI = new AuthAPI();
        HttpUrl url = Objects.requireNonNull(API_BASE_URL).newBuilder()
            .addPathSegment(Constants.LISTADEPERSONAGENS.toString())
            .addQueryParameter(TIME_STAMP_KEY, authAPI.getTimeStamp())
            .addQueryParameter(API_KEY, authAPI.getPublicKey() )
            .addQueryParameter(HASH_KEY, authAPI.getMd5Key())
            .build();
        return new Request.Builder().url(url).build();
    }
}

