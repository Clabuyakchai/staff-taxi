package com.clabuyakchai.staff.ui.fragment.navigation.home;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import java.lang.Override;

public class HomeView$$State extends MvpViewState<HomeView> implements HomeView {
	@Override
	public void setField(StaffDto staffDto) {
		SetFieldCommand setFieldCommand = new SetFieldCommand(staffDto);
		mViewCommands.beforeApply(setFieldCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (HomeView view : mViews) {
			view.setField(staffDto);
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

	public class SetFieldCommand extends ViewCommand<HomeView> {
		public final StaffDto staffDto;

		SetFieldCommand(StaffDto staffDto) {
			super("setField", AddToEndStrategy.class);

			this.staffDto = staffDto;
		}

		@Override
		public void apply(HomeView mvpView) {
			mvpView.setField(staffDto);
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
}
