package com.clabuyakchai.staff.ui.fragment.navigation.routedetail;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.clabuyakchai.staff.data.remote.request.LocalDto;
import java.lang.Override;
import java.util.List;

public class RouteDetailView$$State extends MvpViewState<RouteDetailView> implements RouteDetailView {
	@Override
	public void setRouteDetailAdapter(List<LocalDto> list) {
		SetRouteDetailAdapterCommand setRouteDetailAdapterCommand = new SetRouteDetailAdapterCommand(list);
		mViewCommands.beforeApply(setRouteDetailAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RouteDetailView view : mViews) {
			view.setRouteDetailAdapter(list);
		}

		mViewCommands.afterApply(setRouteDetailAdapterCommand);
	}

	public class SetRouteDetailAdapterCommand extends ViewCommand<RouteDetailView> {
		public final List<LocalDto> list;

		SetRouteDetailAdapterCommand(List<LocalDto> list) {
			super("setRouteDetailAdapter", AddToEndStrategy.class);

			this.list = list;
		}

		@Override
		public void apply(RouteDetailView mvpView) {
			mvpView.setRouteDetailAdapter(list);
		}
	}
}
