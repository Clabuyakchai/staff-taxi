// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff.data.repository.Impl;

import com.clabuyakchai.staff.data.local.AppDatabase;
import com.clabuyakchai.staff.data.remote.StaffApi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HomeRepositoryImpl_Factory implements Factory<HomeRepositoryImpl> {
  private final Provider<StaffApi> staffApiProvider;

  private final Provider<AppDatabase> databaseProvider;

  public HomeRepositoryImpl_Factory(
      Provider<StaffApi> staffApiProvider, Provider<AppDatabase> databaseProvider) {
    this.staffApiProvider = staffApiProvider;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public HomeRepositoryImpl get() {
    return new HomeRepositoryImpl(staffApiProvider.get(), databaseProvider.get());
  }

  public static HomeRepositoryImpl_Factory create(
      Provider<StaffApi> staffApiProvider, Provider<AppDatabase> databaseProvider) {
    return new HomeRepositoryImpl_Factory(staffApiProvider, databaseProvider);
  }

  public static HomeRepositoryImpl newHomeRepositoryImpl(StaffApi staffApi, AppDatabase database) {
    return new HomeRepositoryImpl(staffApi, database);
  }
}
