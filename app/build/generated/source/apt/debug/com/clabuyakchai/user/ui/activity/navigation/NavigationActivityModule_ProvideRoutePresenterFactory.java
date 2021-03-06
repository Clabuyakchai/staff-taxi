// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.activity.navigation;

import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.ui.fragment.navigation.route.RoutePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NavigationActivityModule_ProvideRoutePresenterFactory
    implements Factory<RoutePresenter> {
  private final NavigationActivityModule module;

  private final Provider<RouteRepository> routeRepositoryProvider;

  public NavigationActivityModule_ProvideRoutePresenterFactory(
      NavigationActivityModule module, Provider<RouteRepository> routeRepositoryProvider) {
    this.module = module;
    this.routeRepositoryProvider = routeRepositoryProvider;
  }

  @Override
  public RoutePresenter get() {
    return proxyProvideRoutePresenter(module, routeRepositoryProvider.get());
  }

  public static NavigationActivityModule_ProvideRoutePresenterFactory create(
      NavigationActivityModule module, Provider<RouteRepository> routeRepositoryProvider) {
    return new NavigationActivityModule_ProvideRoutePresenterFactory(
        module, routeRepositoryProvider);
  }

  public static RoutePresenter proxyProvideRoutePresenter(
      NavigationActivityModule instance, RouteRepository routeRepository) {
    return Preconditions.checkNotNull(
        instance.provideRoutePresenter(routeRepository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
