package com.example.msgapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msgapp.GroupAdapter;
import com.example.msgapp.R;

import java.security.acl.Group;
import java.util.LinkedList;
import java.util.List;

public class CreateGroupFragment extends Fragment {

    EditText groupName;
    RecyclerView recyclerView;
    GroupAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_creategroup, container, false);
        groupName = view.findViewById(R.id.et_groupname);
        recyclerView = view.findViewById(R.id.recylerview_group);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> groups = new LinkedList<>();
        adapter = new GroupAdapter(groups);
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.btn_create_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String group = groupName.getText().toString();
                groups.add(group);
                adapter.notifyItemInserted(groups.size()-1);
            }
        });

        return view;
    }
}