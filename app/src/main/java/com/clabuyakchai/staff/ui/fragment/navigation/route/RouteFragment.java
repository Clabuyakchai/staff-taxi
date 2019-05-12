package com.clabuyakchai.staff.ui.fragment.navigation.route;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.RouteDto;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.adapter.RouteAdapter;
import com.clabuyakchai.staff.ui.fragment.navigation.route.adapter.RouteIdListener;
import com.clabuyakchai.staff.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.staff.ui.fragment.tab.LocalCiceroneHolder;
import com.clabuyakchai.staff.util.DateHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RouteFragment extends BaseFragment implements RouteView, RouteIdListener, BackButtonListener {
    private static final String EXTRA_NAME = "extra_name";

    private RecyclerView recyclerView;
    private RouteAdapter routeAdapter;
    private TextView calendarTxt;
    private DatePickerDialog datePickerDialog;
    private FloatingActionButton newRouteBtn;

    @Inject
    @InjectPresenter
    RoutePresenter presenter;

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.route_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        presenter.setRouter(localCiceroneHolder.getCicerone("Route").getRouter());
        calendarTxt = view.findViewById(R.id.route_calendar);
        newRouteBtn = view.findViewById(R.id.route_add_float);
        recyclerView = view.findViewById(R.id.recycler_route);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(view.getContext(),
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        setCalendarText(DateHelper.formatDate());
        calendarTxt.setOnClickListener(v -> {
            datePickerDialog.show();
        });

        newRouteBtn.setOnClickListener(v -> {
            presenter.onNewRouteClicked();
        });
    }

    @Override
    public void setRouteAdapter(List<RouteDto> list) {
        routeAdapter = new RouteAdapter(list, RouteFragment.this);
        recyclerView.setAdapter(routeAdapter);
    }

    @ProvidePresenter
    RoutePresenter provideRoutePresenter() {
        return presenter;
    }

    public static RouteFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString(EXTRA_NAME, name);

        RouteFragment fragment = new RouteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, monthOfYear, dayOfMonth) -> {
        String date = DateHelper.formatDate(getDateFromDatePicker(datePicker));
        setCalendarText(date);
        presenter.getRouteByDatetime(date);
    };

    private void setCalendarText(String date) {
        calendarTxt.setText(date);
    }

    private static Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    @Override
    public void fragmentDetails(Long id) {
        presenter.onRouteDetailClicked(id);
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
