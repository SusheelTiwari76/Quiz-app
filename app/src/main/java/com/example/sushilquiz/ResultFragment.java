package com.example.sushilquiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sushilquiz.databinding.FragmentResultBinding;

public class ResultFragment extends Fragment {

       FragmentResultBinding binding;
       int right,allQuestion;
       String category;
       String title;

    public ResultFragment() {
        // Required empty public constructor
    }
    public ResultFragment(int right,int allQuestion, String category, String title){
        this.right=right;
        this.allQuestion=allQuestion;
        this.category=category;
        this.title=title;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentResultBinding.inflate(getLayoutInflater());
       String rightScore=String.valueOf(right);
       String wrongScore=String.valueOf(allQuestion-right);
       String totalScore=String.valueOf(allQuestion);



       binding.correct.setText(rightScore+"Correct");
       binding.incorrect.setText(wrongScore+"Incorrect");
        binding.score.setText("You got the " +" "  +rightScore + " "+" out of " + totalScore);
       binding.exploreBtn.setOnClickListener(v -> {
           AppCompatActivity activity=(AppCompatActivity) v.getContext();
           activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new SubFragment(category)).commit();

       });

        binding.replay.setOnClickListener(v -> {
            AppCompatActivity activity=(AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new QuizFragment(category,title)).commit();

        });


        return binding.getRoot();
    }
}