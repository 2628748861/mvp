package com.app.simple.presenter;

import android.os.Handler;

import com.app.library.presenter.MvpPresenter;
import com.app.simple.view.MainContractView;
import java.util.Random;

public class MainPresenter extends MvpPresenter<MainContractView.View> implements MainContractView.Presenter {
    Handler handler;
    MyRunnable runnable;
    public MainPresenter(MainContractView.View mvpView) {
        super(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void getData() {
        //模拟网络请求
         handler=new Handler();
         runnable=new MyRunnable();
        handler.postDelayed(runnable,3000);
    }
    class MyRunnable implements  Runnable {
        @Override
        public void run() {
            int result=new Random().nextInt(10);
            if(result%2==0)
            {
                if(result==2)
                {
                    v.showEmpty();
                }
                else
                {
                    v.showContent();
                }
            }
            else {
                v.showError();
            }
        }
    }

}
