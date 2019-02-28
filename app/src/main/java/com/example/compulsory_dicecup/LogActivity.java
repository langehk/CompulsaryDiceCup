package com.example.compulsory_dicecup;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {
    ListView diceListView;
    ArrayList<String> test;

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

    private void setGui(){
        ArrayList<BEDiceRoll> rolls = (ArrayList<BEDiceRoll>) getIntent().getSerializableExtra("History");
        test = new ArrayList<>();
        for (BEDiceRoll roll : rolls)
        {
           test.add(roll.getTimeStamp().toString());
        }

        ListAdapter adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, test);

        diceListView.setAdapter(adapter);
    }
}