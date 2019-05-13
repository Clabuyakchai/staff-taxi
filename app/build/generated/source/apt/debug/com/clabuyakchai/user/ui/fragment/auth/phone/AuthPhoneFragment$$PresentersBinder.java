package com.clabuyakchai.user.ui.fragment.auth.phone;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class AuthPhoneFragment$$PresentersBinder extends PresenterBinder<AuthPhoneFragment> {
	@Override
	public List<PresenterField<AuthPhoneFragment>> getPresenterFields() {
		List<PresenterField<AuthPhoneFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<AuthPhoneFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, AuthPhonePresenter.class);
		}

		@Override
		public void bind(AuthPhoneFragment target, MvpPresenter presenter) {
			target.presenter = (AuthPhonePresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(AuthPhoneFragment delegated) {
			return delegated.providePresenter();
		}
	}
}
