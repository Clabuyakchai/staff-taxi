// Generated by Dagger (https://google.github.io/dagger).
package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.clabuyakchai.user.data.repository.BookRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TicketDetailPresenter_Factory implements Factory<TicketDetailPresenter> {
  private final Provider<BookRepository> bookRepositoryProvider;

  public TicketDetailPresenter_Factory(Provider<BookRepository> bookRepositoryProvider) {
    this.bookRepositoryProvider = bookRepositoryProvider;
  }

  @Override
  public TicketDetailPresenter get() {
    return new TicketDetailPresenter(bookRepositoryProvider.get());
  }

  public static TicketDetailPresenter_Factory create(
      Provider<BookRepository> bookRepositoryProvider) {
    return new TicketDetailPresenter_Factory(bookRepositoryProvider);
  }

  public static TicketDetailPresenter newTicketDetailPresenter(BookRepository bookRepository) {
    return new TicketDetailPresenter(bookRepository);
  }
}
