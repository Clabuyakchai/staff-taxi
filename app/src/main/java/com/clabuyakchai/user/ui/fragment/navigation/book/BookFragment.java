package com.clabuyakchai.user.ui.fragment.navigation.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.book.adapter.BookListener;
import com.clabuyakchai.user.ui.fragment.navigation.book.adapter.BookAdapter;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookFragment extends BaseFragment implements BookView, BookListener, BackButtonListener {
    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Inject
    @InjectPresenter
    BookPresenter presenter;

    @ProvidePresenter
    BookPresenter providePresenter(){
        return presenter;
    }

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        presenter.setRouter(localCiceroneHolder.getCicerone("Book").getRouter());
        recyclerView = view.findViewById(R.id.my_route_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "STOP", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRouteAdapter(List<BookingDto> list) {
        adapter = new BookAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBookItemClicked(BookingDto bookingDto) {
        presenter.onItemBookClicked(bookingDto);
    }

    public static BookFragment newInstance(){
        return new BookFragment();
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
