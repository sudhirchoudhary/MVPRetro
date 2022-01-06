package com.example.mvpretro.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

//to provide the context
@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
