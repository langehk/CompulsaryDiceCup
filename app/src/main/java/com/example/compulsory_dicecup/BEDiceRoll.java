package com.example.compulsory_dicecup;

import java.io.Serializable;


public class BEDiceRoll implements Serializable{

    private int[] m_diceRolls;
    private int m_diceId;

    public BEDiceRoll(int[] diceRolls, int id){
        m_diceRolls = diceRolls;
        m_diceId = id;
    }

    public int[] getDiceRolls(){
        return m_diceRolls;
    }

    public int getDiceId(){
        return m_diceId;
    }

    public void setDiceId(int id){
        this.m_diceId = id;
    }

    public void setM_diceRolls(int[] diceRolls) {
        this.m_diceRolls = diceRolls;
    }
}
