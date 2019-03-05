package com.app.simple.view.delegate;

import android.content.DialogInterface;
import android.view.View;

import com.app.library.view.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DefaultViewDelegate implements MvpView {

    private Unbinder binder;
    @Override
    public void onCreate(Object target,View view) {
        binder=ButterKnife.bind(target, view);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showCommiting() {

    }

    @Override
    public void dissmissCommiting() {

    }

    @Override
    public void showConfirmDialog(String msg, String cancel, DialogInterface.OnClickListener cancelListener, String confirm, DialogInterface.OnClickListener confirmListener) {

    }

    @Override
    public void showTip(String msg) {

    }

    @Override
    public void onDetach() {
        if(binder!=null)
        {
            binder.unbind();
            binder=null;
        }
    }

}
