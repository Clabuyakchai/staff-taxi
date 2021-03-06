// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.auth.registration;

import androidx.fragment.app.Fragment;
import com.clabuyakchai.user.ui.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class RegistrationFragment_MembersInjector
    implements MembersInjector<RegistrationFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  private final Provider<RegistrationPresenter> presenterProvider;

  public RegistrationFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<RegistrationPresenter> presenterProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<RegistrationFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<RegistrationPresenter> presenterProvider) {
    return new RegistrationFragment_MembersInjector(
        fragmentDispatchingAndroidInjectorProvider, presenterProvider);
  }

  @Override
  public void injectMembers(RegistrationFragment instance) {
    BaseFragment_MembersInjector.injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
    injectPresenter(instance, presenterProvider.get());
  }

  public static void injectPresenter(
      RegistrationFragment instance, RegistrationPresenter presenter) {
    instance.presenter = presenter;
  }
}
