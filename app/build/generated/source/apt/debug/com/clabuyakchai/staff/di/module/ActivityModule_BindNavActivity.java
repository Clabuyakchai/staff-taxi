package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.nav.NavActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_BindNavActivity.NavActivitySubcomponent.class)
public abstract class ActivityModule_BindNavActivity {
  private ActivityModule_BindNavActivity() {}

  @Binds
  @IntoMap
  @ClassKey(NavActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      NavActivitySubcomponent.Builder builder);

  @Subcomponent
  @ActivityScope
  public interface NavActivitySubcomponent extends AndroidInjector<NavActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NavActivity> {}
  }
}
