package com.example.anticrime;

//public  class UserAdapter extends RecyclerView.Adapter<UserAdapter.userviewholder> {
//
//    List<FetchUserResponse> data;
//
//    public UserAdapter(List<FetchUserResponse> data) {
//        this.data = data;
//    }
//
//    @NonNull
//    @Override
//    public userviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
//        return new userviewholder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull userviewholder holder, int position) {
//
//        holder.name.setText(data.get(position).getName());
//        holder.details.setText(data.get(position).getDetails());
//        Glide.with(holder.name.getContext()).load("http://10.0.2.2:8080/AntiC/"+data.get(position).getImageLocation()).into(holder.missingimage);
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    class userviewholder extends RecyclerView.ViewHolder
//    {
//        ImageView missingimage;
//        TextView name, details;
//
//        public userviewholder(@NonNull View itemView) {
//            super(itemView);
//            missingimage = itemView.findViewById(R.id.missingimage);
//            name = itemView.findViewById(R.id.etname);
//            details = itemView.findViewById(R.id.etdetails);
//        }
//    }
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anticrime.ModelResponse.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    List<User> userList;
    Context context;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        holder.userName.setText(userList.get(position).getUserName());
        holder.userEmail.setText(userList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userName, userEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.etusername);
            userEmail = itemView.findViewById(R.id.etuseremail);
        }
    }
}

