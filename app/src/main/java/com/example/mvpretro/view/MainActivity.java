package com.example.mvpretro.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpretro.Contract;
import com.example.mvpretro.InitApplication;
import com.example.mvpretro.R;
import com.example.mvpretro.api.Post;
import com.example.mvpretro.dagger.component.DaggerActivityComponent;
import com.example.mvpretro.dagger.modules.MvpModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Contract.View {
    @Inject
    Contract.Presenter presenter;

    @Inject
    Context mContext;

    private TextView tvResult;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerActivityComponent.builder()
                .appComponent(InitApplication.get(this).component())
                .mvpModule(new MvpModule(this))
                .build()
                .inject(this);

        //assigning the views
        tvResult = findViewById(R.id.tvResult);
        progressBar = findViewById(R.id.progressBar);

        //show progress bar in starting
        showProgress();

        //instantiating the object of presenter class

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        tvResult.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        tvResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void setResult(List<Post> posts) {
        //once the list is fetched we will create a string concatenating all the data
        //one after other (for this app only) and then append it to the text view
        for (Post post : posts) {
            String content = "";
            content += "Id: " + post.getId() + "\n";
            content += "User Id: " + post.getUserId() + "\n";
            content += "Title: " + post.getTitle() + "\n";
            content += "Text: " + post.getBody() + "\n";

            tvResult.append(content);
        }
    }
}