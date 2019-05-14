package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class TicketFragment$$PresentersBinder extends PresenterBinder<TicketFragment> {
	@Override
	public List<PresenterField<TicketFragment>> getPresenterFields() {
		List<PresenterField<TicketFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<TicketFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, TicketPresenter.class);
		}

		@Override
		public void bind(TicketFragment target, MvpPresenter presenter) {
			target.presenter = (TicketPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(TicketFragment delegated) {
			return delegated.provideTicketPresenter();
		}
	}
}
