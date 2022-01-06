package com.example.mvpretro.dagger.modules;

import com.example.mvpretro.Contract;
import com.example.mvpretro.model.Model;
import com.example.mvpretro.presenter.Presenter;

import dagger.Module;
import dagger.Provides;

//to provide instance of presenter with view
@Module
public class MvpModule {
    private final Contract.View view;
    public MvpModule(Contract.View view) {
        this.view = view;
    }

    @Provides
    public Contract.View provideView() {
        return view;
    }

    @Provides
    public Contract.Presenter providePresenter(Contract.View view, Model model) {
        return new Presenter(model, view);
    }
}
