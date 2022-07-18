package com.example.myspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TestItem dataList;

    String[] items = {"식당", "제품", "레시피"};

    Fragment bookmark1;
    Fragment bookmark2;
    Fragment bookmark3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookmark1 = new bookmark1Fragment();
        bookmark2 = new bookmark2Fragment();
        bookmark3 = new bookmark3Fragment();

        Spinner spinner = findViewById(R.id.Spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (items[i]){
                    case "식당":
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,bookmark1).commitAllowingStateLoss();
                        return;
                    case "제품":
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,bookmark2).commitAllowingStateLoss();
                        return;
                    case "레시피":
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,bookmark3).commitAllowingStateLoss();
                        return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,bookmark1).commitAllowingStateLoss();
                return;
            }
        });

    }
}