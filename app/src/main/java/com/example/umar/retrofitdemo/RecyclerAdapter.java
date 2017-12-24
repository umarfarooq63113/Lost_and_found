package com.example.umar.retrofitdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by umar on 16/12/2017.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<Owner> owners;

    public RecyclerAdapter(ArrayList<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(owners.get(position).getId()+"");
        holder.email.setText(owners.get(position).getEmai());
        holder.password.setText(owners.get(position).getPassword());
        holder.reg_id.setText(owners.get(position).getReg_id());
        holder.owner_name.setText(owners.get(position).getOwner_name());
        holder.owner_department.setText(owners.get(position).getOwner_department());
        holder.owner_mobile.setText(owners.get(position).getOwner_mobile());
    }


    @Override
    public int getItemCount() {
        return owners.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, email, password, reg_id, owner_name, owner_department, owner_mobile;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.oid);
            email = itemView.findViewById(R.id.email);
            password = itemView.findViewById(R.id.password);
            reg_id = itemView.findViewById(R.id.reg_id);
            owner_name = itemView.findViewById(R.id.owner_name);
            owner_department = itemView.findViewById(R.id.owner_department);
            owner_mobile = itemView.findViewById(R.id.owner_mobile);
        }
    }
}
