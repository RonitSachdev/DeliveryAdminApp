package com.example.deliveryadminapp;

import static com.example.deliveryadminapp.userlist.displayToast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    static String id;
    Toast mess;
    Context context;
    ArrayList<User> list;
    OnBtnClickListener mOnBtnClickListener;


    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v,mOnBtnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.userName.setText(user.getName());
        holder.userPhone.setText(user.getPhoneno());
        holder.userOrgName.setText(user.getOrgname());
        holder.userOrgAdd.setText(user.getAddress());
        holder.userQuantity.setText(user.getQuantity());
        String InID = user.getUserID();
        id = InID;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView userName,userOrgName,userOrgAdd,userPhone,userQuantity;
        ImageView deliveredButton;
        Button deleteButton;
        OnBtnClickListener mOnBtnClickListener;



        public MyViewHolder(@NonNull View itemView,OnBtnClickListener mOnBtnClickListener) {
            super(itemView);
            this.mOnBtnClickListener = mOnBtnClickListener;
            userName = itemView.findViewById(R.id.NameText);
            userOrgName = itemView.findViewById(R.id.OrgNameText);
            userOrgAdd = itemView.findViewById(R.id.AddressText);
            userPhone = itemView.findViewById(R.id.PhoneText);
            userQuantity = itemView.findViewById(R.id.QuantityText);
            deleteButton = itemView.findViewById(R.id.deliveredButton);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        deleteUser(id);
                        displayToast(view);
                    }
            });

        }

        private void deleteUser(String id) {
            DatabaseReference dRuser = FirebaseDatabase.getInstance().getReference("users").child(id);
            dRuser.removeValue();
        }


        @Override
        public void onClick(View view) {

        }
    }
    public interface OnBtnClickListener{
        void onDeliverBtnClick(int position);
    }

}
