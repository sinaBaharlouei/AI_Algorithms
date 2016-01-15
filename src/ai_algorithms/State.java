/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author Sina
 */
public class State {
 
    private final int turn;
    private final String label;
    private final State parent;
    private final int number;
    private int value;
    private ArrayList<State> children;

    public State(String label, int number, State parent) {
        if (number != 0)
             turn = 3 - parent.getTurn(); // inverse of parent
        else turn = 1; // root -> max = 1
        
        this.label = label;
        this.parent = parent;
        this.number = number;
        children = new ArrayList<>();
        
        this.value = this.utility();
        
        //if(number == 986410)
        //    System.out.println(label + " " + utility());
    }

    public int getTurn() {
        return turn;
    }

    public String getLabel() {
        return label;
    }

    public State getParent() {
        return parent;
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }
    
    public void addChild(State child) {
        children.add(child);
    }
    
    public State getChild(int index) {
        return children.get(index);
    }
    
    public int getChildrenSize() {
        return children.size();
    }
    
    private int utility() {

        if(label.charAt(0) == label.charAt(1) && label.charAt(1) == label.charAt(2) && label.charAt(2) == '1') 
           return 1;     
        if(label.charAt(0) == label.charAt(1) && label.charAt(1) == label.charAt(2) && label.charAt(2) == '2') 
           return -1;
        
        if(label.charAt(3) == label.charAt(4) && label.charAt(4) == label.charAt(5) && label.charAt(3) == '1') 
           return 1;     
        if(label.charAt(3) == label.charAt(4) && label.charAt(4) == label.charAt(5) && label.charAt(3) == '2') 
           return -1;
        
        if(label.charAt(6) == label.charAt(7) && label.charAt(7) == label.charAt(8) && label.charAt(6) == '1') 
           return 1;     
        if(label.charAt(6) == label.charAt(7) && label.charAt(7) == label.charAt(8) && label.charAt(6) == '2') 
           return -1;
        
        if(label.charAt(0) == label.charAt(3) && label.charAt(3) == label.charAt(6) && label.charAt(6) == '1') 
           return 1;     
        if(label.charAt(0) == label.charAt(3) && label.charAt(3) == label.charAt(6) && label.charAt(6) == '2') 
           return -1;
        
        if(label.charAt(1) == label.charAt(4) && label.charAt(4) == label.charAt(7) && label.charAt(7) == '1') 
           return 1;     
        if(label.charAt(1) == label.charAt(4) && label.charAt(4) == label.charAt(7) && label.charAt(7) == '2') 
           return -1;
        
        if(label.charAt(2) == label.charAt(5) && label.charAt(5) == label.charAt(8) && label.charAt(8) == '1') 
           return 1;     
        if(label.charAt(2) == label.charAt(5) && label.charAt(5) == label.charAt(8) && label.charAt(8) == '2') 
           return -1;
        
        if(label.charAt(0) == label.charAt(4) && label.charAt(4) == label.charAt(8) && label.charAt(8) == '1') 
           return 1;     
        if(label.charAt(0) == label.charAt(4) && label.charAt(4) == label.charAt(8) && label.charAt(8) == '2') 
           return -1;
        
        if(label.charAt(2) == label.charAt(4) && label.charAt(4) == label.charAt(6) && label.charAt(6) == '1') 
           return 1;     
        if(label.charAt(2) == label.charAt(4) && label.charAt(4) == label.charAt(6) && label.charAt(6) == '2') 
           return -1;
        
        if(!label.contains("0"))
            return 0; // draw
        
        return -111;       
    }
       
    public void findMax() {
        int val;
        int max = children.get(0).getValue();
        for (State children1 : children) {
            val = children1.getValue();
            if(val == -111)
                System.out.println("Ridam");
            if (val > max) {
                max = children1.getValue();
            }
        }
        value = max;
    }
    
    public void findMin() {
        int val;
        int min = children.get(0).getValue();
        for (State children1 : children) {
            val = children1.getValue();
            if(val == -111)
                System.out.println("Ridam");
            if (val < min) {
                min = val;
            }
        }
        value = min;
    }
    
    public void printChildren() {
        int i;
        for(i = 0; i < children.size(); i++)
            System.out.println("Child[" + (i + 1) + "]: " + children.get(i).getLabel());
    }
    
    public void print() {
        int i;
        for(i = 0; i < 9; i++) {
            if(i%3 == 0)
                System.out.println("");
            if(label.charAt(i) == '1')
                System.out.print("X ");
            else if(label.charAt(i) == '2')
                System.out.print("O ");
            else
                System.out.print("- ");
        }
    }
}