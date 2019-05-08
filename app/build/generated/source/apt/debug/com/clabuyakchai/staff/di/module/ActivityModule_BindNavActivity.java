package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragmentProvider;
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

  @Subcomponent(modules = {HomeFragmentProvider.class, RouteFragmentProvider.class})
  @ActivityScope
  public interface NavigationActivitySubcomponent extends AndroidInjector<NavigationActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NavigationActivity> {}
  }
}
