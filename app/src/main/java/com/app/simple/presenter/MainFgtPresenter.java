package com.app.simple.presenter;

import com.app.library.presenter.MvpPresenter;
import com.app.simple.view.MainFgtContractView;

public class MainFgtPresenter extends MvpPresenter<MainFgtContractView.View> implements MainFgtContractView.Presenter {
    public MainFgtPresenter(MainFgtContractView.View view) {
        super(view);
    }

    @Override
    public void fetchData() {
        v.refershView("abc");
    }
}
