package com.example.mvpretro.dagger.modules;

import com.example.mvpretro.model.Model;

import dagger.Module;
import dagger.Provides;

// for the instance of the model class
@Module
public class DataModule {
    @Provides
    public Model provideModel() {
        return new Model();
    }
}
