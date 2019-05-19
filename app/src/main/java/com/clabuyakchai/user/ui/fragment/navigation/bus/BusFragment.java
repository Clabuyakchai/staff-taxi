package com.clabuyakchai.user.ui.fragment.navigation.bus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.bus.adapter.BusAdapter;
import com.clabuyakchai.user.ui.fragment.navigation.bus.adapter.BusIdListener;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.LocalCiceroneHolder;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BusFragment extends BaseFragment implements BusView, BusIdListener, BackButtonListener {
    private EditText busModelEdtxt;
    private EditText busNumberEdtxt;
    private Button saveBusBtn;
    private RecyclerView recyclerView;
    private BusAdapter busAdapter;

    @Inject
    @InjectPresenter
    BusPresenter presenter;

    @ProvidePresenter
    BusPresenter provideBusPresenter() {
        return presenter;
    }

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bus_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        presenter.setRouter(localCiceroneHolder.getCicerone("Home").getRouter());
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        busModelEdtxt = view.findViewById(R.id.bus_model);
        busNumberEdtxt = view.findViewById(R.id.bus_number);
        saveBusBtn = view.findViewById(R.id.save_bus);
        recyclerView = view.findViewById(R.id.bus_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        saveBusBtn.setOnClickListener(v -> {
            presenter.onSaveButtonClicked(busModelEdtxt.getText().toString(), busNumberEdtxt.getText().toString());
        });
    }

    public static BusFragment newInstance() {
        return new BusFragment();
    }

    @Override
    public void setBusAdapter(List<BusDto> list) {
        busAdapter = new BusAdapter(list, this);
        recyclerView.setAdapter(busAdapter);
    }

    @Override
    public void onBusClicked(Long busId) {
        presenter.onItemClicked(busId);
    }

    @Override
    public void setItemInBusAdapter(BusDto bus) {
        busAdapter.addListBus(bus);
    }

    @Override
    public void showSnackBar(String text) {
        Snackbar.make(getView(), text, Snackbar.LENGTH_SHORT).show();
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
