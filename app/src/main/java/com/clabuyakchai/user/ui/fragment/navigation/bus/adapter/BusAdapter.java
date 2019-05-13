package com.clabuyakchai.user.ui.fragment.navigation.bus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.BusHolder> {
    private List<BusDto> list;
    private BusIdListener listener;

    public BusAdapter(List<BusDto> list, BusIdListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bus_item, parent, false);
        final BusHolder holder = new BusHolder(view);

        holder.itemView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();

            if(position != RecyclerView.NO_POSITION){
                listener.onBusClicked(list.get(position).getBusID());
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BusHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addListBus(BusDto busDto){
        list.add(busDto);
        notifyDataSetChanged();
    }

    class BusHolder extends RecyclerView.ViewHolder {
        private TextView busmodelTxt;
        private TextView busnumberTxt;

        public BusHolder(@NonNull View itemView) {
            super(itemView);

            busmodelTxt = itemView.findViewById(R.id.bus_item_busmodel);
            busnumberTxt = itemView.findViewById(R.id.bus_item_busnumber);
        }

        public void bind(BusDto busDto) {
            busmodelTxt.setText(busDto.getBusmodel());
            busnumberTxt.setText(busDto.getCarNumber());
        }
    }
}
