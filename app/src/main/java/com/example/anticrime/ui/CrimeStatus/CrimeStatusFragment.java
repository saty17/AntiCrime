package com.example.anticrime.ui.CrimeStatus;

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

import com.example.anticrime.CrimeStatusAdapter;
import com.example.anticrime.ModelResponse.CrimeFetch;
import com.example.anticrime.ModelResponse.FetchCrimeResponse;
import com.example.anticrime.R;
import com.example.anticrime.RetrofitClient;
import com.example.anticrime.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CrimeStatusFragment extends Fragment {

    RecyclerView recyclerView;
    List<CrimeFetch> crimeFetchList;
    SharedPrefManager sharedPrefManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crimestatus, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String txtUsername = sharedPrefManager.getUser().getUserName();

        recyclerView=view.findViewById(R.id.crimestatusrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<FetchCrimeResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .StatusCrime(txtUsername);

        call.enqueue(new Callback<FetchCrimeResponse>() {
            @Override
            public void onResponse(Call<FetchCrimeResponse> call, Response<FetchCrimeResponse> response) {

                if(response.isSuccessful())
                {
                    crimeFetchList=response.body().getCrimeFetchList();
                    recyclerView.setAdapter(new CrimeStatusAdapter(crimeFetchList, getActivity()));
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