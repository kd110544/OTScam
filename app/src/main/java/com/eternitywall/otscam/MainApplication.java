package com.eternitywall.otscam;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;



public class MainApplication extends MultiDexApplication {

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // use job scheduler
            CameraJobService.startJob(this);
        } else {
            // use broadcast receiver
            CameraBroadcastReceiver.register(this);
        }
    }

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
