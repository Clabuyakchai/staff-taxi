package com.clabuyakchai.user.ui.fragment.navigation.bus;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class BusFragment$$PresentersBinder extends PresenterBinder<BusFragment> {
	@Override
	public List<PresenterField<BusFragment>> getPresenterFields() {
		List<PresenterField<BusFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<BusFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, BusPresenter.class);
		}

		@Override
		public void bind(BusFragment target, MvpPresenter presenter) {
			target.presenter = (BusPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(BusFragment delegated) {
			return delegated.provideBusPresenter();
		}
	}
}
