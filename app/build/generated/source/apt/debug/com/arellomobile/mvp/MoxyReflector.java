package com.arellomobile.mvp;

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragment;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodePresenter$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenterImpl$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragment;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationPresenter;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationPresenter$$ViewStateProvider;
import java.lang.Class;
import java.lang.Object;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MoxyReflector {
	private static Map<Class<?>, Object> sViewStateProviders;

	private static Map<Class<?>, List<Object>> sPresenterBinders;

	private static Map<Class<?>, Object> sStrategies;

	static {
		sViewStateProviders = new HashMap<>();
		sViewStateProviders.put(AuthCodePresenter.class, new AuthCodePresenter$$ViewStateProvider());
		sViewStateProviders.put(AuthPhonePresenter.class, new AuthPhonePresenterImpl$$ViewStateProvider());
		sViewStateProviders.put(RegistrationPresenter.class, new RegistrationPresenter$$ViewStateProvider());

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(AuthCodeFragment.class, Arrays.<Object>asList(new AuthCodeFragment$$PresentersBinder()));
		sPresenterBinders.put(AuthPhoneFragment.class, Arrays.<Object>asList(new AuthPhoneFragment$$PresentersBinder()));
		sPresenterBinders.put(RegistrationFragment.class, Arrays.<Object>asList(new RegistrationFragment$$PresentersBinder()));

		sStrategies = new HashMap<>();
		sStrategies.put(AddToEndStrategy.class, new AddToEndStrategy());
	}

	public static Object getViewState(Class<?> presenterClass) {
		ViewStateProvider viewStateProvider = (ViewStateProvider) sViewStateProviders.get(presenterClass);
		if (viewStateProvider == null) {
			return null;
		}

		return viewStateProvider.getViewState();
	}

	public static List<Object> getPresenterBinders(Class<?> delegated) {
		return sPresenterBinders.get(delegated);
	}

	public static Object getStrategy(Class<?> strategyClass) {
		return sStrategies.get(strategyClass);
	}
}
