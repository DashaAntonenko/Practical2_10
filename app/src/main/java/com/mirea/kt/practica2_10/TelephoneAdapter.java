package com.mirea.kt.practica2_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TelephoneAdapter extends RecyclerView.Adapter<TelephoneAdapter.ViewHolder> {
    interface OnTelephoneClickListener{
        void onTelephoneClick(Telephone telephone, int position);
    }
    private ArrayList<Telephone> telephones;
    private OnTelephoneClickListener onTelephoneClickListener;
    public TelephoneAdapter(ArrayList<Telephone> telephones){
        this.telephones = telephones;
    }
    public TelephoneAdapter(ArrayList<Telephone> telephones, OnTelephoneClickListener onTelephoneClickListener){
        this.telephones = telephones;
        this.onTelephoneClickListener = onTelephoneClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView modelView;

        ViewHolder(View view){
            super(view);
            modelView = view.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.telephone_icon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TelephoneAdapter.ViewHolder holder, int position) {
        Telephone telephone = telephones.get(position);
        holder.modelView.setText(String.format("%s", telephone.getModel()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTelephoneClickListener.onTelephoneClick(telephone, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return telephones.size();
    }
}
