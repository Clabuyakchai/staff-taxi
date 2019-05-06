package com.arellomobile.mvp;

import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenterImpl;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenterImpl$$ViewStateProvider;
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
		sViewStateProviders.put(AuthPhonePresenterImpl.class, new AuthPhonePresenterImpl$$ViewStateProvider());

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(AuthPhoneFragment.class, Arrays.<Object>asList(new AuthPhoneFragment$$PresentersBinder()));

		sStrategies = new HashMap<>();
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
