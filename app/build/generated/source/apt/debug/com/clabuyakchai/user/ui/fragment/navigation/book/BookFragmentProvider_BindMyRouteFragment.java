package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = BookFragmentProvider_BindMyRouteFragment.BookFragmentSubcomponent.class)
public abstract class BookFragmentProvider_BindMyRouteFragment {
  private BookFragmentProvider_BindMyRouteFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BookFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BookFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface BookFragmentSubcomponent extends AndroidInjector<BookFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BookFragment> {}
  }
}
