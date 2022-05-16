package com.example.anticrime.ui.MissingStatus;

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

import com.example.anticrime.MissingStatusAdapter;
import com.example.anticrime.ModelResponse.FetchMissingResponse;
import com.example.anticrime.ModelResponse.MissingFetch;
import com.example.anticrime.R;
import com.example.anticrime.RetrofitClient;
import com.example.anticrime.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class missingpersonstatus extends Fragment {

    RecyclerView recyclerView;
    List<MissingFetch> missingFetchList;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_missingpersonstatus, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String txtUsername = sharedPrefManager.getUser().getUserName();

        recyclerView=view.findViewById(R.id.missingstatusrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<FetchMissingResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .StatusMissing(txtUsername);

        call.enqueue(new Callback<FetchMissingResponse>() {
            @Override
            public void onResponse(Call<FetchMissingResponse> call, Response<FetchMissingResponse> response) {

                if(response.isSuccessful())
                {
                    missingFetchList=response.body().getMissingList();
                    recyclerView.setAdapter(new MissingStatusAdapter(missingFetchList, getActivity()));
                    //error
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