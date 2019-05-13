package com.clabuyakchai.user.ui.fragment.navigation.newroute;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class NewRouteView$$State extends MvpViewState<NewRouteView> implements NewRouteView {
	@Override
	public void setAdapter(List<StationItemWithSwitch> stations) {
		SetAdapterCommand setAdapterCommand = new SetAdapterCommand(stations);
		mViewCommands.beforeApply(setAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (NewRouteView view : mViews) {
			view.setAdapter(stations);
		}

		mViewCommands.afterApply(setAdapterCommand);
	}

	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (NewRouteView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class SetAdapterCommand extends ViewCommand<NewRouteView> {
		public final List<StationItemWithSwitch> stations;

		SetAdapterCommand(List<StationItemWithSwitch> stations) {
			super("setAdapter", SkipStrategy.class);

			this.stations = stations;
		}

		@Override
		public void apply(NewRouteView mvpView) {
			mvpView.setAdapter(stations);
		}
	}

	public class ShowSnackBarCommand extends ViewCommand<NewRouteView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(NewRouteView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
