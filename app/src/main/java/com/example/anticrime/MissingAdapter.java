package com.example.anticrime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.anticrime.ModelResponse.MissingFetch;

import java.util.List;

public class MissingAdapter extends RecyclerView.Adapter<MissingAdapter.MissingViewHolder> {

    List<MissingFetch> missingFetchList;
    Context context;

    public MissingAdapter(Context context, List<MissingFetch> missingFetchList) {
        this.context = context;
        this.missingFetchList = missingFetchList;
    }

    @NonNull
    @Override
    public MissingAdapter.MissingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.missing_item, parent, false);
        return new MissingViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MissingAdapter.MissingViewHolder holder, int position) {

//        String Name ="Name : "+ missingFetchList.get(position).getName();
        holder.name.setText("Name : "+ missingFetchList.get(position).getName());
        holder.details.setText("Details : "+missingFetchList.get(position).getDetails());
        Glide.with(holder.name.getContext()).load("http://10.0.2.2:8080/AntiC/"+missingFetchList.get(position).getImageLocation()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return missingFetchList.size();
    }

    public static class MissingViewHolder extends RecyclerView.ViewHolder {

        TextView name, details;
        ImageView image;

        public MissingViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.misname);
            details= itemView.findViewById(R.id.misdetails);
            image = itemView.findViewById(R.id.misimage);

        }
    }
}
