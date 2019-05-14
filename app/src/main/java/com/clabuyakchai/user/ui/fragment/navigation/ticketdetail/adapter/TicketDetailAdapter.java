package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.StationDto;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TicketDetailAdapter extends RecyclerView.Adapter<TicketDetailAdapter.TicketDetailHolder> {

    private List<StationDto> list;

    @NonNull
    @Override
    public TicketDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TicketDetailHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ticket_details_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TicketDetailHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<StationDto> list) {
        this.list = list;
    }

    class TicketDetailHolder extends RecyclerView.ViewHolder{
        private TextView nameStationTxt;
        private TextView cityTxt;

        public TicketDetailHolder(@NonNull View itemView) {
            super(itemView);

            nameStationTxt = itemView.findViewById(R.id.ticket_detail_name_item);
            cityTxt = itemView.findViewById(R.id.ticket_detail_city_item);
        }

        public void bind(StationDto stationDto){
            nameStationTxt.setText(stationDto.getName());
            cityTxt.setText(stationDto.getCity());
        }
    }
}
