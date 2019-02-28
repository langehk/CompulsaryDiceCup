package com.example.compulsory_dicecup;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class LogActivity extends AppCompatActivity {
    ListView diceListView;
    ArrayList<String> dates = new ArrayList<>();
    ArrayList<ArrayList<Integer>> history;
    ArrayList<Integer> oneThrow = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        setUp();
        setGui();
        configureBackButton();
    }


    private void setUp() {
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
        ListAdapter adapter =
                new ArrayAdapter<ArrayList<Integer>>(this,
                        android.R.layout.simple_list_item_1, history);
        diceListView.setAdapter(adapter);
    }
}