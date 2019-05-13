package com.clabuyakchai.user.ui.fragment.navigation.routedetail;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class RouteDetailFragment$$PresentersBinder extends PresenterBinder<RouteDetailFragment> {
	@Override
	public List<PresenterField<RouteDetailFragment>> getPresenterFields() {
		List<PresenterField<RouteDetailFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<RouteDetailFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, RouteDetailPresenter.class);
		}

		@Override
		public void bind(RouteDetailFragment target, MvpPresenter presenter) {
			target.presenter = (RouteDetailPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(RouteDetailFragment delegated) {
			return delegated.provideRouteDetailPresenter();
		}
	}
}
