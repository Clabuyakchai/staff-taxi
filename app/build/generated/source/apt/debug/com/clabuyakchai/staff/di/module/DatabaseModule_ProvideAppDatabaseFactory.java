// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff.di.module;

import android.content.Context;
import com.clabuyakchai.staff.data.local.AppDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideAppDatabaseFactory implements Factory<AppDatabase> {
  private final DatabaseModule module;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideAppDatabaseFactory(
      DatabaseModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public AppDatabase get() {
    return proxyProvideAppDatabase(module, contextProvider.get());
  }

  public static DatabaseModule_ProvideAppDatabaseFactory create(
      DatabaseModule module, Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideAppDatabaseFactory(module, contextProvider);
  }

  public static AppDatabase proxyProvideAppDatabase(DatabaseModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideAppDatabase(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
