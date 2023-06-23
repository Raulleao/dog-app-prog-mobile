package com.example.dogprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;

import com.example.dogprojeto.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {


    ActivityDetailedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String rank = intent.getStringExtra("rank");
            int information = intent.getIntExtra("information", R.string.poodleInformation);
            int desc = intent.getIntExtra("desc", R.string.poodleResumo);
            int image = intent.getIntExtra("image", R.drawable.sample_0);
            binding.detailName.setText(name);
            binding.detailTime.setText(rank);
            binding.detailDesc.setText(desc);
            binding.detailInformation.setText(information);
            binding.detailImage.setImageResource(image);
        }
    }
}