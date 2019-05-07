package com.clabuyakchai.staff.ui.fragment.auth.phone;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import java.lang.Override;
import java.lang.String;

public class AuthPhoneView$$State extends MvpViewState<AuthPhoneView> implements AuthPhoneView {
	@Override
	public void codeFragment() {
		CodeFragmentCommand codeFragmentCommand = new CodeFragmentCommand();
		mViewCommands.beforeApply(codeFragmentCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.codeFragment();
		}

		mViewCommands.afterApply(codeFragmentCommand);
	}

	@Override
	public void showToast(String text) {
		ShowToastCommand showToastCommand = new ShowToastCommand(text);
		mViewCommands.beforeApply(showToastCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
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

		for (AuthPhoneView view : mViews) {
			view.navActivity();
		}

		mViewCommands.afterApply(navActivityCommand);
	}

	@Override
	public void addToken(String token) {
		AddTokenCommand addTokenCommand = new AddTokenCommand(token);
		mViewCommands.beforeApply(addTokenCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.addToken(token);
		}

		mViewCommands.afterApply(addTokenCommand);
	}

	@Override
	public void checkToken() {
		CheckTokenCommand checkTokenCommand = new CheckTokenCommand();
		mViewCommands.beforeApply(checkTokenCommand);

		if (mViews == null || mViews.isEmpty()) {
			return;
		}

		for (AuthPhoneView view : mViews) {
			view.checkToken();
		}

		mViewCommands.afterApply(checkTokenCommand);
	}

	public class CodeFragmentCommand extends ViewCommand<AuthPhoneView> {
		CodeFragmentCommand() {
			super("codeFragment", AddToEndStrategy.class);
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.codeFragment();
		}
	}

	public class ShowToastCommand extends ViewCommand<AuthPhoneView> {
		public final String text;

		ShowToastCommand(String text) {
			super("showToast", AddToEndStrategy.class);

			this.text = text;
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.showToast(text);
		}
	}

	public class NavActivityCommand extends ViewCommand<AuthPhoneView> {
		NavActivityCommand() {
			super("navActivity", AddToEndStrategy.class);
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.navActivity();
		}
	}

	public class AddTokenCommand extends ViewCommand<AuthPhoneView> {
		public final String token;

		AddTokenCommand(String token) {
			super("addToken", AddToEndStrategy.class);

			this.token = token;
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.addToken(token);
		}
	}

	public class CheckTokenCommand extends ViewCommand<AuthPhoneView> {
		CheckTokenCommand() {
			super("checkToken", AddToEndStrategy.class);
		}

		@Override
		public void apply(AuthPhoneView mvpView) {
			mvpView.checkToken();
		}
	}
}
