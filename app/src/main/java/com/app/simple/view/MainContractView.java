package com.app.simple.view;


import com.app.library.view.MvpView;

import java.util.List;

public interface MainContractView
{
    interface View extends MvpView {
    }
    interface Presenter{
        void getData();
    }
}
