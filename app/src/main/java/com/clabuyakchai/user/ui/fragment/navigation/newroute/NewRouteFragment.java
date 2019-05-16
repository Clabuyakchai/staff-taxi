package com.clabuyakchai.user.ui.fragment.navigation.newroute;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.NewRouteAdapter;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationClickListener;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import com.clabuyakchai.user.util.DateHelper;
import com.clabuyakchai.user.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class NewRouteFragment extends BaseFragment implements NewRouteView, StationClickListener, BackButtonListener {
    private AppCompatSpinner fromSpin;
    private AppCompatSpinner toSpin;
    private EditText priceEdtx;
    private TextView dateTxt;
    private TextView timeTxt;
    private FloatingActionButton saveBtn;
    private RecyclerView recyclerView;
    private NewRouteAdapter adapter;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private List<StationItemWithSwitch> listStations = new ArrayList<>();
    private int counter = 0;

    @Inject
    @InjectPresenter
    NewRoutePresenter presenter;

    @ProvidePresenter
    NewRoutePresenter provideNewRoutePresenter(){
        return presenter;
    }

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_route_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        presenter.setRouter(localCiceroneHolder.getCicerone("Route").getRouter());
        fromSpin = view.findViewById(R.id.new_route_from);
        toSpin = view.findViewById(R.id.new_route_to);
        priceEdtx = view.findViewById(R.id.new_route_price);
        dateTxt = view.findViewById(R.id.new_route_date);
        timeTxt = view.findViewById(R.id.new_route_time);
        saveBtn = view.findViewById(R.id.new_route_save_float);

        recyclerView = view.findViewById(R.id.new_route_recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new NewRouteAdapter(this);
        recyclerView.setAdapter(adapter);

        setSpinnerAdapter();
        fromSpin.setOnItemSelectedListener(itemSelectedListener);
        toSpin.setOnItemSelectedListener(itemSelectedListener);

        setDatePicker();
        setTimePicker();
        setDateText(DateHelper.formatDate());
        setTimeText(DateHelper.formatTime());

        dateTxt.setOnClickListener(v -> {
            datePickerDialog.show();
        });

        timeTxt.setOnClickListener(v -> {
            timePickerDialog.show();
        });

        saveBtn.setOnClickListener(v -> {
            RouteDto routeDto = new RouteDto(1L ,fromSpin.getSelectedItem().toString(),
                    toSpin.getSelectedItem().toString(),
                    Float.parseFloat(priceEdtx.getText().toString()),
                    dateTxt.getText().toString() + " " + timeTxt.getText().toString());

            presenter.onSaveClicked(routeDto, listStations);
        });
    }

    private AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            presenter.onSpinnerSelected(fromSpin.getSelectedItem().toString(), toSpin.getSelectedItem().toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private void setSpinnerAdapter() {
        String[] cities = {"--Select--" ,"Minsk", "Volozhin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpin.setAdapter(adapter);
        toSpin.setAdapter(adapter);
    }

    private void setTimePicker() {
        Calendar calendar = getInstance();
        timePickerDialog = new TimePickerDialog(getContext(),
                timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true);
    }

    private void setDatePicker() {
        Calendar calendar = getInstance();
        datePickerDialog = new DatePickerDialog(getContext(),
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, monthOfYear, dayOfMonth) -> {
        String date = DateHelper.formatDate(getDateFromDatePicker(datePicker));
        setDateText(date);
    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = (timePicker, i, i1) -> {
        String time = DateHelper.formatTime(getTimeFromTimePicker(timePicker));
        setTimeText(time);
    };

    private void setDateText(String date) {
        dateTxt.setText(date);
    }

    private void setTimeText(String time) {
        timeTxt.setText(time);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private static Date getTimeFromTimePicker(TimePicker timePicker) {
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        Calendar calendar = getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);

        return calendar.getTime();
    }

    private static Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    private static Calendar getInstance() {
        return Calendar.getInstance();
    }

    @Override
    public void onStationClicked(StationItemWithSwitch station) {
        listStations.add(station);
    }

    @Override
    public void setAdapter(List<StationItemWithSwitch> stations) {
        adapter.setList(stations);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
    }

    public static NewRouteFragment newInstance() {
        return new NewRouteFragment();
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
