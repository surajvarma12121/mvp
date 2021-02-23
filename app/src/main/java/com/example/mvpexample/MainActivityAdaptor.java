package com.example.mvpexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityAdaptor extends RecyclerView.Adapter<MainActivityAdaptor.ViewHolder> {

    String[] data;

    public MainActivityAdaptor(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MainActivityAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View product=layoutInflater.inflate(R.layout.itemview,parent,false);


        return new MainActivityAdaptor.ViewHolder(product);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdaptor.ViewHolder holder, int position) {
        holder.textView.setText(data[position].toString());

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
