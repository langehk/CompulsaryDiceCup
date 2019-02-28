package com.example.compulsory_dicecup;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;


public class BEDiceRoll implements Serializable{

    private ArrayList<Integer> m_diceRolls = new ArrayList<Integer>();
    private java.sql.Timestamp m_timeStamp;

    public BEDiceRoll(java.sql.Timestamp timestamp){
        m_timeStamp = timestamp;
    }

    public ArrayList<Integer> getDiceRolls(){
        return m_diceRolls;
    }

   public void setM_diceRolls(ArrayList<Integer> diceRolls) {
       this.m_diceRolls = diceRolls;
    }

    public java.sql.Timestamp getTimeStamp(){
        return m_timeStamp;
    }

    public void setTimestamp(Timestamp timestamp){
        this.m_timeStamp = timestamp;
    }
}
