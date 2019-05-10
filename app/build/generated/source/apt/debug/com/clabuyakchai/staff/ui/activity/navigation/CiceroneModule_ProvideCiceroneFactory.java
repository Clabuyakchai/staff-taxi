// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff.ui.activity.navigation;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Router;

public final class CiceroneModule_ProvideCiceroneFactory implements Factory<Cicerone<Router>> {
  private final CiceroneModule module;

  public CiceroneModule_ProvideCiceroneFactory(CiceroneModule module) {
    this.module = module;
  }

  @Override
  public Cicerone<Router> get() {
    return proxyProvideCicerone(module);
  }

  public static CiceroneModule_ProvideCiceroneFactory create(CiceroneModule module) {
    return new CiceroneModule_ProvideCiceroneFactory(module);
  }

  public static Cicerone<Router> proxyProvideCicerone(CiceroneModule instance) {
    return Preconditions.checkNotNull(
        instance.provideCicerone(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
