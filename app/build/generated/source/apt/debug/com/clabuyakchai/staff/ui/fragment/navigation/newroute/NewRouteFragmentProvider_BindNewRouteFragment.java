package com.clabuyakchai.staff.ui.fragment.navigation.newroute;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = NewRouteFragmentProvider_BindNewRouteFragment.NewRouteFragmentSubcomponent.class
)
public abstract class NewRouteFragmentProvider_BindNewRouteFragment {
  private NewRouteFragmentProvider_BindNewRouteFragment() {}

  @Binds
  @IntoMap
  @ClassKey(NewRouteFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      NewRouteFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface NewRouteFragmentSubcomponent extends AndroidInjector<NewRouteFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NewRouteFragment> {}
  }
}
