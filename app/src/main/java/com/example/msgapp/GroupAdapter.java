package com.example.msgapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<groupVH> {
    List<String> groups;

    public GroupAdapter(List<String> groups) {
        this.groups = groups;
    }

    @NonNull
    @Override
    public groupVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.groupitem,parent,false);
        return new groupVH(view).linkadapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull groupVH holder, int position) {
        holder.groupname.setText(groups.get(position));

    }

    @Override
    public int getItemCount() {
        return groups.size();
    }
}
class groupVH extends RecyclerView.ViewHolder{
    TextView groupname;
    GroupAdapter adapter;
    public groupVH(@NonNull View itemView) {
        super(itemView);
        groupname = itemView.findViewById(R.id.txt_item_group);
        itemView.findViewById(R.id.btn_item_groupsil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.groups.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());

            }
        });
    }
    public groupVH linkadapter(GroupAdapter adapter) {
        this.adapter = adapter;
        return this;
    }
}
