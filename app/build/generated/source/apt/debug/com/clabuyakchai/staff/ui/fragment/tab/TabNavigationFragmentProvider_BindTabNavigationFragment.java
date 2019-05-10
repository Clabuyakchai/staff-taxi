package com.clabuyakchai.staff.ui.fragment.tab;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      TabNavigationFragmentProvider_BindTabNavigationFragment.TabNavigationFragmentSubcomponent
          .class
)
public abstract class TabNavigationFragmentProvider_BindTabNavigationFragment {
  private TabNavigationFragmentProvider_BindTabNavigationFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TabNavigationFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TabNavigationFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface TabNavigationFragmentSubcomponent
      extends AndroidInjector<TabNavigationFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TabNavigationFragment> {}
  }
}
