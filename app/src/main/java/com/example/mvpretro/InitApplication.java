package com.example.mvpretro;

import android.app.Application;
import android.content.Context;

import com.example.mvpretro.dagger.component.AppComponent;
import com.example.mvpretro.dagger.component.DaggerAppComponent;
import com.example.mvpretro.dagger.modules.AppModule;
import com.example.mvpretro.dagger.modules.ContextModule;
import com.example.mvpretro.dagger.modules.DataModule;

public class InitApplication extends Application {
    private AppComponent component;

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .contextModule(new ContextModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public AppComponent component() {
        return component;
    }
}
