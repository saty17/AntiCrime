package com.example.anticrime.ui.NavSliphome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.anticrime.R;
import com.example.anticrime.SharedPrefManager;


public class NavSkiphome extends Fragment {

    TextView etName,etEmail;
    SharedPrefManager sharedPrefManager;

//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.nav_header_skiphome);
//
//        etname = (TextView) findViewById(R.id.etName);
//        etemail = (TextView) findViewById(R.id.etEmail);
//
//        sharedPrefManager=new SharedPrefManager(getApplicationContext());
//        etname.setText(sharedPrefManager.getUser().getUserName());
//        etemail.setText(sharedPrefManager.getUser().getEmail());
//
//        this.init();
//
//    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle saveInstanceState){
        View view= inflater.inflate(R.layout.nav_header_skiphome, container, false);
        etName=view.findViewById(R.id.etName);
        etEmail=view.findViewById(R.id.etEmail);

        sharedPrefManager = new SharedPrefManager(getActivity());

        etName.setText(SharedPrefManager.getUser().getUserName());
        etEmail.setText(SharedPrefManager.getUser().getEmail());

        return view;
    }
}

