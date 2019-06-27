/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariocruel;

import java.util.LinkedList;

/**
 *
 * @author Pedro
 */
public class Stack {
    private LinkedList<Card> _stack;
    
    public Stack(){
        _stack = new LinkedList<>();
    }
    
    //gaming purposes
    //tries a move and performs it if is possible
    public boolean move(Card c){
        Card top = _stack.getFirst();
        if (c.getNumber() == top.getNumber() + 1 || c.getSuit() != top.getSuit())
            return false;
        
        _stack.addFirst(c);
        return true;
    }
    
    public boolean popCard(){
        if (_stack.isEmpty()) return false;
        _stack.removeFirst();
        return true;
    }
   
    //logical purposes
    //returns null if there's no card below
    public Card topCard(){
        return _stack.peek();
    }
    
    //need to show the card below
    //returns null if there's not card below
    public Card secondCard(){
        return (_stack.size() > 1) ? _stack.get(1) : null;
    }
    
    public void putCard(Card c){
        _stack.addFirst(c);
    }
    
    public boolean isEmpty(){
        return _stack.isEmpty();
    }
}
