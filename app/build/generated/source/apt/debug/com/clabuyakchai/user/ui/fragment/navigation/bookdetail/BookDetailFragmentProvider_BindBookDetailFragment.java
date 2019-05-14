package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      BookDetailFragmentProvider_BindBookDetailFragment.BookDetailFragmentSubcomponent.class
)
public abstract class BookDetailFragmentProvider_BindBookDetailFragment {
  private BookDetailFragmentProvider_BindBookDetailFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BookDetailFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BookDetailFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface BookDetailFragmentSubcomponent extends AndroidInjector<BookDetailFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BookDetailFragment> {}
  }
}
