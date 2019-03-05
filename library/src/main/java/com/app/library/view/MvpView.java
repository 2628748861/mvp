package com.app.library.view;
import android.content.DialogInterface;
import android.view.View;

/**抽取视图中的常规行为,用户可自定义扩展,这里暂时不提供默认实现类,用户可以实现该接口创建自己的视图代理.
 * Created by cample on 2018/5/12.
 */
public interface MvpView
{
    /**
     * 当View创建完成时
     */
    void onCreate(Object target,View view);

    /**
     * 加载状态[加载中,加载失败,无数据,加载成功]
     */
     void showLoading();
     void showError();
     void showEmpty();
     void showContent();

    /**
     * 提交状态[提交中],取消提交状态[关闭提交]
     */
     void showCommiting();
     void dissmissCommiting();

    /**
     * 显示确认框
     */
     void showConfirmDialog(String msg, String cancel, DialogInterface.OnClickListener cancelListener, String confirm, DialogInterface.OnClickListener confirmListener);
    /**
     * 显示toast提示
     */
     void showTip(String msg);

    /**
     * 当View从Activity移除时需要做的操作
     */
    void onDetach();


}
