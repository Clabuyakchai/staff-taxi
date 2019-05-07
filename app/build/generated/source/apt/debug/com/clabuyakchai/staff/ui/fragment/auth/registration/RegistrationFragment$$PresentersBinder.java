package com.clabuyakchai.staff.ui.fragment.auth.registration;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class RegistrationFragment$$PresentersBinder extends PresenterBinder<RegistrationFragment> {
	@Override
	public List<PresenterField<RegistrationFragment>> getPresenterFields() {
		List<PresenterField<RegistrationFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<RegistrationFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, RegistrationPresenter.class);
		}

		@Override
		public void bind(RegistrationFragment target, MvpPresenter presenter) {
			target.presenter = (RegistrationPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(RegistrationFragment delegated) {
			return delegated.provideRegistrationPresenter();
		}
	}
}
