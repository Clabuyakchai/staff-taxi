package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import java.lang.Override;
import java.util.List;

public class TicketView$$State extends MvpViewState<TicketView> implements TicketView {
	@Override
	public void setAdapter(List<RouteDto> list) {
		SetAdapterCommand setAdapterCommand = new SetAdapterCommand(list);
		mViewCommands.beforeApply(setAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (TicketView view : mViews) {
			view.setAdapter(list);
		}

		mViewCommands.afterApply(setAdapterCommand);
	}

	public class SetAdapterCommand extends ViewCommand<TicketView> {
		public final List<RouteDto> list;

		SetAdapterCommand(List<RouteDto> list) {
			super("setAdapter", AddToEndSingleStrategy.class);

			this.list = list;
		}

		@Override
		public void apply(TicketView mvpView) {
			mvpView.setAdapter(list);
		}
	}
}
