package com.clabuyakchai.staff.di.module;

import com.clabuyakchai.staff.di.scope.ActivityScope;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivityModule;
import com.clabuyakchai.staff.ui.fragment.auth.code.AuthCodeFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragmentProvider;
import com.clabuyakchai.staff.ui.fragment.auth.registration.RegistrationFragmentProvider;
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