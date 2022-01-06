package com.example.mvpretro.dagger.component;


import com.example.mvpretro.Contract;
import com.example.mvpretro.dagger.modules.MvpModule;
import com.example.mvpretro.dagger.scope.ActivityScope;
import com.example.mvpretro.view.MainActivity;

import dagger.Component;

//it is for the injecting presenter in mainActivity
@ActivityScope
@Component(dependencies = AppComponent.class,modules = MvpModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    Contract.Presenter getPresenter();
}
