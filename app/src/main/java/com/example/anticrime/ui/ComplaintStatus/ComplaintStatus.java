package com.example.anticrime.ui.ComplaintStatus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anticrime.ComplaintStatusAdapter;
import com.example.anticrime.ModelResponse.ComplaintFetch;
import com.example.anticrime.ModelResponse.FetchComplaintResponse;
import com.example.anticrime.R;
import com.example.anticrime.RetrofitClient;
import com.example.anticrime.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ComplaintStatus extends Fragment {

    RecyclerView recyclerView;
    List<ComplaintFetch> complaintFetchList;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complaint_status, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String txtUsername = sharedPrefManager.getUser().getUserName();

        recyclerView=view.findViewById(R.id.complaintstatusrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<FetchComplaintResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .StatusComplaint(txtUsername);

        call.enqueue(new Callback<FetchComplaintResponse>() {
            @Override
            public void onResponse(Call<FetchComplaintResponse> call, Response<FetchComplaintResponse> response) {
                if(response.isSuccessful())
                {
                    complaintFetchList=response.body().getComplaintList();
                    recyclerView.setAdapter(new ComplaintStatusAdapter(complaintFetchList, getActivity()));
                }
                else {
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchComplaintResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}