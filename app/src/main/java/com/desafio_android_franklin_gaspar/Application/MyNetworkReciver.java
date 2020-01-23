package com.desafio_android_franklin_gaspar.Application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

import com.desafio_android_franklin_gaspar.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class MyNetworkReciver extends BroadcastReceiver {

    static Snackbar snackbar;

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();

        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            MyNetworkReciver.snack(null, 0, "Sem conexão!",context.getApplicationContext());
        }else{
            MyNetworkReciver.hideSnackbar();
        }
    }

    public static void snack (HashMap<String, View.OnClickListener> actions, int priority, String message, Context context) {
        if(MainApplication.mActivity != null){
            snackbar = Snackbar.make(MainApplication.mActivity.findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE);
            if (actions != null) {
                Iterator iterator = actions.entrySet().iterator();
                snackbar.setDuration(BaseTransientBottomBar.LENGTH_INDEFINITE);
                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry) iterator.next();
                    snackbar.setAction((String) pair.getKey(), (View.OnClickListener) pair.getValue());
                    iterator.remove();
                }
            }
            switch (priority) {
                case 0:
                    snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                    break;
                case 1:
                    snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                    break;
                case 2:
                    snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.design_default_color_primary));
                    break;
            }
            snackbar.show();
        }
    }
    private static void hideSnackbar(){
        if(snackbar !=null && snackbar.isShown()){
            snackbar.dismiss();
        }
    }
}