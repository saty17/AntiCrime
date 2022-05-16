package com.example.anticrime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anticrime.ModelResponse.ComplaintFetch;

import java.util.List;

public class ComplaintStatusAdapter extends RecyclerView.Adapter<ComplaintStatusAdapter.ComplaintStatusViewHolder>{

    List<ComplaintFetch> complaintFetchList;
    Context context;

    public ComplaintStatusAdapter(List<ComplaintFetch> complaintFetchList, Context context) {
        this.complaintFetchList = complaintFetchList;
        this.context = context;
    }

    @NonNull
    @Override
    public ComplaintStatusAdapter.ComplaintStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.complaintstatus_item, parent, false);
        return new ComplaintStatusViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ComplaintStatusAdapter.ComplaintStatusViewHolder holder, int position) {

        holder.id.setText("Complaint no. : "+complaintFetchList.get(position).getId());
        holder.add.setText("Address : "+complaintFetchList.get(position).getCompAddress());
        holder.city.setText("City : "+complaintFetchList.get(position).getCompCity());
        holder.pincode.setText("Pincode : "+complaintFetchList.get(position).getCompPincode());
        holder.sub.setText("Subject : "+complaintFetchList.get(position).getCompSubject());
        holder.comp.setText("Complaint : "+complaintFetchList.get(position).getComplaint());
        holder.status.setText("Status : "+complaintFetchList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return complaintFetchList.size();
    }

    public class ComplaintStatusViewHolder extends RecyclerView.ViewHolder {

        TextView add, city, pincode, sub, comp, status, id;

        public ComplaintStatusViewHolder(@NonNull View itemView) {
            super(itemView);

            id= itemView.findViewById(R.id.stcompid);
            add= itemView.findViewById(R.id.stcompaddress);
            city= itemView.findViewById(R.id.stcompcity);
            pincode= itemView.findViewById(R.id.stcomppincode);
            sub= itemView.findViewById(R.id.stcompsubject);
            comp= itemView.findViewById(R.id.comp);
            status= itemView.findViewById(R.id.stcomp);

        }
    }
}
