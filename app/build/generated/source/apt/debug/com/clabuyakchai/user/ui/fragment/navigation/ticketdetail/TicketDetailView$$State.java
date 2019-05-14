package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import java.lang.Override;
import java.lang.String;

public class TicketDetailView$$State extends MvpViewState<TicketDetailView> implements TicketDetailView {
	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (TicketDetailView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class ShowSnackBarCommand extends ViewCommand<TicketDetailView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(TicketDetailView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
