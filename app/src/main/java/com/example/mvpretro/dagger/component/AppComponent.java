package com.example.mvpretro.dagger.component;

import android.app.Application;
import android.content.Context;

import com.example.mvpretro.InitApplication;
import com.example.mvpretro.dagger.modules.AppModule;
import com.example.mvpretro.dagger.modules.ContextModule;
import com.example.mvpretro.dagger.modules.DataModule;
import com.example.mvpretro.model.Model;

import javax.inject.Singleton;

import dagger.Component;

//this the main component class for our app
@Singleton
@Component(modules = {AppModule.class, ContextModule.class, DataModule.class})
public interface AppComponent {
    void inject(InitApplication application);

    Context getContext();

    Model getModel();

    Application getApplication();
}
