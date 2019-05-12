package com.clabuyakchai.staff.ui.fragment.navigation.newroute.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.StationDto;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

public class NewRouteAdapter extends RecyclerView.Adapter<NewRouteAdapter.NewRouteHolder> {
    private List<StationItemWithSwitch> list;
    private StationClickListener listener;

    public NewRouteAdapter(StationClickListener listener) {
        this.list = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewRouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_new_route_item, parent, false);
        final NewRouteHolder holder = new NewRouteHolder(view);

        holder.getStationAddSwtch().setOnClickListener(v -> {
            int position = holder.getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {
                list.get(position).setShow(!list.get(position).getShow());
                listener.onStationClicked(list.get(position));
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewRouteHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<StationItemWithSwitch> list) {
        this.list = list;
    }

    class NewRouteHolder extends RecyclerView.ViewHolder {
        private TextView nameTxt;
        private TextView cityTxt;
        private SwitchCompat stationAddSwtch;

        public NewRouteHolder(@NonNull View itemView) {
            super(itemView);

            nameTxt = itemView.findViewById(R.id.new_route_item_name);
            cityTxt = itemView.findViewById(R.id.new_route_item_city);
            stationAddSwtch = itemView.findViewById(R.id.new_route_item_switch);
        }

        public void bind(StationItemWithSwitch station) {
            nameTxt.setText(station.getName());
            cityTxt.setText(station.getCity());
            stationAddSwtch.setChecked(station.getShow());
        }

        public SwitchCompat getStationAddSwtch() {
            return stationAddSwtch;
        }
    }
}
