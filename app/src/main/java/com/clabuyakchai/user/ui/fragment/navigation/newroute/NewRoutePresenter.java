package com.clabuyakchai.user.ui.fragment.navigation.newroute;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.data.repository.StationRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class NewRoutePresenter extends BasePresenter<NewRouteView> {
    private final StationRepository stationRepository;
    private final RouteRepository routeRepository;
    private Router router;

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

    public void onTextChanged(String cityFrom, String cityTo){
        if(cityFrom != null && cityTo != null) {
            getStationsByCity(cityFrom, cityTo);
        }
    }

    private void createRoute(RouteDto routeDto, List<StationItemWithSwitch> stations){
        Disposable disposable = routeRepository.createRoute(routeDto, stations)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onBackPressed, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void getStationsByCity(String cityFrom, String cityTo){
        Disposable disposable = stationRepository.getAllStationByCityDto(cityFrom, cityTo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stationDtos -> getViewState().setAdapter(stationDtos), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void onBackPressed() {
        router.exit();
    }
}
