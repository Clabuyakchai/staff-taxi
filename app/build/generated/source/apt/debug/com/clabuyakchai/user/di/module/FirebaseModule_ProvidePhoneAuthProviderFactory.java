// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.di.module;

import com.google.firebase.auth.PhoneAuthProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FirebaseModule_ProvidePhoneAuthProviderFactory
    implements Factory<PhoneAuthProvider> {
  private final FirebaseModule module;

  public FirebaseModule_ProvidePhoneAuthProviderFactory(FirebaseModule module) {
    this.module = module;
  }

  @Override
  public PhoneAuthProvider get() {
    return proxyProvidePhoneAuthProvider(module);
  }

  public static FirebaseModule_ProvidePhoneAuthProviderFactory create(FirebaseModule module) {
    return new FirebaseModule_ProvidePhoneAuthProviderFactory(module);
  }

  public static PhoneAuthProvider proxyProvidePhoneAuthProvider(FirebaseModule instance) {
    return Preconditions.checkNotNull(
        instance.providePhoneAuthProvider(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
