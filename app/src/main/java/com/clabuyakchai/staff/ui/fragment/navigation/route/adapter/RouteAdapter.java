package com.clabuyakchai.staff.ui.fragment.navigation.route.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.RouteDto;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteHolder> {
    private List<RouteDto> routeList;
    private final RouteIdListener listener;

    public RouteAdapter(List<RouteDto> routeList, RouteIdListener listener) {
        this.routeList = routeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_route_item, parent, false);
        final RouteHolder routeHolder = new RouteHolder(view);

        routeHolder.itemView.setOnClickListener(v -> {
            int position = routeHolder.getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                listener.fragmentDetails(routeList.get(position).getRouteID());
            }
        });

        return routeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteHolder holder, int position) {
        holder.bind(routeList.get(position));
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }

    public void setRouteList(List<RouteDto> routeList) {
        this.routeList = routeList;
    }

    class RouteHolder extends RecyclerView.ViewHolder{
        private TextView fromToTxt;
        private TextView datetimeTxt;
        private TextView priceTxt;

        public RouteHolder(@NonNull View itemView) {
            super(itemView);
            fromToTxt = itemView.findViewById(R.id.route_from_to);
            datetimeTxt = itemView.findViewById(R.id.route_datetime);
            priceTxt = itemView.findViewById(R.id.route_price);
        }

        public void bind(RouteDto routeDto){
            fromToTxt.setText(routeDto.getFrom()+" - " + routeDto.getTo());
            datetimeTxt.setText(routeDto.getDatetime());
            priceTxt.setText(routeDto.getPrice().toString());
        }
    }
}
