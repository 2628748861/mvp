package com.app.simple.view;

import com.app.library.view.MvpView;

public interface MainFgtContractView
{
    interface View extends MvpView
    {
        void refershView(String value);
    }
    interface Presenter{
        void fetchData();
    }
}
