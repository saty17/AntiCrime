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

import com.example.anticrime.ModelResponse.CrimeFetch;
import com.example.anticrime.ModelResponse.FetchCrimeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Crime extends Fragment {

    RecyclerView recyclerView;
    List<CrimeFetch> crimeFetchList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_crime, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.crimerecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<FetchCrimeResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .fetchAllCrime();

        call.enqueue(new Callback<FetchCrimeResponse>() {
            @Override
            public void onResponse(Call<FetchCrimeResponse> call, Response<FetchCrimeResponse> response) {

                if(response.isSuccessful())
                {
                    crimeFetchList=response.body().getCrimeFetchList();
                    recyclerView.setAdapter(new CrimeAdapter(getActivity(),crimeFetchList));
                }
                else {
                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchCrimeResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}