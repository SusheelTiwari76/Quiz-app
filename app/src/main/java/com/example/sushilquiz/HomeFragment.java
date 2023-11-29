package com.example.sushilquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sushilquiz.AdapterClass.HomeAdapter;
import com.example.sushilquiz.ModelClass.HomeModel;
import com.example.sushilquiz.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<HomeModel> list=new ArrayList<>();
    HomeAdapter adapter;

    public HomeFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("Category 1", "Des 1"));
        list.add(new HomeModel("Category 2", "Des 2"));
        list.add(new HomeModel("Category 3", "Des 3"));
        list.add(new HomeModel("Category 4", "Des 4"));
        list.add(new HomeModel("Category 5", "Des 5"));
  adapter=new HomeAdapter(getContext(),list);
  binding.rcv.setAdapter(adapter);


    }
}
