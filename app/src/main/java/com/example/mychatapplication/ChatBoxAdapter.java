package com.example.mychatapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatBoxAdapter extends RecyclerView.Adapter<ChatBoxAdapter.MyViewHolder> {
    private List<Message> MessageList;
    private String username;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout linearLayout;
        TextView message;
        MyViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.nickname);
            message = view.findViewById(R.id.message);
            linearLayout = view.findViewById(R.id.container_layout);
            username = name.toString();

        }
    }

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
        if(username == MainActivity.NICKNAME){
            ownMessage(holder);
        }
        else{
            expertMessage(holder);
        }
        holder.name.setText(m.getName());
        holder.message.setText(m.getMessage());

    }

    @Override
    public int getItemCount() {
        Log.d("zAdapter", "getItemCount: "+MessageList.size());
        return MessageList.size();
    }

    public void ownMessage(MyViewHolder holder){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.linearLayout.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        holder.itemView.setLayoutParams(params);


    }
    public void expertMessage(MyViewHolder holder){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.linearLayout.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        holder.itemView.setLayoutParams(params);

    }


}
