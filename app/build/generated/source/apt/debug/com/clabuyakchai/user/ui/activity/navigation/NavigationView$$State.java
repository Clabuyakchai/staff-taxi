package com.clabuyakchai.user.ui.activity.navigation;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;

public class NavigationView$$State extends MvpViewState<NavigationView> implements NavigationView {
	@Override
	public void showDriverFunction(Boolean isDriver) {
		ShowDriverFunctionCommand showDriverFunctionCommand = new ShowDriverFunctionCommand(isDriver);
		mViewCommands.beforeApply(showDriverFunctionCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (NavigationView view : mViews) {
			view.showDriverFunction(isDriver);
		}

		mViewCommands.afterApply(showDriverFunctionCommand);
	}

	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (NavigationView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class ShowDriverFunctionCommand extends ViewCommand<NavigationView> {
		public final Boolean isDriver;

		ShowDriverFunctionCommand(Boolean isDriver) {
			super("showDriverFunction", AddToEndSingleStrategy.class);

			this.isDriver = isDriver;
		}

		@Override
		public void apply(NavigationView mvpView) {
			mvpView.showDriverFunction(isDriver);
		}
	}

	public class ShowSnackBarCommand extends ViewCommand<NavigationView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", AddToEndSingleStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(NavigationView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
