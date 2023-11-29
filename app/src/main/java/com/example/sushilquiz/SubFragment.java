package com.example.sushilquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.sushilquiz.AdapterClass.SubAdapter;
import com.example.sushilquiz.ModelClass.SubModel;
import com.example.sushilquiz.databinding.FragmentSubBinding;

import java.util.ArrayList;
import java.util.Objects;

public class SubFragment extends Fragment {



    FragmentSubBinding binding;
    ArrayList<SubModel> list=new ArrayList<>();
    SubAdapter adapter;
    String title;

    public SubFragment() {


    }
    public SubFragment(String title) {
       this.title=title;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSubBinding.inflate(getLayoutInflater());

        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();


switch (title){
    case "Category 1":
    list.add(new SubModel("Sub1 category 1", "Des 1","Category 1"));
    list.add(new SubModel("Sub2 category 1", "Des 1","Category 1"));
    list.add(new SubModel("Sub3 category 1", "Des 1","Category 1"));
    list.add(new SubModel("Sub4 category 1", "Des 1","Category 1"));
    list.add(new SubModel("Sub5 category 1", "Des 1","Category 1"));

    break;
    case "Category 2":
            list.add(new SubModel("Sub1 category 2", "Des 2","Category 2"));
            list.add(new SubModel("Sub2 category 2", "Des 2","Category 2"));
            list.add(new SubModel("Sub3 category 2", "Des 2","Category 2"));
            list.add(new SubModel("Su4 category 2", "Des 2","Category 2"));
            list.add(new SubModel("Sub5 category 2", "Des 2","Category 2"));

                break;

    case "Category 3":
    list.add(new SubModel("Sub1 category 3", "Des 3","Category 3"));
    list.add(new SubModel("Sub2 category 3", "Des 3","Category 3"));
    list.add(new SubModel("Sub3 category 3", "Des 3","Category 3"));
    list.add(new SubModel("Sub4 category 3", "Des 3","Category 3"));
    list.add(new SubModel("Sub5 category 3", "Des 3","Category 3"));

    break;

    case "Category 4":
    list.add(new SubModel("Sub1 category 4", "Des 4","category 4"));
    list.add(new SubModel("Sub2 category 4", "Des 4","Category 4"));
    list.add(new SubModel("Sub3 category 4", "Des 4","Category 4"));
    list.add(new SubModel("Sub4 category 4", "Des 4","category 4"));
    list.add(new SubModel("Sub5 category 4", "Des 4","Category 4"));
    break;

    case "Category 5":
    list.add(new SubModel("Sub1 category 5", "Des 5","Category 5"));
    list.add(new SubModel("Sub2 category 5", "Des 5","Category 5"));
    list.add(new SubModel("Sub3 category 5", "Des 5","Category 5"));
    list.add(new SubModel("Sub4 category 5", "Des 5","Category 5"));
    list.add(new SubModel("Sub5 category 5", "Des 5","Category 5"));

}
        adapter=new SubAdapter(getContext(),list);
        binding.rcv.setAdapter(adapter);



}
}
