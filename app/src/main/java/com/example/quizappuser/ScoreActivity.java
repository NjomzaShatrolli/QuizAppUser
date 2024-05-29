package com.example.quizappuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizappuser.databinding.ActivityScoreBinding;
import com.google.firebase.StartupTime;

public class ScoreActivity extends AppCompatActivity {

    ActivityScoreBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        int correct = getIntent().getIntExtra("correctAnswer", 0);
        int totalQuestions = getIntent().getIntExtra("totalQuestion", 0);

        int wrong = totalQuestions - correct;

        binding.totalRight.setText(String.valueOf(correct));
        binding.totalWrong.setText(String.valueOf(wrong));

        binding.totalQuestions.setText(String.valueOf(totalQuestions));

        binding.progressBar.setProgress(totalQuestions);
        binding.progressBar.setProgress(correct);

        binding.progressBar.setProgressMax(totalQuestions);

        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}