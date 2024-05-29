package com.example.quizappuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quizappuser.Adapters.GridAdapters;
import com.example.quizappuser.databinding.ActivitySetsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class SetsActivity extends AppCompatActivity {


    ActivitySetsBinding binding;
    FirebaseDatabase database;

    GridAdapters adapter;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        database = FirebaseDatabase.getInstance();
        key = getIntent().getStringExtra("key");

        adapter = new GridAdapters(getIntent().getIntExtra("sets", 0),
                getIntent().getStringExtra("category"));

        binding.gridView.setAdapter(adapter);

    }
}