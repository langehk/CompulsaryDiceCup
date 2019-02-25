package com.example.compulsory_dicecup;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView m_eTxtResult;
    TextView m_txtInfo;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_eTxtResult = this.findViewById(R.id.txtResult);
        m_txtInfo = this.findViewById(R.id.txtInfo);

        Button btnAdd = this.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickAdd();
            }
        });

        Button btnSub = this.findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickSub();
            }
        });

    }

    private void onClickAdd()
    {
        
        int dices = Integer.parseInt(m_eTxtResult.getText().toString());

        if (dices > 5)
        {
            Toast.makeText(this, "Max 6 dices.", Toast.LENGTH_SHORT).show();
            return;
        }

        int result = dices + 1;

        m_eTxtResult.setText(String.valueOf(result));

        m_txtInfo.setText("Number of dices: " + String.valueOf(result));
    }

    private void onClickSub()
    {
        int dices = Integer.parseInt(m_eTxtResult.getText().toString());

        if (dices < 2)
        {
            Toast.makeText(this, "Atleast 1 dice needed.", Toast.LENGTH_SHORT).show();
            return;
        }

        int result = dices - 1;

        m_eTxtResult.setText(String.valueOf(result));

        m_txtInfo.setText("Number of dices: " + String.valueOf(result));
    }

}
