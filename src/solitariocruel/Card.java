/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariocruel;

/**
 *
 * @author Pedro
 */
public class Card {
    public static final int A = 1,
                            JACK = 11,
                            QUEEN = 12,
                            KING = 13;
    public static final char CLUB = 'C',
                             SPADE = 'S',
                             HEART = 'H',
                             DIAMOND = 'D';
    
    private char _suit;
    private int  _number;
    
    public Card(int n, char s){
        _suit = s;
        _number = n;
    }
    
    public char getSuit(){
        return _suit;
    }
    
    public int getNumber(){
        return _number;
    }
    
    private String intToString(int num){
        switch(num){
            case A: return "A";
            case JACK: return "J";
            case QUEEN: return "Q";
            case KING: return "K";
            default: return Integer.toString(num);
        }
    }
    
    public String asString(){ //ez access to props
        return intToString(_number) + _suit;
    }
}
