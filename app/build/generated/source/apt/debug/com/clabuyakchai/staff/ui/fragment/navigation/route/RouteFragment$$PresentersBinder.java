package com.clabuyakchai.staff.ui.fragment.navigation.route;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class RouteFragment$$PresentersBinder extends PresenterBinder<RouteFragment> {
	@Override
	public List<PresenterField<RouteFragment>> getPresenterFields() {
		List<PresenterField<RouteFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<RouteFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, RoutePresenter.class);
		}

		@Override
		public void bind(RouteFragment target, MvpPresenter presenter) {
			target.presenter = (RoutePresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(RouteFragment delegated) {
			return delegated.provideRoutePresenter();
		}
	}
}
