package com.example.compulsory_dicecup;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {
    LinearLayout frame, histBox;
    ListView diceListView;
    ArrayList<BEDiceRoll> rolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        setUp();
        setGui2();
        configureBackButton();
    }


    private void setUp() {
        frame = this.findViewById(R.id.frame);
        histBox = this.findViewById(R.id.histBox);
        diceListView = this.findViewById(R.id.diceListView);
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

    private void setGui2(){
        rolls = (ArrayList<BEDiceRoll>) getIntent().getSerializableExtra("History");

        for (BEDiceRoll roll: rolls) {
            LinearLayout boxen = makeBox();
            ArrayList<Integer> dice = roll.getDiceRolls();
            for (Integer d:dice) {
                boxen.addView(makeImgView(d));
            }
            histBox.addView(boxen);
        }
    }

    private LinearLayout makeBox(){
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.HORIZONTAL);
        return box;
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