package com.app.library.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.app.library.presenter.MvpPresenter;
import com.app.library.view.MvpView;


/**
 * Created by cample on 2018/6/21.
 */

public abstract class MvpFragment<Presenter extends MvpPresenter> extends LazyFrament implements MvpView
{
    protected Presenter p;
    protected Context mContext;
    private MvpView viewDelegate;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        mContext=getContext();
        if(applyContent()!=0) {
            setContentView(applyContent());
        }
        //设置View代理实现 [用户自由设置]
        viewDelegate=applyViewDelegate();
        if(!check(viewDelegate))
            viewDelegate.onCreate(this,getContentView());
        //设置Presenter [用户自由设置]
        p=applyPresenter();
    }

    protected abstract int applyContent();
    protected abstract Presenter applyPresenter();
    protected MvpView applyViewDelegate()
    {
        return null;
    }
    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        if (viewDelegate!=null)
            viewDelegate.onDetach();
        if(p!=null)
        p.onDetach();
        p=null;
        viewDelegate=null;
        mContext=null;
    }

    @Override
    public void onCreate(Object target, View view) {
        if(check(viewDelegate))return;
        viewDelegate.onCreate(target, view);
    }

    @Override
    public void showTip( String msg) {
        if(check(viewDelegate))return;
         viewDelegate.showTip(msg);
    }
    @Override
    public void showCommiting() {
        if(check(viewDelegate))return;
        viewDelegate.showCommiting();
    }

    @Override
    public void dissmissCommiting() {
        if(check(viewDelegate))return;
        viewDelegate.dissmissCommiting();
    }

    @Override
    public void showConfirmDialog(String msg, String cancle, DialogInterface.OnClickListener cancleListener, String confirm, DialogInterface.OnClickListener confirmListener) {
        if(check(viewDelegate))return;
        viewDelegate.showConfirmDialog(msg, cancle, cancleListener, confirm, confirmListener);
    }

    @Override
    public void showLoading() {
        if(check(viewDelegate))return;
        viewDelegate.showLoading();
    }

    @Override
    public void showContent() {
        if(check(viewDelegate))return;
        viewDelegate.showContent();
    }

    @Override
    public void showEmpty() {
        if(check(viewDelegate))return;
        viewDelegate.showEmpty();
    }

    @Override
    public void showError() {
        if(check(viewDelegate))return;
        viewDelegate.showError();
    }
    private boolean check(Object o)
    {
        return o==null||isDetached();
    }

}
