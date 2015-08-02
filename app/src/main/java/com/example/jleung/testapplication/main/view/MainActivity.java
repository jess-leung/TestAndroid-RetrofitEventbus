package com.example.jleung.testapplication.main.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.jleung.testapplication.main.presenter.MainPresenterImpl;
import com.example.jleung.testapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends ActionBarActivity implements MainView {

    @Bind(R.id.button)
    Button button;

    MainPresenterImpl mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        mainPresenter = null;
        button = null;
    }

    @OnClick(R.id.button)
    public void onClick(View v) {
        mainPresenter.onItemClick("jleu1656");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void changeText(String text) {
        button.setText(text);
    }
}
