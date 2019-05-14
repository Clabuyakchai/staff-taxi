package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.presenter.PresenterType;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

public class BookDetailFragment$$PresentersBinder extends PresenterBinder<BookDetailFragment> {
	@Override
	public List<PresenterField<BookDetailFragment>> getPresenterFields() {
		List<PresenterField<BookDetailFragment>> presenters = new ArrayList<>(1);
		presenters.add(new presenterBinder());
		return presenters;
	}

	public class presenterBinder extends PresenterField<BookDetailFragment> {
		public presenterBinder() {
			super("presenter", PresenterType.LOCAL, null, BookDetailPresenter.class);
		}

		@Override
		public void bind(BookDetailFragment target, MvpPresenter presenter) {
			target.presenter = (BookDetailPresenter) presenter;
		}

		@Override
		public MvpPresenter<?> providePresenter(BookDetailFragment delegated) {
			return delegated.provideBookDetailPresenter();
		}
	}
}
