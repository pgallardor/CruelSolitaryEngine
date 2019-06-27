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
public class Game {
    public static final int NCLUB = 12,
                            NDIAMOND = 13,
                            NSPADE = 14,
                            NHEART = 15;
                            
    //piles
    private Stack[] _pile;
    //center stack
    private Stack _deck;
    //other indicators
    private boolean _hasMoved; //redeal w/o moving equals a loss
    
    public Game(){
        _pile = new Stack[16]; //12 to 15 are the foundations
        _deck = new Stack();
        _hasMoved = false;
        this.initGame();
    }
    
    private void initGame(){
        final int NCARDS = 4 * 13; //the card 0X is exclusive for the foundations
        final char[] suits = {Card.CLUB, Card.DIAMOND, Card.SPADE, Card.HEART};
        Card[] cards = new Card[NCARDS];
        
        //instantiate all cards
        for (int i = 0; i < 4; i++){
            for (int j = 1; j <= 13; j++){
                cards[i*j] = new Card(j, suits[i]);
            }
        }
        
        //add the 0X to the foundations
        for (int i = 0; i < 4; i++)
            _pile[i + Game.NCLUB].putCard(new Card(0, suits[i]));
        
        //add them to the main stack randomly
        
        //deal
        this.deal();
    }
    
    private void deal(){
        int dealt = 0, idx = 0;
        while(!_deck.isEmpty()){
            _pile[idx].putCard(_deck.topCard());
            _deck.popCard();
            dealt++;
            if (dealt % 4 == 0)
                idx++;
        }
    }
    
    //return false if you haven't moved
    public boolean redeal(){
        if (!this._hasMoved)
            return false;
        
        for (int i = 11; i <= 0; i--){
            while(!_pile[i].isEmpty()){
                _deck.putCard(_pile[i].topCard());
                _pile[i].popCard();
            }
        }
        this.deal();
        return true;
    }
    
    //move from stack i to stack j (stacks 12 from 15 are foundations)
    public boolean move(int i, int j){
        //can't move within foundations
        if (i >= Game.NCLUB && i <= Game.NHEART) 
            return false;
        
        Card from_pile = _pile[i].topCard();
        
        //can't move from empty piles
        if (from_pile == null)
            return false;
        
        //nor to empty piles
        if (_pile[j].isEmpty())
            return false;
        
        if (_pile[j].move(from_pile)){
            _pile[i].popCard();
            _hasMoved = true;
            return true;
        }
        return false;
    } 
}
