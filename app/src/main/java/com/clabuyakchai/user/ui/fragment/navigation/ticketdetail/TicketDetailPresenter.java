package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class TicketDetailPresenter extends BasePresenter<TicketDetailView> {
    private final BookRepository bookRepository;
    private Router router;

    @Inject
    public TicketDetailPresenter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void onReservationClicked(Long timetableId){
        createBook(timetableId);
    }

    private void createBook(Long timetableId){
        Disposable disposable = bookRepository
                .createBook(timetableId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onBackPressed, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void onBackPressed() {
        router.exit();
    }
}
