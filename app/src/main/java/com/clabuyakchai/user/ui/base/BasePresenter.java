package com.clabuyakchai.user.ui.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import androidx.annotation.CallSuper;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends MvpView> extends MvpPresenter<T> {
    protected CompositeDisposable compositeDisposable;

    @CallSuper
    public void onViewCreated() {
        this.compositeDisposable = new CompositeDisposable();
    }

    @CallSuper
    public void onViewDestroy(){
        this.compositeDisposable.dispose();
    }
}
