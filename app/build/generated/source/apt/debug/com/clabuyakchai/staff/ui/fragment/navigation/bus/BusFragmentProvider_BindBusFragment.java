package com.clabuyakchai.staff.ui.fragment.navigation.bus;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = BusFragmentProvider_BindBusFragment.BusFragmentSubcomponent.class)
public abstract class BusFragmentProvider_BindBusFragment {
  private BusFragmentProvider_BindBusFragment() {}

  @Binds
  @IntoMap
  @ClassKey(BusFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      BusFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface BusFragmentSubcomponent extends AndroidInjector<BusFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BusFragment> {}
  }
}
