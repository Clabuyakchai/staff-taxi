package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;
import com.clabuyakchai.user.util.DateHelper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class BookPresenter extends BasePresenter<BookView> {
    private final BookRepository bookRepository;

    @Inject
    public BookPresenter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        findBookingByLocalIdAndDatetime(DateHelper.formatTime());
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
}
