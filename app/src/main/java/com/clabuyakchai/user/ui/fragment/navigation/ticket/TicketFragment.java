package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TicketFragment extends BaseFragment implements TicketView, TicketItemListener, BackButtonListener {
    private EditText fromEdtx;
    private EditText toEdtx;
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
        fromEdtx = view.findViewById(R.id.ticket_from);
        toEdtx = view.findViewById(R.id.ticket_to);
        dateTxt = view.findViewById(R.id.ticket_date);
        recyclerView = view.findViewById(R.id.ticket_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new TicketAdapter(this);

        setDatePicker();
        setDateText(DateHelper.formatDate());

        fromEdtx.addTextChangedListener(watcher);
        toEdtx.addTextChangedListener(watcher);

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

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            findRouteByParam();
        }

        @Override
        public void afterTextChanged(Editable editable) {

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

    private void findRouteByParam() {
        presenter.onSelected(fromEdtx.getText().toString(), toEdtx.getText().toString(), dateTxt.getText().toString());
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
