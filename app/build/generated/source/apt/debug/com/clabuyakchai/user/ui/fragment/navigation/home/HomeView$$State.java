package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.request.BusDto;
import java.lang.Boolean;
import java.lang.Override;

public class HomeView$$State extends MvpViewState<HomeView> implements HomeView {
	@Override
	public void setField(User user) {
		SetFieldCommand setFieldCommand = new SetFieldCommand(user);
		mViewCommands.beforeApply(setFieldCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.setField(user);
		}

		mViewCommands.afterApply(setFieldCommand);
	}

	@Override
	public void signOut() {
		SignOutCommand signOutCommand = new SignOutCommand();
		mViewCommands.beforeApply(signOutCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.signOut();
		}

		mViewCommands.afterApply(signOutCommand);
	}

	@Override
	public void setEnabledEdTxt(Boolean enabled) {
		SetEnabledEdTxtCommand setEnabledEdTxtCommand = new SetEnabledEdTxtCommand(enabled);
		mViewCommands.beforeApply(setEnabledEdTxtCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.setEnabledEdTxt(enabled);
		}

		mViewCommands.afterApply(setEnabledEdTxtCommand);
	}

	@Override
	public void setFiledBus(BusDto bus) {
		SetFiledBusCommand setFiledBusCommand = new SetFiledBusCommand(bus);
		mViewCommands.beforeApply(setFiledBusCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.setFiledBus(bus);
		}

		mViewCommands.afterApply(setFiledBusCommand);
	}

	@Override
	public void setVisibility(Boolean isDriver) {
		SetVisibilityCommand setVisibilityCommand = new SetVisibilityCommand(isDriver);
		mViewCommands.beforeApply(setVisibilityCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.setVisibility(isDriver);
		}

		mViewCommands.afterApply(setVisibilityCommand);
	}

	public class SetFieldCommand extends ViewCommand<HomeView> {
		public final User user;

		SetFieldCommand(User user) {
			super("setField", AddToEndStrategy.class);

			this.user = user;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setField(user);
		}
	}

	public class SignOutCommand extends ViewCommand<HomeView> {
		SignOutCommand() {
			super("signOut", AddToEndStrategy.class);
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.signOut();
		}
	}

	public class SetEnabledEdTxtCommand extends ViewCommand<HomeView> {
		public final Boolean enabled;

		SetEnabledEdTxtCommand(Boolean enabled) {
			super("setEnabledEdTxt", AddToEndStrategy.class);

			this.enabled = enabled;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setEnabledEdTxt(enabled);
		}
	}

	public class SetFiledBusCommand extends ViewCommand<HomeView> {
		public final BusDto bus;

		SetFiledBusCommand(BusDto bus) {
			super("setFiledBus", AddToEndStrategy.class);

			this.bus = bus;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setFiledBus(bus);
		}
	}

	public class SetVisibilityCommand extends ViewCommand<HomeView> {
		public final Boolean isDriver;

		SetVisibilityCommand(Boolean isDriver) {
			super("setVisibility", AddToEndStrategy.class);

			this.isDriver = isDriver;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setVisibility(isDriver);
		}
	}
}
