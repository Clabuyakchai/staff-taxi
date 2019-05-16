// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import androidx.fragment.app.Fragment;
import com.clabuyakchai.user.ui.base.BaseFragment_MembersInjector;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BookDetailFragment_MembersInjector
    implements MembersInjector<BookDetailFragment> {
  private final Provider<DispatchingAndroidInjector<Fragment>>
      fragmentDispatchingAndroidInjectorProvider;

  private final Provider<BookDetailPresenter> presenterProvider;

  private final Provider<LocalCiceroneHolder> localCiceroneHolderProvider;

  public BookDetailFragment_MembersInjector(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<BookDetailPresenter> presenterProvider,
      Provider<LocalCiceroneHolder> localCiceroneHolderProvider) {
    this.fragmentDispatchingAndroidInjectorProvider = fragmentDispatchingAndroidInjectorProvider;
    this.presenterProvider = presenterProvider;
    this.localCiceroneHolderProvider = localCiceroneHolderProvider;
  }

  public static MembersInjector<BookDetailFragment> create(
      Provider<DispatchingAndroidInjector<Fragment>> fragmentDispatchingAndroidInjectorProvider,
      Provider<BookDetailPresenter> presenterProvider,
      Provider<LocalCiceroneHolder> localCiceroneHolderProvider) {
    return new BookDetailFragment_MembersInjector(
        fragmentDispatchingAndroidInjectorProvider, presenterProvider, localCiceroneHolderProvider);
  }

  @Override
  public void injectMembers(BookDetailFragment instance) {
    BaseFragment_MembersInjector.injectFragmentDispatchingAndroidInjector(
        instance, fragmentDispatchingAndroidInjectorProvider.get());
    injectPresenter(instance, presenterProvider.get());
    injectLocalCiceroneHolder(instance, localCiceroneHolderProvider.get());
  }

  public static void injectPresenter(BookDetailFragment instance, BookDetailPresenter presenter) {
    instance.presenter = presenter;
  }

  public static void injectLocalCiceroneHolder(
      BookDetailFragment instance, LocalCiceroneHolder localCiceroneHolder) {
    instance.localCiceroneHolder = localCiceroneHolder;
  }
}
