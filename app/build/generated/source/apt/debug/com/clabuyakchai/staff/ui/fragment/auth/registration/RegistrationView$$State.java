package com.clabuyakchai.staff.ui.fragment.auth.registration;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import java.lang.Override;
import java.lang.String;

public class RegistrationView$$State extends MvpViewState<RegistrationView> implements RegistrationView {
	@Override
	public void addToken(String token) {
		AddTokenCommand addTokenCommand = new AddTokenCommand(token);
		mViewCommands.beforeApply(addTokenCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RegistrationView view : mViews) {
			view.addToken(token);
		}

		mViewCommands.afterApply(addTokenCommand);
	}

	@Override
	public void navActivity() {
		NavActivityCommand navActivityCommand = new NavActivityCommand();
		mViewCommands.beforeApply(navActivityCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (RegistrationView view : mViews) {
			view.navActivity();
		}

		mViewCommands.afterApply(navActivityCommand);
	}

	public class AddTokenCommand extends ViewCommand<RegistrationView> {
		public final String token;

		AddTokenCommand(String token) {
			super("addToken", AddToEndStrategy.class);

			this.token = token;
		}

		@Override
		public void apply(RegistrationView mvpView) {
			mvpView.addToken(token);
		}
	}

	public class NavActivityCommand extends ViewCommand<RegistrationView> {
		NavActivityCommand() {
			super("navActivity", AddToEndStrategy.class);
		}

		@Override
		public void apply(RegistrationView mvpView) {
			mvpView.navActivity();
		}
	}
}
