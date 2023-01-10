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

import com.example.msgapp.MessageAdapter;
import com.example.msgapp.R;

import java.util.LinkedList;
import java.util.List;


public class CreateMessageFragment extends Fragment {
    EditText message;
    RecyclerView recyclerView;
    MessageAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_createmessage, container, false);
        message = view.findViewById(R.id.et_message);
        recyclerView = view.findViewById(R.id.recylerview_message);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> messages = new LinkedList<>();
        adapter = new MessageAdapter(messages);
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.btn_create_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messagecontent = message.getText().toString();
                messages.add(messagecontent);
                adapter.notifyItemInserted(messages.size()-1);
            }
        });

        return view;
    }
}