package com.example.anticrime;

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

import com.example.anticrime.ModelResponse.FetchMissingResponse;
import com.example.anticrime.ModelResponse.MissingFetch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Missing extends Fragment {

    RecyclerView recyclerView;
    List<MissingFetch> missingFetchList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_missing, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.missingrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<FetchMissingResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .fetchAllMissing();

        call.enqueue(new Callback<FetchMissingResponse>() {
            @Override
            public void onResponse(Call<FetchMissingResponse> call, Response<FetchMissingResponse> response) {

                if(response.isSuccessful())
                {
                    missingFetchList=response.body().getMissingList();
                    recyclerView.setAdapter(new MissingAdapter(getActivity(),missingFetchList));
                }
                else {
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchMissingResponse> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}