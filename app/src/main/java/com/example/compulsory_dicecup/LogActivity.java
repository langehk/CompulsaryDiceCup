package com.example.compulsory_dicecup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    ListView diceListView;
    ArrayList<BEDiceRoll> rolls;
    BEDiceRollAdapter beDiceRollAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        setUp();
        getData();
        configureBackButton();
        clearListViewButton();

        beDiceRollAdapter = new BEDiceRollAdapter(this, R.layout.cell, rolls);
        this.diceListView.setAdapter(beDiceRollAdapter);
    }

    private void setUp() {
        diceListView = this.findViewById(R.id.diceListView);
    }

    //Go back button
    private void configureBackButton(){
        Button backButton = findViewById(R.id.btnPrevView);
        backButton.setOnClickListener(v -> {
            returnToMain(false);
            Toast.makeText(LogActivity.this, "Back button pressed", Toast.LENGTH_SHORT).show();
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
        clearButton.setOnClickListener(v -> {
            //histBox.removeAllViews();
            Toast.makeText(LogActivity.this, "History cleared", Toast.LENGTH_SHORT).show();
            returnToMain(true);
        });

    }
    private void getData(){
        rolls = (ArrayList<BEDiceRoll>) getIntent().getSerializableExtra("History");
    }

    private ImageView makeImgView(int i) {
        ImageView img = new ImageView(this);
        img.setAdjustViewBounds(true);
        img.setMaxHeight(220);
        img.setMaxWidth(220);
        img.setPadding(15, 50, 15, 20);
        switch (i){
            case 1:
                img.setImageResource(R.drawable.dice_1_th);
                break;
            case 2:
                img.setImageResource(R.drawable.dice_2_th);
                break;
            case 3:
                img.setImageResource(R.drawable.dice_3_th);
                break;
            case 4:
                img.setImageResource(R.drawable.dice_4_th);
                break;
            case 5:
                img.setImageResource(R.drawable.dice_5_th);
                break;
            case 6:
                img.setImageResource(R.drawable.dice_6_th);
                break;
        }
        return img;
    }
}

class BEDiceRollAdapter extends ArrayAdapter<BEDiceRoll> {
    private ArrayList<BEDiceRoll> beDiceRolls;


    public BEDiceRollAdapter(Context context, int textViewResourceId, ArrayList<BEDiceRoll> beDiceRolls){
        super(context, textViewResourceId, beDiceRolls);
        this.beDiceRolls = beDiceRolls;
    }

    @Override public View getView(int position, View view, ViewGroup parent){
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.cell, null);
        }
        else {
            BEDiceRoll beDiceRoll = beDiceRolls.get(position);

            TextView timestamp = (TextView) view.findViewById(R.id.timeStamp);

            timestamp.setText(beDiceRoll.getTimeStamp().toString());
        }
        return view;
    }
}

