package com.clabuyakchai.user.ui.fragment.auth.registration;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.ViewStateProvider;
import com.arellomobile.mvp.viewstate.MvpViewState;
import java.lang.Override;

public class RegistrationPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new RegistrationView$$State();
	}
}