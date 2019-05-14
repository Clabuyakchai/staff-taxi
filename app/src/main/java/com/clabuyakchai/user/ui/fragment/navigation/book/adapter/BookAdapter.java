package com.clabuyakchai.user.ui.fragment.navigation.book.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.ui.fragment.navigation.route.adapter.Holder;
import com.clabuyakchai.user.ui.fragment.navigation.route.adapter.RouteIdListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<Holder> {
    private List<BookingDto> list;
    private final RouteIdListener listener;

    public BookAdapter(List<BookingDto> routeList, RouteIdListener listener) {
        this.list = routeList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_route_item, parent, false);
        final Holder routeHolder = new Holder(view);

        routeHolder.itemView.setOnClickListener(v -> {
            int position = routeHolder.getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                listener.fragmentDetails(list.get(position).getBookingID());
            }
        });

        return routeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<BookingDto> list) {
        this.list = list;
    }
}
