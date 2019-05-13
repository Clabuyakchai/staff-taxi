package com.clabuyakchai.user.ui.fragment.navigation.station;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class StationFragment$$PresentersBinder extends PresenterBinder<StationFragment> {
	@Override
	public List<PresenterField<StationFragment>> getPresenterFields() {
		List<PresenterField<StationFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<StationFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, StationPresenter.class);
		}

		@Override
		public void bind(StationFragment target, MvpPresenter presenter) {
			target.presenter = (StationPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(StationFragment delegated) {
			return delegated.provideStationPresenter();
		}
	}
}
