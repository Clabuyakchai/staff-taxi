package com.clabuyakchai.user.ui.activity.navigation;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import java.lang.Boolean;
import java.lang.Override;

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
}
