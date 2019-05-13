package com.clabuyakchai.user.ui.fragment.navigation.routedetail;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      RouteDetailFragmentProvider_BindRouteDetailFragment.RouteDetailFragmentSubcomponent.class
)
public abstract class RouteDetailFragmentProvider_BindRouteDetailFragment {
  private RouteDetailFragmentProvider_BindRouteDetailFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RouteDetailFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RouteDetailFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface RouteDetailFragmentSubcomponent extends AndroidInjector<RouteDetailFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RouteDetailFragment> {}
  }
}
