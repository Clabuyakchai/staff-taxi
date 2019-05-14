package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = TicketFragmentProvider_BindTicketFragment.TicketFragmentSubcomponent.class)
public abstract class TicketFragmentProvider_BindTicketFragment {
  private TicketFragmentProvider_BindTicketFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TicketFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TicketFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface TicketFragmentSubcomponent extends AndroidInjector<TicketFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TicketFragment> {}
  }
}
