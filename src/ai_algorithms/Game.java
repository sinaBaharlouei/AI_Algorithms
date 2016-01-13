/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.util.ArrayList;

/**
 *
 * @author Sina
 */
public final class Game {
    
    private final State start;
    private int number;
    private ArrayList<String> operator;
    
    // TIC TAC TOE
    public Game(State start) {
        this.start = start;
        this.number = 1;
        this.createGameTree(start);
        this.miniMax(start);
        System.out.println("Number: " + this.number + " Start value: " + start.getValue());
    }
    
    
    private String action(String state, String operator) {
        return null;
    }
    
    public void createGameTree(State state) {
        
        if(state.getValue() != -111)
            return;
        int turn = state.getTurn();
        char charTurn = (char) (turn + 48);
        for(int i = 0; i < 9; i++) {
            String label = state.getLabel();
            if(label.charAt(i) == '0') {
                number++;
                StringBuilder newLabel = new StringBuilder(label);
                newLabel.setCharAt(i, charTurn);
                State child = new State(newLabel.toString(), number, state);
                state.addChild(child);
                createGameTree(child);
            }
        }
    }
    
    public void miniMax(State state) {
        // 1: max 2: min
        int i, size = state.getChildrenSize();
        for(i = 0; i < size; i++) 
            miniMax(state.getChild(i));
        
        if(size > 0) {
            if(state.getTurn() == 1) // max
                state.findMax();
            else 
                state.findMin();       
        }
        
    }
}
