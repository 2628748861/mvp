package com.app.simple.activity;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.app.simple.activity.base.BaseMvpActivity;
import com.app.simple.R;
import com.app.simple.fragment.MainFragment;
import com.app.simple.presenter.MainPresenter;
import com.app.simple.view.MainContractView;
import butterknife.BindView;
import ezy.ui.layout.LoadingLayout;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContractView.View {

    @BindView(R.id.loadinglayout)
    LoadingLayout loadinglayout;

    @Override
    protected int applyContent() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter applyPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadinglayout.setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.getData();
            }
        });

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,new MainFragment());
        transaction.commit();

        p.getData();

    }

    @Override
    public void showContent() {
        super.showContent();
        loadinglayout.showContent();
    }

    @Override
    public void showEmpty( ) {
        super.showEmpty();
        loadinglayout.showEmpty();
    }

    @Override
    public void showError( ) {
        super.showError();
        loadinglayout.showError();
    }

}
