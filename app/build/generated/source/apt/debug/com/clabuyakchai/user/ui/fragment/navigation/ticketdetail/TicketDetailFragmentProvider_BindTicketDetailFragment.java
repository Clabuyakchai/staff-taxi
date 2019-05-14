package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.clabuyakchai.user.di.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      TicketDetailFragmentProvider_BindTicketDetailFragment.TicketDetailFragmentSubcomponent.class
)
public abstract class TicketDetailFragmentProvider_BindTicketDetailFragment {
  private TicketDetailFragmentProvider_BindTicketDetailFragment() {}

  @Binds
  @IntoMap
  @ClassKey(TicketDetailFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      TicketDetailFragmentSubcomponent.Builder builder);

  @Subcomponent
  @FragmentScope
  public interface TicketDetailFragmentSubcomponent extends AndroidInjector<TicketDetailFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TicketDetailFragment> {}
  }
}
