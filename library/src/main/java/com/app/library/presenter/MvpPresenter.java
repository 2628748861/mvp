package com.app.library.presenter;

import android.content.Context;

import com.app.library.view.MvpView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by cample on 2018/5/12.
 */
public abstract class MvpPresenter<V extends MvpView>{
    protected V v;
    protected Context mContext;
    protected CompositeDisposable compositeDisposable=new CompositeDisposable();
    public MvpPresenter(V v) {
        this.v = v;
    }
    /**
     * 当presenter从Activity移除时需要做的操作
     * **/
    public void onDetach()
    {
        /**
         * 移除所有任务**/
        this.compositeDisposable.clear();
        this.compositeDisposable=null;
        this.v=null;
        this.mContext=null;
    }
}
