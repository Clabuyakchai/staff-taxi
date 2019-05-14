package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class TicketDetailPresenter extends BasePresenter<TicketDetailView> {
    private final BookRepository bookRepository;

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
                .subscribe(() -> getViewState().showSnackBar("Successful"), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }
}
