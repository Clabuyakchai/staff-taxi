package com.clabuyakchai.staff.ui.fragment.auth.phone;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.IllegalStateException;
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
			super("presenter", PresenterType.LOCAL, null, AuthPhonePresenterImpl.class);
		}

		@Override
		public void bind(AuthPhoneFragment target, MvpPresenter presenter) {
			target.presenter = (AuthPhonePresenterImpl) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(AuthPhoneFragment delegated) {
			throw new IllegalStateException("com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenterImpl" + " has not default constructor. You can apply @ProvidePresenter to some method which will construct Presenter. Also you can make it default constructor");
		}
	}
}
