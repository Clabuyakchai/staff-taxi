package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class TicketDetailFragment$$PresentersBinder extends PresenterBinder<TicketDetailFragment> {
	@Override
	public List<PresenterField<TicketDetailFragment>> getPresenterFields() {
		List<PresenterField<TicketDetailFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<TicketDetailFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, TicketDetailPresenter.class);
		}

		@Override
		public void bind(TicketDetailFragment target, MvpPresenter presenter) {
			target.presenter = (TicketDetailPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(TicketDetailFragment delegated) {
			return delegated.provideTicketDetailPresenter();
		}
	}
}
