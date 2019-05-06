// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff.di.module;

import com.google.firebase.auth.FirebaseAuth;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FirebaseModule_ProvideFirebaseAuthFactory implements Factory<FirebaseAuth> {
  private final FirebaseModule module;

  public FirebaseModule_ProvideFirebaseAuthFactory(FirebaseModule module) {
    this.module = module;
  }

  @Override
  public FirebaseAuth get() {
    return proxyProvideFirebaseAuth(module);
  }

  public static FirebaseModule_ProvideFirebaseAuthFactory create(FirebaseModule module) {
    return new FirebaseModule_ProvideFirebaseAuthFactory(module);
  }

  public static FirebaseAuth proxyProvideFirebaseAuth(FirebaseModule instance) {
    return Preconditions.checkNotNull(
        instance.provideFirebaseAuth(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
