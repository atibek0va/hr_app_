package com.example.hrapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrapp.R;
import com.example.hrapp.model.Contacts;
import com.example.hrapp.model.Job;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyTViewHolder>{
    private Context context;
    private ArrayList<Contacts> contactList;

    public ContactAdapter(Context context, ArrayList<Contacts> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    public ContactAdapter(List<Contacts> contactList) {
    }

    public class MyTViewHolder extends RecyclerView.ViewHolder{

        public TextView contactName, contactPost, contactNumber, contactEmail;
        public ImageView contactPhoto;

        public MyTViewHolder(View view){
            super(view);
            contactPhoto = view.findViewById(R.id.item_contact_img);
            contactName = view.findViewById(R.id.item_contact_name);
            contactPost = view.findViewById(R.id.item_contact_post);
            contactNumber = view.findViewById(R.id.item_contact_number);
            contactEmail = view.findViewById(R.id.item_contact_email);
        }
    }

    @NonNull
    @Override
    public MyTViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTViewHolder holder, int position) {
        Contacts item = contactList.get(position);

//        Glide.with ( context.getApplicationContext () )
//                .load ( item.getPhoto () )
//                .placeholder ( R.drawable.doctor )
//                .into ( holder.doctor_photo );
        holder.contactPhoto.setImageResource(item.getContactPhoto());
        holder.contactName.setText(item.getContactName());
        holder.contactPost.setText(item.getContactPost());
        holder.contactNumber.setText(item.getContactNumber());
        holder.contactEmail.setText(item.getContactEmail());

//        holder.btnZapis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String key = item.getKey();
//                Intent intent = new Intent(context, BronActivity.class);
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
