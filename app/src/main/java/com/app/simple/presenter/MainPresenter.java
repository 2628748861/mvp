package com.app.simple.presenter;

import com.app.library.presenter.MvpPresenter;
import com.app.simple.view.MainContractView;

public class MainPresenter extends MvpPresenter<MainContractView.View> implements MainContractView.Presenter {
    public MainPresenter(MainContractView.View mvpView) {
        super(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void getNotifyData() {
        v.notifyTextView("data1");
    }
}
