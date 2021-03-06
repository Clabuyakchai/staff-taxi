// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class RemoteModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final RemoteModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public RemoteModule_ProvideRetrofitFactory(
      RemoteModule module, Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return proxyProvideRetrofit(module, okHttpClientProvider.get());
  }

  public static RemoteModule_ProvideRetrofitFactory create(
      RemoteModule module, Provider<OkHttpClient> okHttpClientProvider) {
    return new RemoteModule_ProvideRetrofitFactory(module, okHttpClientProvider);
  }

  public static Retrofit proxyProvideRetrofit(RemoteModule instance, OkHttpClient okHttpClient) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit(okHttpClient),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
