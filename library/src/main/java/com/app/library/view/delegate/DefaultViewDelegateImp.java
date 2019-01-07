package com.app.library.view.delegate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.widget.ProgressBar;

import com.app.library.fragment.LazyFrament;
import com.app.library.view.MvpView;
import com.app.library.widght.Toasty;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DefaultViewDelegateImp implements MvpView {
    protected Context mContext;
    private Unbinder unbinder;
    private AlertDialog alertDialog;

    public DefaultViewDelegateImp(LazyFrament t) {
        this.mContext=t.getContext();
        unbinder= ButterKnife.bind(t,t.getContentView());
    }
    public DefaultViewDelegateImp(Activity t) {
        this.mContext=t;
        unbinder= ButterKnife.bind(t);
    }

    @Override
    public void onDetach() {
        unbinder.unbind();
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
        alertDialog=new AlertDialog.Builder(mContext)
                .setView(new ProgressBar(mContext))
                .setCancelable(false)
                .create();
        alertDialog.show();
        Window window=alertDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public void dissmissCommiting() {
        if(alertDialog!=null&&alertDialog.isShowing())
            alertDialog.dismiss();
    }

    @Override
    public void showConfirmDialog(String msg, String cancel, DialogInterface.OnClickListener cancelListener, String confirm, DialogInterface.OnClickListener confirmListener) {
        alertDialog=new AlertDialog.Builder(mContext)
                .setMessage(msg)
                .setNegativeButton(cancel,cancelListener)
                .setPositiveButton(confirm,confirmListener)
                .create();
        alertDialog.show();
    }

    @Override
    public void showTip(String msg) {
        Toasty.showTip(mContext,msg);
    }
}
