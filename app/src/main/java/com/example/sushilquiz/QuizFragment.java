package com.example.sushilquiz;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sushilquiz.ModelClass.HomeModel;
import com.example.sushilquiz.ModelClass.QuizModel;
import com.example.sushilquiz.ModelClass.SubModel;
import com.example.sushilquiz.databinding.FragmentQuizBinding;

import java.util.ArrayList;
import java.util.Objects;


public class QuizFragment extends Fragment {

    FragmentQuizBinding binding;
    ArrayList<QuizModel> list = new ArrayList<>();
    private int position = 0;
    int right = 0;
    private static String answer = null;

    int allQuestion;
    String listSize;
    String positionNo;
    QuizModel quizModel;
    String category,title;


    public QuizFragment() {


    }

    public QuizFragment(String category, String title) {
        this.category = category;
        this.title = title;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuizBinding.inflate(getLayoutInflater());

        LoadQuestion();
        EnableOption();
        ClearOption();

        binding.Nextbtn.setOnClickListener(v -> {
            position++;
            LoadQuestion();
            EnableOption();
            ClearOption();
            checkNext();


        });
        return binding.getRoot();
    }

    private void checkNext() {
        if (position == allQuestion) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new ResultFragment(right, allQuestion, category, title)).commit();
            list.clear();
            position = 0;
        }

    }

    @SuppressLint("NewApi")
    private void ClearOption() {
        binding.Option1.setBackgroundResource(R.drawable.sub_itembg);
        binding.Option1.setTextColor(getContext().getColor(R.color.black));
        binding.Option2.setBackgroundResource(R.drawable.sub_itembg);
        binding.Option2.setTextColor(getContext().getColor(R.color.black));
        binding.Option3.setBackgroundResource(R.drawable.sub_itembg);
        binding.Option3.setTextColor(getContext().getColor(R.color.black));
        binding.Option4.setBackgroundResource(R.drawable.sub_itembg);
        binding.Option4.setTextColor(getContext().getColor(R.color.black));
        binding.Nextbtn.setBackgroundResource(R.drawable.disable_btn);
    }

    private void EnableOption() {

        binding.Option1.setEnabled(true);
        binding.Option2.setEnabled(true);
        binding.Option3.setEnabled(true);
        binding.Option4.setEnabled(true);
        binding.Nextbtn.setEnabled(false);


    }

    private void LoadQuestion() {

        switch (title) {
            case "Sub1 category 1":
                list.add(new QuizModel("What does CPU stand for?", "Central Processing Unit", " Computer Processing Unit", " Core Processing Unit", "Control Processing Unit", "Central Processing Unit"));
                list.add(new QuizModel("Which language is used for web development?", "Java", " Python", "HTML", "Swift", "HTML"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", " Hyperlink Textual Markup Language", "High Transfer Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What does RAM stand for?", "Random Access Memory", " Readily Accessible Memory", " Randomly Allocated Memory", " Read Accessible Module", "Random Access Memory"));
                list.add(new QuizModel("Which one is an example of an operating system?", " Microsoft Office", "Linux", " Photoshop", "Chrome", "Linux"));
                 setUp();
                break;
            case "Sub2 category 1":
                list.add(new QuizModel("Question 1", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 2", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 3", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 4", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 5", "op1", "op2", "op3", "op4", "op4"));
                setUp();
                break;
            case "Sub3 category 1":
                list.add(new QuizModel("Question 1", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 2", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 3", "op1", "op2", "op3", "op4", "op3"));
                list.add(new QuizModel("Question 4", "op1", "op2", "op3", "op4", "op2"));
                list.add(new QuizModel("Question 5", "op1", "op2", "op3", "op4", "op2"));
                setUp();
                break;
            case "Sub4 category 1":
                list.add(new QuizModel("Question 1", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 2", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 3", "op1", "op2", "op3", "op4", "op3"));
                list.add(new QuizModel("Question 4", "op1", "op2", "op3", "op4", "op2"));
                list.add(new QuizModel("Question 5", "op1", "op2", "op3", "op4", "op2"));
                setUp();
                break;
            case "Sub5 category 1":
                list.add(new QuizModel("Question 1", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 2", "op1", "op2", "op3", "op4", "op4"));
                list.add(new QuizModel("Question 3", "op1", "op2", "op3", "op4", "op3"));
                list.add(new QuizModel("Question 4", "op1", "op2", "op3", "op4", "op2"));
                list.add(new QuizModel("Question 5", "op1", "op2", "op3", "op4", "op2"));
                setUp();
                break;

                // ... (existing code)

                    /*default:
                        // Log an error or handle the situation where 'title' doesn't match any cases
                        Log.e("LoadQuestion", "Unknown title: " + title);
                        break;*/
           //default:
             //   throw new IllegalStateException("Unexpected value: " + title);
        }
            }

    private void setUp() {
        allQuestion = 5;
        listSize = String.valueOf(allQuestion);
       // binding.totalQ.setText("/" + listSize);
       // binding.qNo.setText(positionNo);


        if (position != allQuestion) {
            positionNo = String.valueOf(position + 1);
            binding.qNo.setText(positionNo);

        } else {
            positionNo = String.valueOf(position);
            binding.qNo.setText(positionNo);

        }
        quizModel = list.get(position);
        answer = quizModel.getCorrectAns();
        binding.Quistioncontainer.setText(quizModel.getQuestion());
        binding.Option1.setText(quizModel.getOp1());
        binding.Option2.setText(quizModel.getOp2());
        binding.Option3.setText(quizModel.getOp3());
        binding.Option4.setText(quizModel.getOp4());


        optionChekup();
    }


    @SuppressLint("NewApi")
    private void optionChekup(){
        binding.Option1.setOnClickListener(v -> {
           if(Objects.equals(quizModel.getOp1(),quizModel.getCorrectAns())){
             right++;
             binding.Option1.setBackgroundResource(R.drawable.right_bg);

             binding.Option1.setTextColor(getContext().getColor(R.color.white));
           }else{
               ShowRightAns();
               binding.Option1.setBackgroundResource(R.drawable.wrong_bg);
               binding.Option1.setTextColor(getContext().getColor(R.color.white));


           }


           DisableOption();
            binding.Nextbtn.setBackgroundResource(R.drawable.itembg);

        });

  binding.Option2.setOnClickListener(v -> {
        if(Objects.equals(quizModel.getOp2(),quizModel.getCorrectAns())){
            right++;
            binding.Option2.setBackgroundResource(R.drawable.right_bg);

            binding.Option2.setTextColor(getContext().getColor(R.color.white));
        }else{
            ShowRightAns();
            binding.Option2.setBackgroundResource(R.drawable.wrong_bg);
            binding.Option2.setTextColor(getContext().getColor(R.color.white));


        }
      DisableOption();
      binding.Nextbtn.setBackgroundResource(R.drawable.itembg);


  });
        binding.Option3.setOnClickListener(v -> {
            if(Objects.equals(quizModel.getOp3(),quizModel.getCorrectAns())){
                right++;
                binding.Option3.setBackgroundResource(R.drawable.right_bg);
                binding.Option3.setTextColor(getContext().getColor(R.color.white));

            }else{
                ShowRightAns();
                binding.Option3.setBackgroundResource(R.drawable.wrong_bg);
                binding.Option3.setTextColor(getContext().getColor(R.color.white));



            }

            DisableOption();
            binding.Nextbtn.setBackgroundResource(R.drawable.itembg);


        });
        binding.Option4.setOnClickListener(v -> {
            if(Objects.equals(quizModel.getOp4(),quizModel.getCorrectAns())){
                right++;
                binding.Option4.setBackgroundResource(R.drawable.right_bg);
                binding.Option4.setTextColor(getContext().getColor(R.color.white));
            }else{
                ShowRightAns();
                binding.Option4.setBackgroundResource(R.drawable.wrong_bg);
                binding.Option4.setTextColor(getContext().getColor(R.color.white));



            }
            DisableOption();
            binding.Nextbtn.setBackgroundResource(R.drawable.itembg);


        });
    }

    private void DisableOption() {

        binding.Option1.setEnabled(false);
        binding.Option2.setEnabled(false);
        binding.Option3.setEnabled(false);
        binding.Option4.setEnabled(false);
        binding.Nextbtn.setEnabled(true);
    }


    @SuppressLint("NewApi")
    private void ShowRightAns() {
        if(Objects.equals(quizModel.getOp1(),quizModel.getCorrectAns())){
            binding.Option1.setBackgroundResource(R.drawable.right_bg);
            binding.Option1.setTextColor(getContext().getColor(R.color.white));
        } else if (Objects.equals(quizModel.getOp2(),quizModel.getCorrectAns())){
            binding.Option2.setBackgroundResource(R.drawable.right_bg);
            binding.Option2.setTextColor(getContext().getColor(R.color.white));

        } else if (Objects.equals(quizModel.getOp3(),quizModel.getCorrectAns())){
            binding.Option3.setBackgroundResource(R.drawable.right_bg);
            binding.Option3.setTextColor(getContext().getColor(R.color.white));

        } else if (Objects.equals(quizModel.getOp4(),quizModel.getCorrectAns())){
            binding.Option4.setBackgroundResource(R.drawable.right_bg);
            binding.Option4.setTextColor(getContext().getColor(R.color.white));

        }


    }
}