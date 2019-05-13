package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment$$PresentersBinder extends PresenterBinder<HomeFragment> {
	@Override
	public List<PresenterField<HomeFragment>> getPresenterFields() {
		List<PresenterField<HomeFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<HomeFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, HomePresenter.class);
		}

		@Override
		public void bind(HomeFragment target, MvpPresenter presenter) {
			target.presenter = (HomePresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(HomeFragment delegated) {
			return delegated.provideHomePresenter();
		}
	}
}
