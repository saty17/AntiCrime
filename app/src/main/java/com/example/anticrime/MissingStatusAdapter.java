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

public class MissingStatusAdapter extends RecyclerView.Adapter<MissingStatusAdapter.MissingStatusViewHolder>{

    List<MissingFetch> missingFetchList;
    Context context;

    public MissingStatusAdapter(List<MissingFetch> missingFetchList, Context context) {
        this.missingFetchList = missingFetchList;
        this.context = context;
    }

    @NonNull
    @Override
    public MissingStatusAdapter.MissingStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.missingstatus_item, parent, false);
        return new MissingStatusViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MissingStatusAdapter.MissingStatusViewHolder holder, int position) {

        holder.id.setText("Missing no. : "+ missingFetchList.get(position).getId());
        holder.name.setText("Name : "+ missingFetchList.get(position).getName());
        holder.details.setText("Details : "+missingFetchList.get(position).getDetails());
        holder.status.setText("Status : "+missingFetchList.get(position).getStatus());
        Glide.with(holder.name.getContext()).load("http://10.0.2.2:8080/AntiC/"+missingFetchList.get(position).getImageLocation()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return missingFetchList.size();
    }

    public class MissingStatusViewHolder extends RecyclerView.ViewHolder {

        TextView name, details, status, id;
        ImageView image;

        public MissingStatusViewHolder(@NonNull View itemView) {
            super(itemView);

            id= itemView.findViewById(R.id.statusmissingid);
            name= itemView.findViewById(R.id.statusmissingname);
            details= itemView.findViewById(R.id.statusmissingdetails);
            status= itemView.findViewById(R.id.statusmissing);
            image = itemView.findViewById(R.id.statusmissingimage);

        }
    }
}
