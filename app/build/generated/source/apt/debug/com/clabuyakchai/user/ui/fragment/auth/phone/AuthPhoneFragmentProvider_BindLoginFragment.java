package com.clabuyakchai.user.ui.fragment.auth.phone;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = AuthPhoneFragmentProvider_BindLoginFragment.AuthPhoneFragmentSubcomponent.class
)
public abstract class AuthPhoneFragmentProvider_BindLoginFragment {
  private AuthPhoneFragmentProvider_BindLoginFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AuthPhoneFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AuthPhoneFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface AuthPhoneFragmentSubcomponent extends AndroidInjector<AuthPhoneFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AuthPhoneFragment> {}
  }
}
