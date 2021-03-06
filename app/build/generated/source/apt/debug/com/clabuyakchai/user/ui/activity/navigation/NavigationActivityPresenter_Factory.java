// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.activity.navigation;

import com.clabuyakchai.user.data.repository.HomeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
import ru.terrakok.cicerone.Router;

public final class NavigationActivityPresenter_Factory
    implements Factory<NavigationActivityPresenter> {
  private final Provider<HomeRepository> homeRepositoryProvider;

  private final Provider<Router> routerProvider;

  public NavigationActivityPresenter_Factory(
      Provider<HomeRepository> homeRepositoryProvider, Provider<Router> routerProvider) {
    this.homeRepositoryProvider = homeRepositoryProvider;
    this.routerProvider = routerProvider;
  }

  @Override
  public NavigationActivityPresenter get() {
    return new NavigationActivityPresenter(homeRepositoryProvider.get(), routerProvider.get());
  }

  public static NavigationActivityPresenter_Factory create(
      Provider<HomeRepository> homeRepositoryProvider, Provider<Router> routerProvider) {
    return new NavigationActivityPresenter_Factory(homeRepositoryProvider, routerProvider);
  }

  public static NavigationActivityPresenter newNavigationActivityPresenter(
      HomeRepository homeRepository, Router router) {
    return new NavigationActivityPresenter(homeRepository, router);
  }
}
