// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.activity.navigation;

import androidx.fragment.app.Fragment;
import com.clabuyakchai.user.ui.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public final class NavigationActivity_MembersInjector
    implements MembersInjector<NavigationActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<android.app.Fragment>>
      frameworkFragmentInjectorProvider;

  private final Provider<NavigatorHolder> navigatorHolderProvider;

  private final Provider<NavigationActivityPresenter> presenterProvider;

  private final Provider<Router> routerProvider;

  public NavigationActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>> frameworkFragmentInjectorProvider,
      Provider<NavigatorHolder> navigatorHolderProvider,
      Provider<NavigationActivityPresenter> presenterProvider,
      Provider<Router> routerProvider) {
    this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
    this.frameworkFragmentInjectorProvider = frameworkFragmentInjectorProvider;
    this.navigatorHolderProvider = navigatorHolderProvider;
    this.presenterProvider = presenterProvider;
    this.routerProvider = routerProvider;
  }

  public static MembersInjector<NavigationActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>> frameworkFragmentInjectorProvider,
      Provider<NavigatorHolder> navigatorHolderProvider,
      Provider<NavigationActivityPresenter> presenterProvider,
      Provider<Router> routerProvider) {
    return new NavigationActivity_MembersInjector(
        supportFragmentInjectorProvider,
        frameworkFragmentInjectorProvider,
        navigatorHolderProvider,
        presenterProvider,
        routerProvider);
  }

  @Override
  public void injectMembers(NavigationActivity instance) {
    BaseActivity_MembersInjector.injectSupportFragmentInjector(
        instance, supportFragmentInjectorProvider.get());
    BaseActivity_MembersInjector.injectFrameworkFragmentInjector(
        instance, frameworkFragmentInjectorProvider.get());
    injectNavigatorHolder(instance, navigatorHolderProvider.get());
    injectPresenter(instance, presenterProvider.get());
    injectRouter(instance, routerProvider.get());
  }

  public static void injectNavigatorHolder(
      NavigationActivity instance, NavigatorHolder navigatorHolder) {
    instance.navigatorHolder = navigatorHolder;
  }

  public static void injectPresenter(
      NavigationActivity instance, NavigationActivityPresenter presenter) {
    instance.presenter = presenter;
  }

  public static void injectRouter(NavigationActivity instance, Router router) {
    instance.router = router;
  }
}
