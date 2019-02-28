package com.example.compulsory_dicecup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout box, resBox;
    Button rollDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box = findViewById(R.id.box);
        resBox = findViewById(R.id.resBox);
        rollDice = findViewById(R.id.btnRoll);
        rollDice.setOnClickListener((v) -> {rollDice(6); });
    }

    private void rollDice(int c) {
        box.removeAllViews();
        Random rand = new Random();
        for (int i = 0; i < c; i++) {
            box.addView(makeImgView(rand.nextInt(6)+1));
        }

        //resBox.addView(box);
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

    private TextView makeTxView(int i) {
        TextView tx = new TextView(this);
        tx.setTextSize(16);
        tx.setText(""+ i);
        tx.setPadding(10, 10, 10, 10);
        return tx;
    }

}
