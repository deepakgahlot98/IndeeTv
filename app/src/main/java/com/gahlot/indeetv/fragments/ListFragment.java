package com.gahlot.indeetv.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gahlot.indeetv.R;
import com.gahlot.indeetv.adapter.CustomAdapter;
import com.gahlot.indeetv.model.TestDataDTO;
import com.gahlot.indeetv.viewmodel.CustomViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private CustomViewModel homeViewModel;
    private CustomAdapter customAdapter;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        homeViewModel = ViewModelProviders.of(getActivity()).get(CustomViewModel.class);
        init(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel.getCategoriesData().observe(getActivity(), new Observer<List<TestDataDTO>>() {
            @Override
            public void onChanged(List<TestDataDTO> testDataDTOS) {
                if (testDataDTOS != null) {
                    customAdapter.setData(testDataDTOS);
                }
            }
        });
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.list_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        customAdapter = new CustomAdapter(homeViewModel.getCategoriesData().getValue() == null ? new ArrayList<TestDataDTO>() : homeViewModel.getCategoriesData().getValue(),getActivity());
        recyclerView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }

}
