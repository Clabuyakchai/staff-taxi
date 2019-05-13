package com.clabuyakchai.user.ui.fragment.navigation.station;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.remote.request.StationDto;
import com.clabuyakchai.user.data.repository.StationRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class StationPresenter extends BasePresenter<StationView> {
    private final StationRepository stationRepository;
    private Router router;

    @Inject
    public StationPresenter(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void onMapReady(){
        getAllStation();
    }

    public void onCityEdtDone(String city){
        getStationByCity(city);
    }

    public void onAddButtonClicked(StationDto stationDto){
        addStation(stationDto);
    }

    private void addStation(StationDto stationDto){
        Disposable disposable = stationRepository.addStation(stationDto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(station -> getViewState().setMarker(station), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void getAllStation(){
        Disposable disposable = stationRepository.getAllStation()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stationItems -> getViewState().setMarker(stationItems), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void getStationByCity(String city){
        Disposable disposable = stationRepository.getAllStationByCity(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stationItems -> getViewState().setMarker(stationItems), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }
}
