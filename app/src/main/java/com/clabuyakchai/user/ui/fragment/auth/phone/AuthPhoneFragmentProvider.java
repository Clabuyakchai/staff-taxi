package com.clabuyakchai.user.ui.fragment.auth.phone;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface AuthPhoneFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    AuthPhoneFragment bindLoginFragment();
}
