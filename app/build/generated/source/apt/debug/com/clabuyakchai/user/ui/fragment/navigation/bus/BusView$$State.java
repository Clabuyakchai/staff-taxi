package com.clabuyakchai.user.ui.fragment.navigation.bus;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.clabuyakchai.user.data.remote.request.BusDto;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class BusView$$State extends MvpViewState<BusView> implements BusView {
	@Override
	public void setBusAdapter(List<BusDto> list) {
		SetBusAdapterCommand setBusAdapterCommand = new SetBusAdapterCommand(list);
		mViewCommands.beforeApply(setBusAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (BusView view : mViews) {
			view.setBusAdapter(list);
		}

		mViewCommands.afterApply(setBusAdapterCommand);
	}

	@Override
	public void setItemInBusAdapter(BusDto bus) {
		SetItemInBusAdapterCommand setItemInBusAdapterCommand = new SetItemInBusAdapterCommand(bus);
		mViewCommands.beforeApply(setItemInBusAdapterCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (BusView view : mViews) {
			view.setItemInBusAdapter(bus);
		}

		mViewCommands.afterApply(setItemInBusAdapterCommand);
	}

	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (BusView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class SetBusAdapterCommand extends ViewCommand<BusView> {
		public final List<BusDto> list;

		SetBusAdapterCommand(List<BusDto> list) {
			super("setBusAdapter", AddToEndSingleStrategy.class);

			this.list = list;
		}

		@Override
		public void apply(BusView mvpView) {
			mvpView.setBusAdapter(list);
		}
	}

	public class SetItemInBusAdapterCommand extends ViewCommand<BusView> {
		public final BusDto bus;

		SetItemInBusAdapterCommand(BusDto bus) {
			super("setItemInBusAdapter", AddToEndSingleStrategy.class);

			this.bus = bus;
		}

		@Override
		public void apply(BusView mvpView) {
			mvpView.setItemInBusAdapter(bus);
		}
	}

	public class ShowSnackBarCommand extends ViewCommand<BusView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(BusView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
