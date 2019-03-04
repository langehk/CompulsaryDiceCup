package com.example.compulsory_dicecup;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout box;
    Button rollDice, btnAdd, btnSub;
    int nbDice;
    TextView m_txtInfo;
    Intent intent;

    BEDiceRoll beDiceRoll;

    private ArrayList<BEDiceRoll> rollHistory = new ArrayList<>();


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nbDice = 2;
        setUp();

        intent = new Intent(this, LogActivity.class);
    }

    private void setUp() {
        m_txtInfo = this.findViewById(R.id.txtInfo);
        m_txtInfo.setText("Number of dices: " + String.valueOf(nbDice));

        box = findViewById(R.id.box);

        rollDice = findViewById(R.id.btnRoll);
        rollDice.setOnClickListener((v) -> {
            rollDice(nbDice);
        });

        btnAdd = this.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> onClickAdd());

        btnSub = this.findViewById(R.id.btnSub);
        btnSub.setOnClickListener(v -> onClickSub());

        configureNextButton();
    }


    private ImageView makeImgView(int i) {
        ImageView img = new ImageView(this);
        img.setAdjustViewBounds(true);
        img.setMaxHeight(220);
        img.setMaxWidth(220);
        img.setPadding(15, 50, 15, 20);
        switch (i) {
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

    private void rollDice(int c) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        BEDiceRoll diceRoll = new BEDiceRoll(timestamp);
        ArrayList<Integer> roll = new ArrayList<>();
        box.removeAllViews();
        Random rand = new Random();
        for (int i = 0; i < c; i++) {
            int x = rand.nextInt(6) + 1;
            box.addView(makeImgView(x));
            roll.add(x);
        }
        diceRoll.setM_diceRolls(roll);
        rollHistory.add(diceRoll);
    }

    private void onClickAdd() {
        if (nbDice > 5) {
            Toast.makeText(this, "Max 6 dices.", Toast.LENGTH_SHORT).show();
            return;
        }

        nbDice = nbDice + 1;

        m_txtInfo.setText("Number of dices: " + String.valueOf(nbDice));
    }

    private void onClickSub() {
        if (nbDice < 2) {
            Toast.makeText(this, "Atleast 1 dice needed.", Toast.LENGTH_SHORT).show();
            return;
        }

        nbDice = nbDice - 1;

        m_txtInfo.setText("Number of dices: " + String.valueOf(nbDice));
    }


    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.btnNextView);


        nextButton.setOnClickListener(view -> {
            intent.putExtra("History", rollHistory);
            startActivityForResult(intent, 1);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (data.getBooleanExtra("result",false)) {
                rollHistory.clear();
            }

        }
    }
}
