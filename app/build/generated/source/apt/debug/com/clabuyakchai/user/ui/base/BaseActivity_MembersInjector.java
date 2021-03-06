// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.base;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
  private final Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<android.app.Fragment>>
      frameworkFragmentInjectorProvider;

  public BaseActivity_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>>
          frameworkFragmentInjectorProvider) {
    this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
    this.frameworkFragmentInjectorProvider = frameworkFragmentInjectorProvider;
  }

  public static MembersInjector<BaseActivity> create(
      Provider<DispatchingAndroidInjector<Fragment>> supportFragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<android.app.Fragment>>
          frameworkFragmentInjectorProvider) {
    return new BaseActivity_MembersInjector(
        supportFragmentInjectorProvider, frameworkFragmentInjectorProvider);
  }

  @Override
  public void injectMembers(BaseActivity instance) {
    injectSupportFragmentInjector(instance, supportFragmentInjectorProvider.get());
    injectFrameworkFragmentInjector(instance, frameworkFragmentInjectorProvider.get());
  }

  public static void injectSupportFragmentInjector(
      BaseActivity instance, DispatchingAndroidInjector<Fragment> supportFragmentInjector) {
    instance.supportFragmentInjector = supportFragmentInjector;
  }

  public static void injectFrameworkFragmentInjector(
      BaseActivity instance,
      DispatchingAndroidInjector<android.app.Fragment> frameworkFragmentInjector) {
    instance.frameworkFragmentInjector = frameworkFragmentInjector;
  }
}
