package com.example.mvpretro.presenter;

import com.example.mvpretro.Contract;
import com.example.mvpretro.api.Post;

import java.util.List;

public class Presenter implements Contract.Presenter, Contract.Model.OnFinishedListener {

    //object of View interface to communicate with presenter
    private Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        model.getPosts(this);
        this.view = view;
    }

    //when model is done with fetching this method will be invoked
    @Override
    public void onFinished(List<Post> posts) {
        if(view != null) {
            view.setResult(posts);
            view.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
