package com.clabuyakchai.staff.ui.activity.navigation;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class NavigationActivity$$PresentersBinder extends PresenterBinder<NavigationActivity> {
	@Override
	public List<PresenterField<NavigationActivity>> getPresenterFields() {
		List<PresenterField<NavigationActivity>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<NavigationActivity> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, NavigationActivityPresenter.class);
		}

		@Override
		public void bind(NavigationActivity target, MvpPresenter presenter) {
			target.presenter = (NavigationActivityPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(NavigationActivity delegated) {
			return delegated.provideNavigationActivityPresenter();
		}
	}
}
