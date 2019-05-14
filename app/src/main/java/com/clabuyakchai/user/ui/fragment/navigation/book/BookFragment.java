package com.clabuyakchai.user.ui.fragment.navigation.book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.route.adapter.RouteIdListener;
import com.clabuyakchai.user.ui.fragment.navigation.book.adapter.BookAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookFragment extends BaseFragment implements BookView, RouteIdListener {
    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Inject
    @InjectPresenter
    BookPresenter presenter;

    @ProvidePresenter
    BookPresenter providePresenter(){
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_route_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        recyclerView = view.findViewById(R.id.my_route_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void setRouteAdapter(List<BookingDto> list) {
        adapter = new BookAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void fragmentDetails(Long id) {
        //TODO bookdetails
    }

    public static BookFragment newInstance(){
        return new BookFragment();
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }
}
