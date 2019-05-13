package com.clabuyakchai.user.ui.fragment.navigation.route;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = RouteFragmentProvider_BindRouteFragment.RouteFragmentSubcomponent.class)
public abstract class RouteFragmentProvider_BindRouteFragment {
  private RouteFragmentProvider_BindRouteFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RouteFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RouteFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface RouteFragmentSubcomponent extends AndroidInjector<RouteFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RouteFragment> {}
  }
}
