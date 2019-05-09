// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff.ui.fragment.navigation.routedetail;

import androidx.fragment.app.Fragment;
import com.clabuyakchai.staff.ui.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class RouteDetailFragment_MembersInjector
    implements MembersInjector<RouteDetailFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  private final Provider<RouteDetailPresenter> presenterProvider;

  public RouteDetailFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<RouteDetailPresenter> presenterProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<RouteDetailFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<RouteDetailPresenter> presenterProvider) {
    return new RouteDetailFragment_MembersInjector(
        fragmentDispatchingAndroidInjectorProvider, presenterProvider);
  }

  @Override
  public void injectMembers(RouteDetailFragment instance) {
    BaseFragment_MembersInjector.injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(RouteDetailFragment instance, RouteDetailPresenter presenter) {
    instance.presenter = presenter;
  }
}
