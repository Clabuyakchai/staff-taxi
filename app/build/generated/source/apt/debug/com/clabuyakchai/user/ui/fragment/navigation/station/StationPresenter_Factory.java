// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.station;

import com.clabuyakchai.user.data.repository.StationRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class StationPresenter_Factory implements Factory<StationPresenter> {
  private final Provider<StationRepository> stationRepositoryProvider;

  public StationPresenter_Factory(Provider<StationRepository> stationRepositoryProvider) {
    this.stationRepositoryProvider = stationRepositoryProvider;
  }

  @Override
  public StationPresenter get() {
    return new StationPresenter(stationRepositoryProvider.get());
  }

  public static StationPresenter_Factory create(
      Provider<StationRepository> stationRepositoryProvider) {
    return new StationPresenter_Factory(stationRepositoryProvider);
  }

  public static StationPresenter newStationPresenter(StationRepository stationRepository) {
    return new StationPresenter(stationRepository);
  }
}
