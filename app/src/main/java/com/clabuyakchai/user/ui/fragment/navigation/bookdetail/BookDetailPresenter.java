package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.BookRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class BookDetailPresenter extends BasePresenter<BookDetailView> {
    private final BookRepository bookRepository;
    private Router router;

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

    public void setRouter(Router router) {
        this.router = router;
    }

    private void cancelBook(Long bookId){
        Disposable disposable = bookRepository.cancelBook(bookId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onBackPressed, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void onBackPressed() {
        router.exit();
    }
}
