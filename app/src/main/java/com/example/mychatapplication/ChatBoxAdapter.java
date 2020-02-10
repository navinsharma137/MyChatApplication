package com.example.mychatapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatBoxAdapter extends RecyclerView.Adapter<ChatBoxAdapter.MyViewHolder> {
    private List<Message> MessageList;

    public ChatBoxAdapter(List<Message> MessageList){
        this.MessageList = MessageList;
    }

    @NonNull
    @Override
    public ChatBoxAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatBoxAdapter.MyViewHolder holder, int position) {
        Message m = MessageList.get(position);
        holder.name.setText(m.getName());
        holder.message.setText(m.getMessage());

    }

    @Override
    public int getItemCount() {
        return MessageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView message;

        MyViewHolder(View view){
            super(view);

            name = view.findViewById(R.id.nickname);
            message = view.findViewById(R.id.message);

        }
    }
}
