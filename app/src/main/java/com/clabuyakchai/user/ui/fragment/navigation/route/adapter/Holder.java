package com.clabuyakchai.user.ui.fragment.navigation.route.adapter;

import android.view.View;
import android.widget.TextView;

import com.clabuyakchai.user.R;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.data.remote.request.RouteDto;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {
    private TextView fromToTxt;
    private TextView datetimeTxt;
    private TextView priceTxt;

    public Holder(@NonNull View itemView) {
        super(itemView);
        fromToTxt = itemView.findViewById(R.id.route_from_to);
        datetimeTxt = itemView.findViewById(R.id.route_datetime);
        priceTxt = itemView.findViewById(R.id.route_price);
    }

    public void bind(RouteDto routeDto) {
        fromToTxt.setText(routeDto.getFrom() + " - " + routeDto.getTo());
        datetimeTxt.setText(routeDto.getDatetime());
        priceTxt.setText(routeDto.getPrice().toString());
    }

    public void bind(BookingDto bookingDto) {
        fromToTxt.setText(bookingDto.getFrom() + " - " + bookingDto.getTo());
        datetimeTxt.setText(bookingDto.getDatetime());
        priceTxt.setText(bookingDto.getPrice().toString());
    }
}