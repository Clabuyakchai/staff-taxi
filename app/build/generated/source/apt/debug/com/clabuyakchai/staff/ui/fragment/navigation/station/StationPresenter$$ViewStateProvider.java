package com.clabuyakchai.staff.ui.fragment.navigation.station;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.ViewStateProvider;
import com.arellomobile.mvp.viewstate.MvpViewState;
import java.lang.Override;

public class StationPresenter$$ViewStateProvider extends ViewStateProvider {
	@Override
	public MvpViewState<? extends MvpView> getViewState() {
		return new StationView$$State();
	}
}
