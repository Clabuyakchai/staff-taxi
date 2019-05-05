package com.clabuyakchai.staff.ui.fragment.auth.phone;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import com.clabuyakchai.staff.ui.fragment.auth.phone.AuthPhoneFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface AuthPhoneFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    AuthPhoneFragment bindLoginFragment();
}
