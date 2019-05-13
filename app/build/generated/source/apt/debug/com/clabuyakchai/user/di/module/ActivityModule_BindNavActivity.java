package com.clabuyakchai.user.di.module;

import com.clabuyakchai.user.di.scope.ActivityScope;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.user.ui.activity.navigation.NavigationActivityModule;
import com.clabuyakchai.user.ui.fragment.navigation.bus.BusFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.home.HomeFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.NewRouteFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.route.RouteFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.routedetail.RouteDetailFragmentProvider;
import com.clabuyakchai.user.ui.fragment.navigation.station.StationFragmentProvider;
import com.clabuyakchai.user.ui.fragment.tab.TabNavigationFragmentProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_BindNavActivity.NavigationActivitySubcomponent.class)
public abstract class ActivityModule_BindNavActivity {
  private ActivityModule_BindNavActivity() {}

  @Binds
  @IntoMap
  @ClassKey(NavigationActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      NavigationActivitySubcomponent.Builder builder);

  @Subcomponent(
    modules = {
      HomeFragmentProvider.class,
      RouteFragmentProvider.class,
      RouteDetailFragmentProvider.class,
      NavigationActivityModule.class,
      CiceroneModule.class,
      TabNavigationFragmentProvider.class,
      StationFragmentProvider.class,
      BusFragmentProvider.class,
      NewRouteFragmentProvider.class
    }
  )
  @ActivityScope
  public interface NavigationActivitySubcomponent extends AndroidInjector<NavigationActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NavigationActivity> {}
  }
}
