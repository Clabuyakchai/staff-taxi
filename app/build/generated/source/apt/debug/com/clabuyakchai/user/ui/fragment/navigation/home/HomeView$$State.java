package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.request.BusDto;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;

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

	@Override
	public void setVisibilityNewStaff(Boolean visibility) {
		SetVisibilityNewStaffCommand setVisibilityNewStaffCommand = new SetVisibilityNewStaffCommand(visibility);
		mViewCommands.beforeApply(setVisibilityNewStaffCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.setVisibilityNewStaff(visibility);
		}

		mViewCommands.afterApply(setVisibilityNewStaffCommand);
	}

	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class SetFieldCommand extends ViewCommand<HomeView> {
		public final User user;

		SetFieldCommand(User user) {
			super("setField", AddToEndSingleStrategy.class);

			this.user = user;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setField(user);
		}
	}

	public class SignOutCommand extends ViewCommand<HomeView> {
		SignOutCommand() {
			super("signOut", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.signOut();
		}
	}

	public class SetEnabledEdTxtCommand extends ViewCommand<HomeView> {
		public final Boolean enabled;

		SetEnabledEdTxtCommand(Boolean enabled) {
			super("setEnabledEdTxt", AddToEndSingleStrategy.class);

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
			super("setFiledBus", AddToEndSingleStrategy.class);

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
			super("setVisibility", AddToEndSingleStrategy.class);

			this.isDriver = isDriver;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setVisibility(isDriver);
		}
	}

	public class SetVisibilityNewStaffCommand extends ViewCommand<HomeView> {
		public final Boolean visibility;

		SetVisibilityNewStaffCommand(Boolean visibility) {
			super("setVisibilityNewStaff", AddToEndSingleStrategy.class);

			this.visibility = visibility;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setVisibilityNewStaff(visibility);
		}
	}

	public class ShowSnackBarCommand extends ViewCommand<HomeView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
