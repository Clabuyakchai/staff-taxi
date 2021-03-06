// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.data.repository.HomeRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HomePresenter_Factory implements Factory<HomePresenter> {
  private final Provider<HomeRepository> homeRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public HomePresenter_Factory(
      Provider<HomeRepository> homeRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.homeRepositoryProvider = homeRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public HomePresenter get() {
    return new HomePresenter(homeRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static HomePresenter_Factory create(
      Provider<HomeRepository> homeRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new HomePresenter_Factory(homeRepositoryProvider, authRepositoryProvider);
  }

  public static HomePresenter newHomePresenter(
      HomeRepository homeRepository, AuthRepository authRepository) {
    return new HomePresenter(homeRepository, authRepository);
  }
}
