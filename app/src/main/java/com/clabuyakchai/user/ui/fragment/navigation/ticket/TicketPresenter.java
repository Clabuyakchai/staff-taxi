package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;
import com.clabuyakchai.user.util.Screens;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class TicketPresenter extends BasePresenter<TicketView> {
    private final RouteRepository repository;
    private Router router;

    @Inject
    public TicketPresenter(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void onSelected(String from, String to, String datetime){
        if(from != null && to != null) {
            findRouteByParam(from, to, datetime);
        }
    }

    private void findRouteByParam(String from, String to, String datetime){
        Disposable disposable = repository.findRouteByParam(from, to, datetime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(routeDtos -> {getViewState().setAdapter(routeDtos);}, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void onItemTicketClicked(RouteDto routeDto){
        router.navigateTo(new Screens.TicketDetailScreen(routeDto));
    }

    public void onBackPressed() {
        router.exit();
    }
}
