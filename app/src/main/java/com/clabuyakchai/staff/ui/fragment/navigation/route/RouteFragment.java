package com.clabuyakchai.staff.ui.fragment.navigation.route;

import android.app.DatePickerDialog;
import android.content.Context;
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
import com.clabuyakchai.staff.ui.activity.FragmentStack;
import com.clabuyakchai.staff.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.staff.ui.base.BaseFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.adapter.RouteAdapter;
import com.clabuyakchai.staff.ui.fragment.navigation.route.adapter.RouteIdListener;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailFragment;
import com.clabuyakchai.staff.util.DateHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RouteFragment extends BaseFragment implements RouteView, RouteIdListener {
    private RecyclerView recyclerView;
    private RouteAdapter routeAdapter;
    private TextView calendarTxt;
    private DatePickerDialog datePickerDialog;

    @Inject
    @InjectPresenter
    RoutePresenter presenter;

    private FragmentStack fragmentStack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof NavigationActivity){
            fragmentStack = (NavigationActivity)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.route_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        calendarTxt = view.findViewById(R.id.route_calendar);
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

    public static RouteFragment newInstance() {
        return new RouteFragment();
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, monthOfYear, dayOfMonth) -> {
        String date = DateHelper.formatDate(getDateFromDatePicker(datePicker));
        setCalendarText(date);
        presenter.getRouteByDatetime(date);
    };

    private void setCalendarText(String date) {
        calendarTxt.setText(date);
    }

    private static Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    @Override
    public void fragmentDetails(Long id) {
//        fragmentStack.add(RouteDetailFragment.newInstance(id), true);//TODO
        getChildFragmentManager().beginTransaction().replace(R.id.route_container, RouteDetailFragment.newInstance(id))
                .addToBackStack(RouteDetailFragment.class.getName()).commit();
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        fragmentStack = null;
        super.onDestroy();
    }
}
