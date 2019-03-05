package com.app.simple.activity;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import com.app.simple.activity.base.BaseMvpActivity;
import com.app.simple.R;
import com.app.simple.fragment.MainFragment;
import com.app.simple.presenter.MainPresenter;
import com.app.simple.view.MainContractView;
import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContractView.View{

    @BindView(R.id.textview)
    TextView textview;

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

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,new MainFragment());
        transaction.commit();

        p.getNotifyData();
    }

    @Override
    public void notifyTextView(String value) {
        textview.setText(value);
    }
}
