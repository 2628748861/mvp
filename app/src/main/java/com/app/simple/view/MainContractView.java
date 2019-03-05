package com.app.simple.view;


import com.app.library.view.MvpView;

public interface MainContractView
{
    interface View extends MvpView {
        void notifyTextView(String value);
    }
    interface Presenter{
        void getNotifyData();
    }
}
