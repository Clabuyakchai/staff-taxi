// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

public final class RemoteModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final RemoteModule module;

  public RemoteModule_ProvideOkHttpClientFactory(RemoteModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return proxyProvideOkHttpClient(module);
  }

  public static RemoteModule_ProvideOkHttpClientFactory create(RemoteModule module) {
    return new RemoteModule_ProvideOkHttpClientFactory(module);
  }

  public static OkHttpClient proxyProvideOkHttpClient(RemoteModule instance) {
    return Preconditions.checkNotNull(
        instance.provideOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
