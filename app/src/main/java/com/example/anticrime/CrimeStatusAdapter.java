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
import com.example.anticrime.ModelResponse.CrimeFetch;

import java.util.List;

public class CrimeStatusAdapter extends RecyclerView.Adapter<CrimeStatusAdapter.CrimeStatusViewHolder>{

    List<CrimeFetch> crimeFetchList;
    Context context;

    public CrimeStatusAdapter(List<CrimeFetch> crimeFetchList, Context context) {
        this.crimeFetchList = crimeFetchList;
        this.context = context;
    }

    @NonNull
    @Override
    public CrimeStatusAdapter.CrimeStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crimestatus_item, parent, false);
        return new CrimeStatusViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CrimeStatusAdapter.CrimeStatusViewHolder holder, int position) {

        holder.id.setText("Crime no. : "+crimeFetchList.get(position).getId());
        holder.city.setText("City : "+crimeFetchList.get(position).getCrimeCity());
        holder.pincode.setText("Pincode : "+crimeFetchList.get(position).getCrimePincode());
        holder.details.setText("Details : "+crimeFetchList.get(position).getCrimeDetails());
        holder.status.setText("Status : "+crimeFetchList.get(position).getStatus());
        Glide.with(holder.city.getContext()).load("http://10.0.2.2:8080/AntiC/"+crimeFetchList.get(position).getImageLocation()).into(holder.cimage);

    }

    @Override
    public int getItemCount() {
        return crimeFetchList.size();
    }

    public class CrimeStatusViewHolder extends RecyclerView.ViewHolder {

        TextView city, pincode, details, status, id;
        ImageView cimage;

        public CrimeStatusViewHolder(@NonNull View itemView) {
            super(itemView);

            id= itemView.findViewById(R.id.stcrimeid);
            city= itemView.findViewById(R.id.stcrimecity);
            pincode= itemView.findViewById(R.id.stcrimepincode);
            details= itemView.findViewById(R.id.stcrimedetails);
            status= itemView.findViewById(R.id.stcrime);
            cimage = itemView.findViewById(R.id.stcrimeimage);

        }
    }
}
