package com.example.compulsory_dicecup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        setGui();
        configureBackButton();

        setUp();

    }


    private void setUp() {
        ListView diceListView = this.findViewById(R.id.diceListView);


    }

    private void configureBackButton(){
        Button backButton = findViewById(R.id.btnPrevView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setGui(){
        ArrayList<ArrayList<Integer>> rollHistory = (ArrayList<ArrayList<Integer>>) getIntent().getSerializableExtra ("History");

    }

}