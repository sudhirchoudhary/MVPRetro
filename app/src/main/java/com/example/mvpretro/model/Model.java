package com.example.mvpretro.model;

import com.example.mvpretro.Contract;
import com.example.mvpretro.api.ApiCall;
import com.example.mvpretro.api.JsonPlaceHolderApi;
import com.example.mvpretro.api.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Model implements Contract.Model {

    public Model() {
    }

    //method to make create retrofit and make call to JsonApi
    @Override
    public void getPosts(OnFinishedListener listener) {
        Retrofit retrofit = new ApiCall().makeApiCall();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                listener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
