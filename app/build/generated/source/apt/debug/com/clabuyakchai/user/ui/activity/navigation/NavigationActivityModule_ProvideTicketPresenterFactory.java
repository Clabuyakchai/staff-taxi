// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.activity.navigation;

import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.ui.fragment.navigation.ticket.TicketPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NavigationActivityModule_ProvideTicketPresenterFactory
    implements Factory<TicketPresenter> {
  private final NavigationActivityModule module;

  private final Provider<RouteRepository> routeRepositoryProvider;

  public NavigationActivityModule_ProvideTicketPresenterFactory(
      NavigationActivityModule module, Provider<RouteRepository> routeRepositoryProvider) {
    this.module = module;
    this.routeRepositoryProvider = routeRepositoryProvider;
  }

  @Override
  public TicketPresenter get() {
    return proxyProvideTicketPresenter(module, routeRepositoryProvider.get());
  }

  public static NavigationActivityModule_ProvideTicketPresenterFactory create(
      NavigationActivityModule module, Provider<RouteRepository> routeRepositoryProvider) {
    return new NavigationActivityModule_ProvideTicketPresenterFactory(
        module, routeRepositoryProvider);
  }

  public static TicketPresenter proxyProvideTicketPresenter(
      NavigationActivityModule instance, RouteRepository routeRepository) {
    return Preconditions.checkNotNull(
        instance.provideTicketPresenter(routeRepository),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
