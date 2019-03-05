package com.app.simple.fragment.base;
import com.app.library.fragment.MvpFragment;
import com.app.library.presenter.MvpPresenter;
import com.app.library.view.MvpView;
import com.app.simple.view.delegate.DefaultViewDelegate;

public abstract class BaseMvpFragment<Presenter extends MvpPresenter> extends MvpFragment<Presenter> {
    @Override
    protected MvpView applyViewDelegate() {
        return new DefaultViewDelegate();
    }
}
