package com.example.hrapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrapp.R;
import com.example.hrapp.model.Job;
import com.example.hrapp.model.Respond;

import java.util.ArrayList;
import java.util.List;

public class RespondAdapter extends RecyclerView.Adapter<RespondAdapter.MyTViewHolder>{
    private Context context;
    private ArrayList<Respond> respondList;

    public RespondAdapter(Context context, ArrayList<Respond> respondList) {
        this.context = context;
        this.respondList = respondList;
    }

    public RespondAdapter(List<Respond> respondList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public TextView respond, respondDate;

        public MyTViewHolder(View view){
            super(view);
            respond = view.findViewById(R.id.respond);
            respondDate = view.findViewById(R.id.respondDate);
        }
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_respond, parent, false);
        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Respond item = respondList.get(position);

        holder.respond.setText(item.getRespond());
        holder.respondDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return respondList.size();
    }
}
