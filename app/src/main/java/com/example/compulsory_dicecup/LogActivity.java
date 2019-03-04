package com.example.compulsory_dicecup;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LogActivity extends AppCompatActivity {
    ListView diceListView;
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<ArrayList<Integer>> history;
    ArrayList<Integer> oneThrow = new ArrayList<>();
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        setUp();
        setGui();
        configureBackButton();
        clearListViewButton();

    }




    private void setUp() {
        diceListView = this.findViewById(R.id.diceListView);
    }
    //Go back button
    private void configureBackButton(){
        Button backButton = findViewById(R.id.btnPrevView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain(false);
                Toast.makeText(LogActivity.this, "Back button pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void returnToMain(boolean clearedList){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",clearedList);
        setResult(MainActivity.RESULT_OK,returnIntent);
        finish();
    }


    //Clear list view button.
    private void clearListViewButton() {
        Button clearButton = findViewById(R.id.btnClearView);
        Intent returnIntent = new Intent();
        clearButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                adapter.clear();

                Toast.makeText(LogActivity.this, "History cleared", Toast.LENGTH_SHORT).show();
                returnToMain(true);
            }
        });

    }

    //dates.add(roll.getTimeStamp().toString());

    private void setGui(){
        ArrayList<BEDiceRoll> rolls = (ArrayList<BEDiceRoll>) getIntent().getSerializableExtra("History");
        dates = new ArrayList<>();
        history = new ArrayList<>();
        oneThrow = new ArrayList<>();
        for (BEDiceRoll roll : rolls) {
            for(int i = 0; i < roll.getDiceRolls().size() ; i++){
                oneThrow.add(roll.getDiceRolls().get(i));
            }
            history.add(oneThrow);
        }
        adapter =
                new ArrayAdapter<ArrayList<Integer>>(this,
                        android.R.layout.simple_list_item_1, history);
        diceListView.setAdapter(adapter);
    }




}