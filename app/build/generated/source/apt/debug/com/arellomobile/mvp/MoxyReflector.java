package com.arellomobile.mvp;

import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragment;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodePresenter$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenter;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhonePresenter$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragment;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationPresenter;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationPresenter$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomePresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomePresenter$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RoutePresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RoutePresenter$$ViewStateProvider;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailFragment$$PresentersBinder;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailPresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailPresenter$$ViewStateProvider;
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
		sViewStateProviders.put(AuthPhonePresenter.class, new AuthPhonePresenter$$ViewStateProvider());
		sViewStateProviders.put(RegistrationPresenter.class, new RegistrationPresenter$$ViewStateProvider());
		sViewStateProviders.put(HomePresenter.class, new HomePresenter$$ViewStateProvider());
		sViewStateProviders.put(RoutePresenter.class, new RoutePresenter$$ViewStateProvider());
		sViewStateProviders.put(RouteDetailPresenter.class, new RouteDetailPresenter$$ViewStateProvider());

		sPresenterBinders = new HashMap<>();
		sPresenterBinders.put(AuthCodeFragment.class, Arrays.<Object>asList(new AuthCodeFragment$$PresentersBinder()));
		sPresenterBinders.put(AuthPhoneFragment.class, Arrays.<Object>asList(new AuthPhoneFragment$$PresentersBinder()));
		sPresenterBinders.put(RegistrationFragment.class, Arrays.<Object>asList(new RegistrationFragment$$PresentersBinder()));
		sPresenterBinders.put(HomeFragment.class, Arrays.<Object>asList(new HomeFragment$$PresentersBinder()));
		sPresenterBinders.put(RouteFragment.class, Arrays.<Object>asList(new RouteFragment$$PresentersBinder()));
		sPresenterBinders.put(RouteDetailFragment.class, Arrays.<Object>asList(new RouteDetailFragment$$PresentersBinder()));

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
