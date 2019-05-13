package com.clabuyakchai.user.ui.fragment.auth.phone;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import java.lang.Override;
import java.lang.String;

public class AuthPhoneView$$State extends MvpViewState<AuthPhoneView> implements AuthPhoneView {
	@Override
	public void codeFragment(String phone) {
		CodeFragmentCommand codeFragmentCommand = new CodeFragmentCommand(phone);
		mViewCommands.beforeApply(codeFragmentCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.codeFragment(phone);
		}

		mViewCommands.afterApply(codeFragmentCommand);
	}

	@Override
	public void navActivity() {
		NavActivityCommand navActivityCommand = new NavActivityCommand();
		mViewCommands.beforeApply(navActivityCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.navActivity();
		}

		mViewCommands.afterApply(navActivityCommand);
	}

	@Override
	public void getToken() {
		GetTokenCommand getTokenCommand = new GetTokenCommand();
		mViewCommands.beforeApply(getTokenCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.getToken();
		}

		mViewCommands.afterApply(getTokenCommand);
	}

	@Override
	public void showSnackBar(String text) {
		ShowSnackBarCommand showSnackBarCommand = new ShowSnackBarCommand(text);
		mViewCommands.beforeApply(showSnackBarCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.showSnackBar(text);
		}

		mViewCommands.afterApply(showSnackBarCommand);
	}

	public class CodeFragmentCommand extends ViewCommand<AuthPhoneView> {
		public final String phone;

		CodeFragmentCommand(String phone) {
			super("codeFragment", AddToEndSingleStrategy.class);

			this.phone = phone;
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.codeFragment(phone);
		}
	}

	public class NavActivityCommand extends ViewCommand<AuthPhoneView> {
		NavActivityCommand() {
			super("navActivity", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.navActivity();
		}
	}

	public class GetTokenCommand extends ViewCommand<AuthPhoneView> {
		GetTokenCommand() {
			super("getToken", AddToEndSingleStrategy.class);
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.getToken();
		}
	}

	public class ShowSnackBarCommand extends ViewCommand<AuthPhoneView> {
		public final String text;

		ShowSnackBarCommand(String text) {
			super("showSnackBar", SkipStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.showSnackBar(text);
		}
	}
}
