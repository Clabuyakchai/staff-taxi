package com.clabuyakchai.user.ui.fragment.navigation.ticket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.ui.fragment.navigation.route.adapter.Holder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TicketAdapter extends RecyclerView.Adapter<Holder> {
    private List<RouteDto> routeList;
    private final TicketItemListener listener;

    public TicketAdapter(TicketItemListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_route_item, parent, false);
        final Holder routeHolder = new Holder(view);

        routeHolder.itemView.setOnClickListener(v -> {
            int position = routeHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onTicketItemClick(routeList.get(position));
            }
        });

        return routeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(routeList.get(position));
    }

    @Override
    public int getItemCount() {
        return routeList.size();
    }

    public void setRouteList(List<RouteDto> routeList) {
        this.routeList = routeList;
    }
}
