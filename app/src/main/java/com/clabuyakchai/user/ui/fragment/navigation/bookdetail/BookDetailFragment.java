package com.clabuyakchai.user.ui.fragment.navigation.bookdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BookDetailFragment extends BaseFragment implements BookDetailView, BackButtonListener {
    private static final String ARG_BOOK = "arg_book";
    private TextView datetimeTxt;
    private TextView fromTxt;
    private TextView toTxt;
    private TextView priceTxt;
    private Button cancelReservBtn;

    @Inject
    @InjectPresenter
    BookDetailPresenter presenter;

    @ProvidePresenter
    BookDetailPresenter provideBookDetailPresenter() {
        return presenter;
    }

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        presenter.setRouter(localCiceroneHolder.getCicerone("Book").getRouter());
        datetimeTxt = view.findViewById(R.id.book_detail_datetime_txt);
        fromTxt = view.findViewById(R.id.book_detail_from_txt);
        toTxt = view.findViewById(R.id.book_detail_to_txt);
        priceTxt = view.findViewById(R.id.book_detail_price_txt);
        cancelReservBtn = view.findViewById(R.id.book_detail_cancel_btn);

        BookingDto bookingDto = (BookingDto) getArguments().getSerializable(ARG_BOOK);
        if (bookingDto != null){
            setTextView(bookingDto);
        }

        cancelReservBtn.setOnClickListener(v -> {
            presenter.onCancelReservationClicked(bookingDto.getBookingID());
        });
    }

    private void setTextView(BookingDto bookingDto) {
        datetimeTxt.setText(bookingDto.getDatetime());
        fromTxt.setText(bookingDto.getFrom());
        toTxt.setText(bookingDto.getTo());
        priceTxt.setText(String.valueOf(bookingDto.getPrice()));
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }

    public static BookDetailFragment newInstance(BookingDto bookingDto) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOK, bookingDto);

        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
