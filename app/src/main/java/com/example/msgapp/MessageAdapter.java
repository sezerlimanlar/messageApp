package com.example.msgapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class MessageAdapter extends RecyclerView.Adapter<messageVH> {

    List<String> messages ;

    public MessageAdapter(List<String> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public messageVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messageitem,parent,false);
        return new messageVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull messageVH holder, int position) {
        holder.message.setText(messages.get(position));

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
class messageVH extends RecyclerView.ViewHolder{
    TextView message;
    MessageAdapter adapter;
    public messageVH(@NonNull View itemView) {
        super(itemView);
        message = itemView.findViewById(R.id.txt_message);
        itemView.findViewById(R.id.btn_messagesil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            adapter.messages.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
            }
        });
    }
    public messageVH linkAdapter(MessageAdapter adapter) {
        this.adapter = adapter;
        return this;
    }
}
