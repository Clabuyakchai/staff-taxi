package com.clabuyakchai.staff.ui.fragment.navigation.routedetail;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.repository.RouteRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class RouteDetailPresenter extends BasePresenter<RouteDetailView> {
    private final RouteRepository routeRepository;
    private Router router;

    @Inject
    public RouteDetailPresenter(RouteRepository routeRepository) {
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

    public void setRouter(Router router) {
        this.router = router;
    }

    public void findLocalByRouteId(Long id){
        Disposable disposable = routeRepository.findLocalByRouteId(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(locals -> {
                    getViewState().setRouteDetailAdapter(locals);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    public void onBackPressed() {
        router.exit();
    }
}
