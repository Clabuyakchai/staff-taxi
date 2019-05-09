package com.clabuyakchai.staff.ui.fragment.navigation.route;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.clabuyakchai.staff.data.remote.request.RouteDto;
import java.lang.Override;
import java.util.List;

public class RouteView$$State extends MvpViewState<RouteView> implements RouteView {
	@Override
	public void setRouteAdapter(List<RouteDto> list) {
		SetRouteAdapterCommand setRouteAdapterCommand = new SetRouteAdapterCommand(list);
		mViewCommands.beforeApply(setRouteAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RouteView view : mViews) {
			view.setRouteAdapter(list);
		}

		mViewCommands.afterApply(setRouteAdapterCommand);
	}

	public class SetRouteAdapterCommand extends ViewCommand<RouteView> {
		public final List<RouteDto> list;

		SetRouteAdapterCommand(List<RouteDto> list) {
			super("setRouteAdapter", AddToEndStrategy.class);

			this.list = list;
		}

		@Override
		public void apply(RouteView mvpView) {
			mvpView.setRouteAdapter(list);
		}
	}
}
