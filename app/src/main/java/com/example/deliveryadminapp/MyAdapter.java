package com.example.deliveryadminapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;


    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.userName.setText(user.getName());
        holder.userMail.setText(user.getEmail());
        holder.userPhone.setText(user.getPhoneno());
        holder.userOrgName.setText(user.getOrgname());
        holder.userOrgAdd.setText(user.getAddress());
        holder.userQuantity.setText(user.getQuantity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView userName,userMail,userOrgName,userOrgAdd,userPhone,userQuantity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            userName = itemView.findViewById(R.id.NameText);
            userMail = itemView.findViewById(R.id.MailText);
            userOrgName = itemView.findViewById(R.id.OrgNameText);
            userOrgAdd = itemView.findViewById(R.id.AddressText);
            userPhone = itemView.findViewById(R.id.PhoneText);
            userQuantity = itemView.findViewById(R.id.QuantityText);

        }
    }
}
