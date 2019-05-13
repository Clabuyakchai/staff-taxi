package com.clabuyakchai.user.ui.fragment.auth.code;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import java.lang.Override;
import java.lang.String;

public class AuthCodeView$$State extends MvpViewState<AuthCodeView> implements AuthCodeView {
	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthCodeView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
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
	public void registrationFragment(String phone) {
		RegistrationFragmentCommand registrationFragmentCommand = new RegistrationFragmentCommand(phone);
		mViewCommands.beforeApply(registrationFragmentCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthCodeView view : mViews) {
			view.registrationFragment(phone);
		}

		mViewCommands.afterApply(registrationFragmentCommand);
	}

	@Override
	public void addToken(String token) {
		AddTokenCommand addTokenCommand = new AddTokenCommand(token);
		mViewCommands.beforeApply(addTokenCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthCodeView view : mViews) {
			view.addToken(token);
		}

		mViewCommands.afterApply(addTokenCommand);
	}

	public class ShowSnackBarCommand extends ViewCommand<AuthCodeView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.showSnackBar(text);
		}
	}

	public class NavActivityCommand extends ViewCommand<AuthCodeView> {
		NavActivityCommand() {
			super("navActivity", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.navActivity();
		}
	}

	public class RegistrationFragmentCommand extends ViewCommand<AuthCodeView> {
		public final String phone;

		RegistrationFragmentCommand(String phone) {
			super("registrationFragment", AddToEndSingleStrategy.class);

			this.phone = phone;
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.registrationFragment(phone);
		}
	}

	public class AddTokenCommand extends ViewCommand<AuthCodeView> {
		public final String token;

		AddTokenCommand(String token) {
			super("addToken", AddToEndSingleStrategy.class);

			this.token = token;
		}

		@Override
		public void apply(AuthCodeView mvpView) {
			mvpView.addToken(token);
		}
	}
}
