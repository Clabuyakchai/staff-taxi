package com.clabuyakchai.staff.ui.fragment.navigation.routedetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.LocalDto;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.adapter.CallUserListener;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.adapter.RouteDetailAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RouteDetailFragment extends BaseFragment implements RouteDetailView, CallUserListener {
    private static final String ARG_ID = "timetableID";

    private RecyclerView recyclerView;
    private RouteDetailAdapter adapter;

    private Long routeID = null;

    @Inject
    @InjectPresenter
    RouteDetailPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        routeID = getArguments().getLong(ARG_ID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.route_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        if(routeID != null){
            presenter.findLocalByRouteId(routeID);
        }
        recyclerView = view.findViewById(R.id.route_detail_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void setRouteDetailAdapter(List<LocalDto> list) {
        adapter = new RouteDetailAdapter(list, RouteDetailFragment.this);
        recyclerView.setAdapter(adapter);
    }

    @ProvidePresenter
    RouteDetailPresenter provideRouteDetailPresenter(){
        return presenter;
    }

    public static RouteDetailFragment newInstance(Long timetableID) {
        Bundle args = new Bundle();
        args.putLong(ARG_ID, timetableID);

        RouteDetailFragment fragment = new RouteDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void callUser(String phoneNumber) {
        String uri = "tel:+" + phoneNumber;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }
}