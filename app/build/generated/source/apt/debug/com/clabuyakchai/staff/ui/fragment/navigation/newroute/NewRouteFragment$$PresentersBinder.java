package com.clabuyakchai.staff.ui.fragment.navigation.newroute;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class NewRouteFragment$$PresentersBinder extends PresenterBinder<NewRouteFragment> {
	@Override
	public List<PresenterField<NewRouteFragment>> getPresenterFields() {
		List<PresenterField<NewRouteFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<NewRouteFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, NewRoutePresenter.class);
		}

		@Override
		public void bind(NewRouteFragment target, MvpPresenter presenter) {
			target.presenter = (NewRoutePresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(NewRouteFragment delegated) {
			return delegated.provideNewRoutePresenter();
		}
	}
}
