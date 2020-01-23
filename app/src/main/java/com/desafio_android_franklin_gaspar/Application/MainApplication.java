package com.desafio_android_franklin_gaspar.Application;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;


public class MainApplication extends Application implements Application.ActivityLifecycleCallbacks {

    static Activity mActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);

    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        mActivity = activity;
        Intent i = new Intent(this, MyNetworkReciver.class);
        sendBroadcast(i);

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
