package com.clabuyakchai.staff.ui.fragment.navigation.station;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.clabuyakchai.staff.ui.fragment.navigation.station.map.StationItem;
import java.lang.Override;
import java.util.List;

public class StationView$$State extends MvpViewState<StationView> implements StationView {
	@Override
	public void setMarker(List<StationItem> stationItems) {
		SetMarkerCommand setMarkerCommand = new SetMarkerCommand(stationItems);
		mViewCommands.beforeApply(setMarkerCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (StationView view : mViews) {
			view.setMarker(stationItems);
		}

		mViewCommands.afterApply(setMarkerCommand);
	}

	@Override
	public void setMarker(StationItem stationItem) {
		SetMarker1Command setMarker1Command = new SetMarker1Command(stationItem);
		mViewCommands.beforeApply(setMarker1Command);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (StationView view : mViews) {
			view.setMarker(stationItem);
		}

		mViewCommands.afterApply(setMarker1Command);
	}

	public class SetMarkerCommand extends ViewCommand<StationView> {
		public final List<StationItem> stationItems;

		SetMarkerCommand(List<StationItem> stationItems) {
			super("setMarker", AddToEndSingleStrategy.class);

			this.stationItems = stationItems;
		}

		@Override
		public void apply(StationView mvpView) {
			mvpView.setMarker(stationItems);
		}
	}

	public class SetMarker1Command extends ViewCommand<StationView> {
		public final StationItem stationItem;

		SetMarker1Command(StationItem stationItem) {
			super("setMarker", AddToEndSingleStrategy.class);

			this.stationItem = stationItem;
		}

		@Override
		public void apply(StationView mvpView) {
			mvpView.setMarker(stationItem);
		}
	}
}
