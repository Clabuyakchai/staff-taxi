package com.clabuyakchai.staff.ui.fragment.navigation.newroute;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.remote.request.RouteDto;
import com.clabuyakchai.staff.data.repository.RouteRepository;
import com.clabuyakchai.staff.data.repository.StationRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;
import com.clabuyakchai.staff.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class NewRoutePresenter extends BasePresenter<NewRouteView> {
    private final StationRepository stationRepository;
    private final RouteRepository routeRepository;

    @Inject
    public NewRoutePresenter(StationRepository stationRepository, RouteRepository routeRepository) {
        this.stationRepository = stationRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void onSaveClicked(RouteDto routeDto, List<StationItemWithSwitch> stations){
        createRoute(routeDto, stations);
    }

    public void onSpinnerSelected(String cityFrom, String cityTo){
        getStationsByCity(cityFrom, cityTo);
    }

    private void createRoute(RouteDto routeDto, List<StationItemWithSwitch> stations){
        Disposable disposable = routeRepository.createRoute(routeDto, stations)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    getViewState().showSnackBar("Route was created");
                }, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void getStationsByCity(String cityFrom, String cityTo){
        Disposable disposable = stationRepository.getAllStationByCityDto(cityFrom, cityTo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stationDtos -> getViewState().setAdapter(stationDtos), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }
}
