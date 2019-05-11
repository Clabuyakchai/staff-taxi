package com.clabuyakchai.staff.ui.fragment.navigation.station.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.clabuyakchai.staff.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class StationDialog extends DialogFragment {
    private EditText stationNameEdt;
    private EditText stationCityEdt;
    private StationDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (StationDialogListener) getTargetFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.station_dialog, null, false);

        stationNameEdt = view.findViewById(R.id.station_dialog_name);
        stationCityEdt = view.findViewById(R.id.station_dialog_city);

        return new AlertDialog.Builder(view.getContext())
                .setView(view)
                .setTitle(R.string.new_station)
                .setPositiveButton(R.string.add, (dialogInterface, i) -> {
                    listener.onAddButton(stationNameEdt.getText().toString(), stationCityEdt.getText().toString());
                })
                .setNegativeButton(R.string.cancel,(dialogInterface, i) -> {
                    dismiss();
                }).create();
    }

    public static StationDialog newInstance(){
        return new StationDialog();
    }

    @Override
    public void onDestroyView() {
        listener = null;
        super.onDestroyView();
    }
}
