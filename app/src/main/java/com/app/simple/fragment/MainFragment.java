package com.app.simple.fragment;
import android.view.View;
import android.widget.Button;
import com.app.simple.R;
import com.app.simple.fragment.base.BaseMvpFragment;
import com.app.simple.presenter.MainFgtPresenter;
import com.app.simple.view.MainFgtContractView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseMvpFragment<MainFgtPresenter> implements MainFgtContractView.View {

    @BindView(R.id.btn)
    Button btn;

    @Override
    protected int applyContent() {
        return R.layout.fragement_main;
    }

    @Override
    protected MainFgtPresenter applyPresenter() {
        return new MainFgtPresenter(this);
    }


    @OnClick(R.id.btn)
    void click(View view)
    {
        p.fetchData();
    }

    @Override
    public void refershView(String value) {
        btn.setText(value);
    }
}
