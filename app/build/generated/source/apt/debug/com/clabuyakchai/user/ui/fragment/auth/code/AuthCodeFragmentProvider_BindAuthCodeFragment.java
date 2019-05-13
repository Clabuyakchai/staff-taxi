package com.clabuyakchai.user.ui.fragment.auth.code;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = AuthCodeFragmentProvider_BindAuthCodeFragment.AuthCodeFragmentSubcomponent.class
)
public abstract class AuthCodeFragmentProvider_BindAuthCodeFragment {
  private AuthCodeFragmentProvider_BindAuthCodeFragment() {}

  @Binds
  @IntoMap
  @ClassKey(AuthCodeFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AuthCodeFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface AuthCodeFragmentSubcomponent extends AndroidInjector<AuthCodeFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AuthCodeFragment> {}
  }
}
