package com.example.mvpretro.dagger.modules;

import android.app.Application;

import com.example.mvpretro.InitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


//to provide the instance of the application throughout the app
@Module
public class AppModule {
    private final InitApplication application;

    public AppModule(InitApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }
}
