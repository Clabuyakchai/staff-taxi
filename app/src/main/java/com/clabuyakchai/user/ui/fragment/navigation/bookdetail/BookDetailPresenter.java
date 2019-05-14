package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class BookDetailPresenter extends BasePresenter<BookDetailView> {
    private final BookRepository bookRepository;

    @Inject
    public BookDetailPresenter(BookRepository bookRepository) {
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

    public void onCancelReservationClicked(Long bookId){
        cancelBook(bookId);
    }

    private void cancelBook(Long bookId){
        Disposable disposable = bookRepository.cancelBook(bookId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> getViewState().showSnackBar("The booking had been canceled."), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }
}
