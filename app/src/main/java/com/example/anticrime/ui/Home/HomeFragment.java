package com.example.anticrime.ui.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.anticrime.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


//    List<User> userList;
//    Context context;
//    RecyclerView recyclerView;
    private FragmentHomeBinding binding ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//        String number = "0123456789";
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:" + number));
//        startActivity(intent);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);

//        recyclerView=view.findViewById(R.id.recycle);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        Call<FetchUserResponse> call= RetrofitClient
//                .getInstance()
//                .getApi()
//                .fetchAllUsers();
//
////        call.enqueue(new Callback<List<FetchUserResponse>>() {
////            @Override
////            public void onResponse(Call<List<FetchUserResponse>> call, Response<List<FetchUserResponse>> response) {
////
////                List<FetchUserResponse> data=response.body();
////                UserAdapter adapter = new UserAdapter(data);
////                recyclerView.setAdapter(adapter);
////            }
////
////            @Override
////            public void onFailure(Call<List<FetchUserResponse>> call, Throwable t) {
////
////                Toast.makeText(getActivity(),t.toString(), Toast.LENGTH_SHORT).show();
////
////            }
////        });
//        call.enqueue(new Callback<FetchUserResponse>() {
//            @Override
//            public void onResponse(Call<FetchUserResponse> call, Response<FetchUserResponse> response) {
//
//                if(response.isSuccessful()){
//
//                    userList=response.body().getUserList();
//                    recyclerView.setAdapter(new UserAdapter(getActivity(), userList));
//                }
//                else {
//                    Toast.makeText(getActivity(), response.body().getError(), Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<FetchUserResponse> call, Throwable t) {
//
//                Toast.makeText(getActivity(), t.getMessage()    , Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}