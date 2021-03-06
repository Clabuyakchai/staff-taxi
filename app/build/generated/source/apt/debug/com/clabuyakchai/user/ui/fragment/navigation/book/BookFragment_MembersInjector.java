// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.book;

import androidx.fragment.app.Fragment;
import com.clabuyakchai.user.ui.base.BaseFragment_MembersInjector;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BookFragment_MembersInjector implements MembersInjector<BookFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  private final Provider<BookPresenter> presenterProvider;

  private final Provider<LocalCiceroneHolder> localCiceroneHolderProvider;

  public BookFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<BookPresenter> presenterProvider,
      Provider<LocalCiceroneHolder> localCiceroneHolderProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
    this.presenterProvider = presenterProvider;
    this.localCiceroneHolderProvider = localCiceroneHolderProvider;
  }

  public static MembersInjector<BookFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<BookPresenter> presenterProvider,
      Provider<LocalCiceroneHolder> localCiceroneHolderProvider) {
    return new BookFragment_MembersInjector(
        fragmentDispatchingAndroidInjectorProvider, presenterProvider, localCiceroneHolderProvider);
  }

  @Override
  public void injectMembers(BookFragment instance) {
    BaseFragment_MembersInjector.injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
    injectPresenter(instance, presenterProvider.get());
    injectLocalCiceroneHolder(instance, localCiceroneHolderProvider.get());
  }

  public static void injectPresenter(BookFragment instance, BookPresenter presenter) {
    instance.presenter = presenter;
  }

  public static void injectLocalCiceroneHolder(
      BookFragment instance, LocalCiceroneHolder localCiceroneHolder) {
    instance.localCiceroneHolder = localCiceroneHolder;
  }
}
