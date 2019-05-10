package com.clabuyakchai.staff.ui.fragment.navigation.route;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.repository.RouteRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;
import com.clabuyakchai.staff.util.DateHelper;
import com.clabuyakchai.staff.util.Screens;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class RoutePresenter extends BasePresenter<RouteView> {
    private final RouteRepository routeRepository;
    private Router router;

    @Inject
    public RoutePresenter(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getRouteByDatetime(DateHelper.formatDate());
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void getRouteByDatetime(String datetime){
        Disposable disposable = routeRepository.findRouteByStaffAndTime(datetime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(routeDtos -> {
                    if (routeDtos.size() != 0){
                        getViewState().setRouteAdapter(routeDtos);
                    }
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    public void onRouteDetailClicked(Long id){
        router.navigateTo(new Screens.RouteDetailScreen(id));
    }

    public void onBackPressed() {
        router.exit();
    }
}
