package com.app.simple.activity.base;

import com.app.library.activity.MvpActivity;
import com.app.library.presenter.MvpPresenter;
import com.app.library.view.MvpView;
import com.app.simple.view.delegate.DefaultViewDelegate;

public abstract class BaseMvpActivity<Presenter extends MvpPresenter> extends MvpActivity<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegate();
    }
}
