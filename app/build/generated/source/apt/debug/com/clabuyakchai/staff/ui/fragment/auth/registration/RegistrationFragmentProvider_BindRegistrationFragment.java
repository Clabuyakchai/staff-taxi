package com.clabuyakchai.staff.ui.fragment.auth.registration;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      RegistrationFragmentProvider_BindRegistrationFragment.RegistrationFragmentSubcomponent.class
)
public abstract class RegistrationFragmentProvider_BindRegistrationFragment {
  private RegistrationFragmentProvider_BindRegistrationFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RegistrationFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RegistrationFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface RegistrationFragmentSubcomponent extends AndroidInjector<RegistrationFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RegistrationFragment> {}
  }
}
