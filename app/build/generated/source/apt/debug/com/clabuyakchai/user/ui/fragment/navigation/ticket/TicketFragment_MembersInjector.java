// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import androidx.fragment.app.Fragment;
import com.clabuyakchai.user.ui.base.BaseFragment_MembersInjector;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class TicketFragment_MembersInjector implements MembersInjector<TicketFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  private final Provider<TicketPresenter> presenterProvider;

  private final Provider<LocalCiceroneHolder> localCiceroneHolderProvider;

  public TicketFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<TicketPresenter> presenterProvider,
      Provider<LocalCiceroneHolder> localCiceroneHolderProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
    this.presenterProvider = presenterProvider;
    this.localCiceroneHolderProvider = localCiceroneHolderProvider;
  }

  public static MembersInjector<TicketFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<TicketPresenter> presenterProvider,
      Provider<LocalCiceroneHolder> localCiceroneHolderProvider) {
    return new TicketFragment_MembersInjector(
        fragmentDispatchingAndroidInjectorProvider, presenterProvider, localCiceroneHolderProvider);
  }

  @Override
  public void injectMembers(TicketFragment instance) {
    BaseFragment_MembersInjector.injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
    injectPresenter(instance, presenterProvider.get());
    injectLocalCiceroneHolder(instance, localCiceroneHolderProvider.get());
  }

  public static void injectPresenter(TicketFragment instance, TicketPresenter presenter) {
    instance.presenter = presenter;
  }

  public static void injectLocalCiceroneHolder(
      TicketFragment instance, LocalCiceroneHolder localCiceroneHolder) {
    instance.localCiceroneHolder = localCiceroneHolder;
  }
}