package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.ticketdetail.adapter.TicketDetailAdapter;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TicketDetailFragment extends BaseFragment implements TicketDetailView, BackButtonListener {
    private static final String ARG_ROUTE = "args_route";
    private TextView datetimeTxt;
    private TextView fromTxt;
    private TextView toTxt;
    private TextView priceTxt;
    private TextView busTxt;
    private Button reservBtn;
    private RecyclerView recyclerView;
    private TicketDetailAdapter adapter;

    @Inject
    @InjectPresenter
    TicketDetailPresenter presenter;

    @ProvidePresenter
    TicketDetailPresenter provideTicketDetailPresenter(){
        return presenter;
    }

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ticket_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        presenter.setRouter(localCiceroneHolder.getCicerone("Ticket").getRouter());
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        datetimeTxt = view.findViewById(R.id.ticket_detail_datetime_txt);
        fromTxt = view.findViewById(R.id.ticket_detail_from_txt);
        toTxt = view.findViewById(R.id.ticket_detail_to_txt);
        priceTxt = view.findViewById(R.id.ticket_detail_price_txt);
        busTxt = view.findViewById(R.id.ticket_detail_bus_txt);
        reservBtn = view.findViewById(R.id.ticket_detail_reserv_btn);
        recyclerView = view.findViewById(R.id.ticket_detail_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new TicketDetailAdapter();

        RouteDto routeDto = (RouteDto) getArguments().getSerializable(ARG_ROUTE);
        if (routeDto != null){
            setTextView(routeDto);
        }

        reservBtn.setOnClickListener(v -> {
            presenter.onReservationClicked(routeDto.getRouteID());
        });
    }

    private void setTextView(RouteDto routeDto) {
        datetimeTxt.setText(routeDto.getDatetime());
        fromTxt.setText(routeDto.getFrom());
        toTxt.setText(routeDto.getTo());
        priceTxt.setText(String.valueOf(routeDto.getPrice()));
        busTxt.setText(routeDto.getBus().getBusmodel() + " " + routeDto.getBus().getCarNumber());

        adapter.setList(routeDto.getStations());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }

    public static TicketDetailFragment newInstance(RouteDto routeDto){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ROUTE, routeDto);

        TicketDetailFragment fragment = new TicketDetailFragment();
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
