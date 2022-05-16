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

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeViewHolder>{

    List<CrimeFetch> crimeFetchList;
    Context context;

    public CrimeAdapter(Context context, List<CrimeFetch> crimeFetchList) {
        this.context = context;
        this.crimeFetchList = crimeFetchList;
    }

    @NonNull
    @Override
    public CrimeAdapter.CrimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.crime_item, parent, false);
        return new CrimeAdapter.CrimeViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CrimeAdapter.CrimeViewHolder holder, int position) {

        holder.city.setText("City : "+crimeFetchList.get(position).getCrimeCity());
        holder.pincode.setText("Pincode : "+crimeFetchList.get(position).getCrimePincode());
        holder.details.setText("Details : "+crimeFetchList.get(position).getCrimeDetails());
        Glide.with(holder.city.getContext()).load("http://10.0.2.2:8080/AntiC/"+crimeFetchList.get(position).getImageLocation()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return crimeFetchList.size();
    }

    public class CrimeViewHolder extends RecyclerView.ViewHolder {

        TextView city, pincode, details;
        ImageView image;

        public CrimeViewHolder(@NonNull View itemView) {
            super(itemView);

            city= itemView.findViewById(R.id.crimecity);
            pincode= itemView.findViewById(R.id.crimepincode);
            details= itemView.findViewById(R.id.crimedetails);
            image = itemView.findViewById(R.id.crimeimage);
        }
    }
}
