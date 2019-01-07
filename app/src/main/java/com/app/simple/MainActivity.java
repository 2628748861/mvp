package com.app.simple;

import android.os.Bundle;
import com.app.library.activity.MvpActivity;
import com.app.library.presenter.MvpPresenter;

public class MainActivity extends MvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showTip("消息标志位");
    }

    @Override
    public int applyContent() {
        return R.layout.activity_main;
    }

    @Override
    public MvpPresenter createPresenter() {
        return null;
    }
}
