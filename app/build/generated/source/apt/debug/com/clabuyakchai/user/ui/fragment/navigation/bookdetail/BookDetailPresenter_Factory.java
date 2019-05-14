// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import com.clabuyakchai.user.data.repository.BookRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BookDetailPresenter_Factory implements Factory<BookDetailPresenter> {
  private final Provider<BookRepository> bookRepositoryProvider;

  public BookDetailPresenter_Factory(Provider<BookRepository> bookRepositoryProvider) {
    this.bookRepositoryProvider = bookRepositoryProvider;
  }

  @Override
  public BookDetailPresenter get() {
    return new BookDetailPresenter(bookRepositoryProvider.get());
  }

  public static BookDetailPresenter_Factory create(
      Provider<BookRepository> bookRepositoryProvider) {
    return new BookDetailPresenter_Factory(bookRepositoryProvider);
  }

  public static BookDetailPresenter newBookDetailPresenter(BookRepository bookRepository) {
    return new BookDetailPresenter(bookRepository);
  }
}