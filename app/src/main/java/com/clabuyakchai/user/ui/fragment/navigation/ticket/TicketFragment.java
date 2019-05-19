package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.ticket.adapter.TicketAdapter;
import com.clabuyakchai.user.ui.fragment.navigation.ticket.adapter.TicketItemListener;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import com.clabuyakchai.user.util.DateHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TicketFragment extends BaseFragment implements TicketView, TicketItemListener, BackButtonListener {
    private AppCompatSpinner fromSpin;
    private AppCompatSpinner toSpin;
    private TextView dateTxt;
    private RecyclerView recyclerView;
    private TicketAdapter adapter;
    private DatePickerDialog datePickerDialog;

    @Inject
    @InjectPresenter
    TicketPresenter presenter;

    @ProvidePresenter
    TicketPresenter provideTicketPresenter() {
        return presenter;
    }

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ticket_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        presenter.setRouter(localCiceroneHolder.getCicerone("Ticket").getRouter());
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        fromSpin = view.findViewById(R.id.ticket_from);
        toSpin = view.findViewById(R.id.ticket_to);
        dateTxt = view.findViewById(R.id.ticket_date);
        recyclerView = view.findViewById(R.id.ticket_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new TicketAdapter(this);

        setDatePicker();
        setDateText(DateHelper.formatDate());

        setSpinnerAdapter();
        fromSpin.setOnItemSelectedListener(itemSelectedListener);
        toSpin.setOnItemSelectedListener(itemSelectedListener);

        dateTxt.setOnClickListener(v -> {
            datePickerDialog.show();
        });
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
        Date date = getDateFromDatePicker(datePicker);
        if(date.after(getInstance().getTime())){
            String text = DateHelper.formatDate(date);
            setDateText(text);
            findRouteByParam();
        } else{
            String text = DateHelper.formatDate();
            setDateText(text);
        }
    };

    private AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            findRouteByParam();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private static Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    private void setDateText(String date) {
        dateTxt.setText(date);
    }

    private static Calendar getInstance() {
        return Calendar.getInstance();
    }

    private void setSpinnerAdapter() {
        String[] cities = {"--Select--", "Minsk", "Volozhin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpin.setAdapter(adapter);
        toSpin.setAdapter(adapter);
    }

    private void findRouteByParam() {
        presenter.onSelected(fromSpin.getSelectedItem().toString(), toSpin.getSelectedItem().toString(), dateTxt.getText().toString());
    }

    public static TicketFragment newInstance() {
        return new TicketFragment();
    }

    @Override
    public void setAdapter(List<RouteDto> list) {
        adapter.setRouteList(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onTicketItemClick(RouteDto routeDto) {
        presenter.onItemTicketClicked(routeDto);
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
