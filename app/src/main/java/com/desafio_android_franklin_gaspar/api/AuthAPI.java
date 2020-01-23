package com.desafio_android_franklin_gaspar.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class AuthAPI {

    private static final String KEY_PRIVATE = "9620af9157d1cd8ccd0025feb77fb2ab232cad00";
    private static final String KEY_PUBLIC = "bfa50cc7e251d8cf5a07e9ffa168b501";

    private String publicKey;
    private String privateKey;
    private String timeStamp;
    private String md5Key;


    AuthAPI(){
        timeStamp  = String.valueOf(System.currentTimeMillis());
        privateKey = KEY_PRIVATE;
        publicKey  = KEY_PUBLIC;
    }

    String getPublicKey() {
        return publicKey;
    }

    private String getPrivateKey() {
        return privateKey;
    }

    String getTimeStamp(){
        return timeStamp;
    }

    String getMd5Key() {

        String input = getTimeStamp() + getPrivateKey() + getPublicKey() ;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] md5Bytes = md.digest(input.getBytes());

            StringBuilder md5 = new StringBuilder();
            for (int i = 0; i < md5Bytes.length; ++i) {
                md5.append(Integer.toHexString((md5Bytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            md5Key = md5.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Key;
    }
}
