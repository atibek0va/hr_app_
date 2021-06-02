package com.example.hrapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrapp.R;
import com.example.hrapp.model.Complaint;
import com.example.hrapp.model.Question;

import java.util.ArrayList;
import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.MyTViewHolder>{
    private Context context;
    private ArrayList<Complaint> complaintList;

    public ComplaintAdapter(Context context, ArrayList<Complaint> complaintList) {
        this.context = context;
        this.complaintList = complaintList;
    }

    public ComplaintAdapter(List<Complaint> complaintList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public TextView complaint, complaintnDate;

        public MyTViewHolder(View view){
            super(view);
            complaint = view.findViewById(R.id.complaint);
            complaintnDate = view.findViewById(R.id.complaintDate);
        }
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_complaint, parent, false);
        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Complaint item = complaintList.get(position);

        holder.complaint.setText(item.getComplaint());
        holder.complaintnDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }
}
