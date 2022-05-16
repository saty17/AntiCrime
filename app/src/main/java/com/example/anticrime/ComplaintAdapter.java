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

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder>{

    List<ComplaintFetch> complaintFetchList;
    Context context;

    public ComplaintAdapter(Context context, List<ComplaintFetch> complaintFetchList) {
        this.context = context;
        this.complaintFetchList= complaintFetchList;
    }

    @NonNull
    @Override
    public ComplaintAdapter.ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.complaint_item, parent, false);
        return new ComplaintAdapter.ComplaintViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ComplaintAdapter.ComplaintViewHolder holder, int position) {
        holder.add.setText("Address : "+complaintFetchList.get(position).getCompAddress());
        holder.city.setText("City : "+complaintFetchList.get(position).getCompCity());
        holder.pincode.setText("Pincode : "+complaintFetchList.get(position).getCompPincode());
        holder.sub.setText("Subject : "+complaintFetchList.get(position).getCompSubject());
        holder.comp.setText("Complaint : "+complaintFetchList.get(position).getComplaint());
    }

    @Override
    public int getItemCount() {
        return complaintFetchList.size();
    }

    public class ComplaintViewHolder extends RecyclerView.ViewHolder {

        TextView add, city, pincode, sub, comp;

        public ComplaintViewHolder(@NonNull View itemView) {
            super(itemView);

            add= itemView.findViewById(R.id.compaddress);
            city= itemView.findViewById(R.id.compcity);
            pincode= itemView.findViewById(R.id.comppincode);
            sub= itemView.findViewById(R.id.compsubject);
            comp= itemView.findViewById(R.id.comp);

        }
    }
}
