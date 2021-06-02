package com.example.hrapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hrapp.R;
import com.example.hrapp.activities.guest.JobDescriptionActivity;
import com.example.hrapp.adapter.ContactAdapter;
import com.example.hrapp.adapter.JobAdapter;
import com.example.hrapp.adapter.RecyclerItemClickListener;
import com.example.hrapp.model.Contacts;
import com.example.hrapp.model.Job;

import java.util.ArrayList;

public class ContactsFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<Contacts> contactsList;
    ContactAdapter contactAdapter;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contacts, container, false);
        recyclerView = view.findViewById(R.id.recycleContacts);
        contactsList = new ArrayList<>();
        contactAdapter = new ContactAdapter(getContext(), contactsList);
        contactsList.add(new Contacts(R.drawable.contact, "William Faolon", "Deputy Director of HR", "+ (7262) 43 56 21", "mrwilliamf@gmail.com"));
        contactsList.add(new Contacts(R.drawable.contact2, "Alex Harley", "HR Manager", "+ (7262) 45 20 02", "harleyalex@gmail.com"));
        contactsList.add(new Contacts(R.drawable.contact3, "Mary Malik", "HR Specialist", "+ (7262) 43 12 15", "marymalik@gmail.com"));
        linearLayoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(contactAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JobDescriptionActivity.class));
            }
        });

        return view;
    }
}