// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.staff;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import dagger.MembersInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider;

  private final Provider<DispatchingAndroidInjector<BroadcastReceiver>>
      broadcastReceiverInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider;

  private final Provider<DispatchingAndroidInjector<ContentProvider>>
      contentProviderInjectorProvider;

  private final Provider<DispatchingAndroidInjector<androidx.fragment.app.Fragment>>
      supportFragmentInjectorProvider;

  public App_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider,
      Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider,
      Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider,
      Provider<DispatchingAndroidInjector<androidx.fragment.app.Fragment>>
          supportFragmentInjectorProvider) {
    this.activityInjectorProvider = activityInjectorProvider;
    this.broadcastReceiverInjectorProvider = broadcastReceiverInjectorProvider;
    this.fragmentInjectorProvider = fragmentInjectorProvider;
    this.serviceInjectorProvider = serviceInjectorProvider;
    this.contentProviderInjectorProvider = contentProviderInjectorProvider;
    this.supportFragmentInjectorProvider = supportFragmentInjectorProvider;
  }

  public static MembersInjector<App> create(
      Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider,
      Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider,
      Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider,
      Provider<DispatchingAndroidInjector<androidx.fragment.app.Fragment>>
          supportFragmentInjectorProvider) {
    return new App_MembersInjector(
        activityInjectorProvider,
        broadcastReceiverInjectorProvider,
        fragmentInjectorProvider,
        serviceInjectorProvider,
        contentProviderInjectorProvider,
        supportFragmentInjectorProvider);
  }

  @Override
  public void injectMembers(App instance) {
    DaggerApplication_MembersInjector.injectActivityInjector(
        instance, activityInjectorProvider.get());
    DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(
        instance, broadcastReceiverInjectorProvider.get());
    DaggerApplication_MembersInjector.injectFragmentInjector(
        instance, fragmentInjectorProvider.get());
    DaggerApplication_MembersInjector.injectServiceInjector(
        instance, serviceInjectorProvider.get());
    DaggerApplication_MembersInjector.injectContentProviderInjector(
        instance, contentProviderInjectorProvider.get());
    DaggerApplication_MembersInjector.injectSetInjected(instance);
    dagger.android.support.DaggerApplication_MembersInjector.injectSupportFragmentInjector(
        instance, supportFragmentInjectorProvider.get());
  }
}
