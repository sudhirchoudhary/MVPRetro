package com.example.mvpretro;

import com.example.mvpretro.api.Post;

import java.util.List;

public interface Contract {

    interface View {
        //to show progress bar while fetching data in background
        void showProgress();

        //to hide the progress bar once the data is fetched
        void hideProgress();

        //populating the text view with result
        void setResult(List<Post> posts);
    }

    interface Model {
        interface OnFinishedListener {
            //once the getPosts() method is finished it will be called
            void onFinished(List<Post> posts);
        }
        //method to call the api
        void getPosts(OnFinishedListener listener);
    }

    interface Presenter {
        //when activity is destroyed
        void onDestroy();
    }
}
