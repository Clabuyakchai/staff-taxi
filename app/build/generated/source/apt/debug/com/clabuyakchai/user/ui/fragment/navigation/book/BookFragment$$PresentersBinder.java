package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class BookFragment$$PresentersBinder extends PresenterBinder<BookFragment> {
	@Override
	public List<PresenterField<BookFragment>> getPresenterFields() {
		List<PresenterField<BookFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<BookFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, BookPresenter.class);
		}

		@Override
		public void bind(BookFragment target, MvpPresenter presenter) {
			target.presenter = (BookPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(BookFragment delegated) {
			return delegated.providePresenter();
		}
	}
}
