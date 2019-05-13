package com.clabuyakchai.user.di.module;

import com.clabuyakchai.user.di.scope.ActivityScope;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivityModule;
import com.clabuyakchai.user.ui.fragment.auth.code.AuthCodeFragmentProvider;
import com.clabuyakchai.user.ui.fragment.auth.phone.AuthPhoneFragmentProvider;
import com.clabuyakchai.user.ui.fragment.auth.registration.RegistrationFragmentProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityModule_BindLoginActivity.AuthActivitySubcomponent.class)
public abstract class ActivityModule_BindLoginActivity {
  private ActivityModule_BindLoginActivity() {}

  @Binds
  @IntoMap
  @ClassKey(AuthActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      AuthActivitySubcomponent.Builder builder);

  @Subcomponent(
    modules = {
      AuthActivityModule.class,
      AuthPhoneFragmentProvider.class,
      AuthCodeFragmentProvider.class,
      RegistrationFragmentProvider.class
    }
  )
  @ActivityScope
  public interface AuthActivitySubcomponent extends AndroidInjector<AuthActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AuthActivity> {}
  }
}
