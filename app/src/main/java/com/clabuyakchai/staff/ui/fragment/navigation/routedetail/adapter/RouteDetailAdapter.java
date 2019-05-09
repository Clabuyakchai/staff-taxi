package com.clabuyakchai.staff.ui.fragment.navigation.routedetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.data.remote.request.LocalDto;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RouteDetailAdapter extends RecyclerView.Adapter<RouteDetailAdapter.RouteDetailHolder> {
    private List<LocalDto> list;
    private final CallUserListener listener;

    public RouteDetailAdapter(List<LocalDto> list, CallUserListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RouteDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_route_detail_item, parent, false);
        final RouteDetailHolder holder = new RouteDetailHolder(view);

        holder.itemView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION){
                holder.itemView.setBackgroundColor(view.getResources().getColor(R.color.green));
            }
        });

        holder.getPhoneImg().setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.callUser(list.get(position).getPhone());
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RouteDetailHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<LocalDto> list) {
        this.list = list;
    }

    class RouteDetailHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;
        private ImageView phoneImg;

        public RouteDetailHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.route_detail_name);
            phoneImg = itemView.findViewById(R.id.route_detail_phone);
        }

        public void bind(LocalDto localDto){
            nameTxt.setText(localDto.getName());
        }

        public ImageView getPhoneImg() {
            return phoneImg;
        }
    }

}
