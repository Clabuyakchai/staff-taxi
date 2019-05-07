package com.clabuyakchai.staff.ui.fragment.auth.code;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import java.lang.Override;
import java.lang.String;

public class AuthCodeView$$State extends MvpViewState<AuthCodeView> implements AuthCodeView {
	@Override
	public void showToast(String text) {
		ShowToastCommand showToastCommand = new ShowToastCommand(text);
		mViewCommands.beforeApply(showToastCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthCodeView view : mViews) {
			view.showToast(text);
		}

		mViewCommands.afterApply(showToastCommand);
	}

	@Override
	public void navActivity() {
		NavActivityCommand navActivityCommand = new NavActivityCommand();
		mViewCommands.beforeApply(navActivityCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthCodeView view : mViews) {
			view.navActivity();
		}

		mViewCommands.afterApply(navActivityCommand);
	}

	@Override
	public void registrationFragment() {
		RegistrationFragmentCommand registrationFragmentCommand = new RegistrationFragmentCommand();
		mViewCommands.beforeApply(registrationFragmentCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthCodeView view : mViews) {
			view.registrationFragment();
		}

		mViewCommands.afterApply(registrationFragmentCommand);
	}

	public class ShowToastCommand extends ViewCommand<AuthCodeView> {
		public final String text;

		ShowToastCommand(String text) {
			super("showToast", AddToEndStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.showToast(text);
		}
	}

	public class NavActivityCommand extends ViewCommand<AuthCodeView> {
		NavActivityCommand() {
			super("navActivity", AddToEndStrategy.class);
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.navActivity();
		}
	}

	public class RegistrationFragmentCommand extends ViewCommand<AuthCodeView> {
		RegistrationFragmentCommand() {
			super("registrationFragment", AddToEndStrategy.class);
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.registrationFragment();
		}
	}
}
