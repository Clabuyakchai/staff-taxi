package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import java.lang.Override;
import java.util.List;

public class BookView$$State extends MvpViewState<BookView> implements BookView {
	@Override
	public void setRouteAdapter(List<BookingDto> list) {
		SetRouteAdapterCommand setRouteAdapterCommand = new SetRouteAdapterCommand(list);
		mViewCommands.beforeApply(setRouteAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (BookView view : mViews) {
			view.setRouteAdapter(list);
		}

		mViewCommands.afterApply(setRouteAdapterCommand);
	}

	public class SetRouteAdapterCommand extends ViewCommand<BookView> {
		public final List<BookingDto> list;

		SetRouteAdapterCommand(List<BookingDto> list) {
			super("setRouteAdapter", AddToEndSingleStrategy.class);

			this.list = list;
		}

		@Override
		public void apply(BookView mvpView) {
			mvpView.setRouteAdapter(list);
		}
	}
}
