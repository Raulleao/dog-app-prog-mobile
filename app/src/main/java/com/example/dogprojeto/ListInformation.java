package com.example.dogprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;

import com.example.dogprojeto.databinding.ActivityListInformationBinding;
import com.example.dogprojeto.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ListInformation extends AppCompatActivity {

    ActivityListInformationBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int[] imageList = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4};
        int[] informationtList = {R.string.carameloInformation, R.string.poodleInformation, R.string.pinscherInformation, R.string.labradorInformation, R.string.buldogueInformation};
        int[] descList = {R.string.carameloResumo, R.string.poodleResumo, R.string.pinscherResumo, R.string.labradorResumo, R.string.buldogueResumo};
        String[] nameList = {"Caramelo", "Poodle", "Pinscher", "Labrador", "Buldogue"};
        String[] rankList = {"1°", "2°", "3°", "4°", "5°"};
        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], rankList[i], informationtList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(ListInformation.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListInformation.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("rank", rankList[i]);
                intent.putExtra("information", informationtList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}