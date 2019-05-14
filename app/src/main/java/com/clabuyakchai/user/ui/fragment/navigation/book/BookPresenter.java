package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;
import com.clabuyakchai.user.util.DateHelper;
import com.clabuyakchai.user.util.Screens;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class BookPresenter extends BasePresenter<BookView> {
    private final BookRepository bookRepository;
    private Router router;

    @Inject
    public BookPresenter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        findBookingByLocalIdAndDatetime(DateHelper.formatDate());
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    private void findBookingByLocalIdAndDatetime(String datetime){
        Disposable disposable = bookRepository.findBookingByLocalIdAndDatetime(datetime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(booking -> getViewState().setRouteAdapter(booking), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void onItemBookClicked(BookingDto bookingDto){
        router.navigateTo(new Screens.BookDetailScreen(bookingDto));
    }
}
