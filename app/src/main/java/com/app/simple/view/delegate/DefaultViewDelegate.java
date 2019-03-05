package com.app.simple.view.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.app.library.view.MvpView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DefaultViewDelegate implements MvpView {

    private Context mContext;
    private Unbinder binder;
    @Override
    public void onCreate(Object target,View view) {
        binder=ButterKnife.bind(target, view);
        if(target instanceof Activity)
        {
            mContext=(Context)target;
        }
        else if(target instanceof Fragment)
        {
            mContext=((Fragment)target).getContext();
        }
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
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
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
