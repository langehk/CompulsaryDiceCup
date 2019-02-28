package com.example.compulsory_dicecup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.compulsory_dicecup.BEDiceRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout box, resBox;
    Button rollDice;
    int nbDice;
    TextView m_txtInfo;

    BEDiceRoll beDiceRoll;

    private List<Integer> diceRoll= new ArrayList<>();


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureNextButton();
        nbDice = 2;
        m_txtInfo = this.findViewById(R.id.txtInfo);
        m_txtInfo.setText("Number of dices: " + String.valueOf(nbDice));
        box = findViewById(R.id.box);
        resBox = findViewById(R.id.resBox);
        rollDice = findViewById(R.id.btnRoll);
        rollDice.setOnClickListener((v) -> {rollDice(nbDice); });

        Button btnAdd = this.findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> onClickAdd());

        Button btnSub = this.findViewById(R.id.btnSub);

        btnSub.setOnClickListener(v -> onClickSub());

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
    private void rollDice(int c) {
        box.removeAllViews();
        Random rand = new Random();
        for (int i = 0; i < c; i++) {
            int x = rand.nextInt(6)+1;
            box.addView(makeImgView(x));
            diceRoll.add(x);
        }
    }

    private void onClickAdd()
    {
        if (nbDice > 5)
        {
            Toast.makeText(this, "Max 6 dices.", Toast.LENGTH_SHORT).show();
            return;
        }

        nbDice = nbDice + 1;

        m_txtInfo.setText("Number of dices: " + String.valueOf(nbDice));
    }

    private void onClickSub()
    {
        if (nbDice < 2)
        {
            Toast.makeText(this, "Atleast 1 dice needed.", Toast.LENGTH_SHORT).show();
            return;
        }

        nbDice = nbDice - 1;

        m_txtInfo.setText("Number of dices: " + String.valueOf(nbDice));
    }


    private void configureNextButton(){
        Button nextButton = (Button) findViewById(R.id.btnNextView);
        nextButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LogActivity.class)));
    }

}
