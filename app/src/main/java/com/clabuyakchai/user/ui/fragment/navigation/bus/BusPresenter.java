package com.clabuyakchai.user.ui.fragment.navigation.bus;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.data.repository.HomeRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class BusPresenter extends BasePresenter<BusView> {
    private final HomeRepository repository;
    private Router router;

    @Inject
    public BusPresenter(HomeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getAllBus();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void onSaveButtonClicked(String busmodel, String busnumber){
        BusDto busDto = new BusDto(1L, busmodel, busnumber, 17);
        addBus(busDto);
    }

    public void onItemClicked(Long busId){
        driveBus(busId);
    }

    private void addBus(BusDto busDto){
        Disposable disposable = repository.addBus(busDto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bus -> {getViewState().setItemInBusAdapter(bus);}, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void driveBus(Long busId){
        Disposable disposable = repository.driveBus(busId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onBackPressed, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void getAllBus(){
        Disposable disposable = repository.getAllBus()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(busDtos -> getViewState().setBusAdapter(busDtos), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void onBackPressed() {
        router.exit();
    }
}
