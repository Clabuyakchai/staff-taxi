package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import java.lang.Override;
import java.lang.String;

public class BookDetailView$$State extends MvpViewState<BookDetailView> implements BookDetailView {
	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (BookDetailView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class ShowSnackBarCommand extends ViewCommand<BookDetailView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(BookDetailView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
