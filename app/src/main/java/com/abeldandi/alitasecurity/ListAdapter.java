package com.abeldandi.alitasecurity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abeldandi.alitasecurity.callback.FetchRecyclerViewItems;
import com.abeldandi.alitasecurity.model.DataObject;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<DataObject> mData;
    private LayoutInflater mInflater;
    private Context context;
    private final FetchRecyclerViewItems listener;

    private String convertRoomIDToRoomName(String roomID) {
        switch (roomID) {
            case "ce2baf":
                return "Lab Optik";
            case "8d274b":
                return "Bengkel";
            case "ce74ef":
                return "Pintu Depan";
            case "8bf47f":
                return "Pintu Belakang";
            default:
                return "Unknown Room";
        }
    }


    public ListAdapter(List<DataObject> itemList, Context context, FetchRecyclerViewItems listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<DataObject> items) {
        Collections.reverse(items);
        mData = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView securityname, idnumber, time;
        LinearLayout linearLayoutCV;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            linearLayoutCV = itemView.findViewById(R.id.linearLayoutCV);
            securityname = itemView.findViewById(R.id.securityname);
            idnumber = itemView.findViewById(R.id.idnumber);
            time = itemView.findViewById(R.id.time);
        }

        void bindData(final DataObject item) {

            Glide.with(context)
                    .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Eo_circle_light-green_checkmark.svg/2048px-Eo_circle_light-green_checkmark.svg.png")
                    .into(iconImage);
            String roomName = convertRoomIDToRoomName(item.getRoomID());
            securityname.setText(roomName.toUpperCase());
            idnumber.setText("Status: "+item.getStatus());
            time.setText(item.getTime());
            linearLayoutCV.setOnClickListener(view -> listener.onIntent(item));
        }
    }
}
