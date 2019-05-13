package com.clabuyakchai.user.ui.fragment.auth.code;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class AuthCodeFragment$$PresentersBinder extends PresenterBinder<AuthCodeFragment> {
	@Override
	public List<PresenterField<AuthCodeFragment>> getPresenterFields() {
		List<PresenterField<AuthCodeFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<AuthCodeFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, AuthCodePresenter.class);
		}

		@Override
		public void bind(AuthCodeFragment target, MvpPresenter presenter) {
			target.presenter = (AuthCodePresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(AuthCodeFragment delegated) {
			return delegated.provideAuthCodePresenter();
		}
	}
}
