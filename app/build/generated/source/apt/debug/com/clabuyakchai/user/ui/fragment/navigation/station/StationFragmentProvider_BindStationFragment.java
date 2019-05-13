package com.clabuyakchai.user.ui.fragment.navigation.station;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = StationFragmentProvider_BindStationFragment.StationFragmentSubcomponent.class
)
public abstract class StationFragmentProvider_BindStationFragment {
  private StationFragmentProvider_BindStationFragment() {}

  @Binds
  @IntoMap
  @ClassKey(StationFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      StationFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface StationFragmentSubcomponent extends AndroidInjector<StationFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<StationFragment> {}
  }
}
