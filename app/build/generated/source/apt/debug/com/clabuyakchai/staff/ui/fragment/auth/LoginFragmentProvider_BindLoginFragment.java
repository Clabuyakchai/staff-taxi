package com.clabuyakchai.staff.ui.fragment.auth;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = LoginFragmentProvider_BindLoginFragment.LoginFragmentSubcomponent.class)
public abstract class LoginFragmentProvider_BindLoginFragment {
  private LoginFragmentProvider_BindLoginFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AuthPhoneFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      LoginFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface LoginFragmentSubcomponent extends AndroidInjector<AuthPhoneFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AuthPhoneFragment> {}
  }
}
