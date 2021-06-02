package com.example.hrapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hrapp.activities.BronActivity;
import com.example.hrapp.R;
import com.example.hrapp.model.Doctor;
import com.example.hrapp.model.Job;

import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyTViewHolder>{
    private Context context;
    private List<Doctor> doctorList;

    public DoctorAdapter(List<Doctor> doctorList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        public ImageView doctor_photo;
        public TextView name, exper, number;
        public Button btnZapis;

        public MyTViewHolder(View view){
            super(view);
            doctor_photo = view.findViewById(R.id.item_doctor_img);
            name = view.findViewById(R.id.item_doctor_name);
            exper = view.findViewById(R.id.item_doctor_experience);
            number = view.findViewById(R.id.item_doctor_number);
            btnZapis = view.findViewById(R.id.btnZapis);
        }
    }
    public DoctorAdapter(Context context, ArrayList<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Doctor item = doctorList.get(position);

//        Glide.with ( context.getApplicationContext () )
//                .load ( item.getPhoto () )
//                .placeholder ( R.drawable.doctor )
//                .into ( holder.doctor_photo );

        holder.doctor_photo.setImageResource(item.getPhoto());
        holder.name.setText(item.getName());
        holder.exper.setText(item.getExper());
        holder.number.setText(item.getNumber());

        holder.btnZapis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String key = item.getKey();
                Intent intent = new Intent(context, BronActivity.class);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }
}
